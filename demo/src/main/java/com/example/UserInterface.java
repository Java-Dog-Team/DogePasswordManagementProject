package com.example;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;

//與使用者資料庫做互動
public class UserInterface {

    private final String Username;

    // 與Mongodb連線
    private final String url = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
    private final String DatabaseName = "JavaProject";
    private MongoClient mongoClient = MongoClients.create(url);
    private MongoDatabase database = mongoClient.getDatabase(DatabaseName);
    private MongoCollection<Document> colorCollection;
    private final MongoCollection<Document> UserCollection;

    // 物件Constructor 帳號作為參數 抓取該使用者資料
    public UserInterface(String Username) {
        this.Username = Username;
        this.UserCollection = database.getCollection(Username);// 與儲存該使用者資料的資料庫做連線
        this.colorCollection = database.getCollection("Color");
    }

    // 獲取所有使用者儲存的資料
    public List<RecordData> fetchAllUserData() throws Exception {
        try {
            // 從Mongodb上獲取該使用者的所有資料
            MongoCursor<Document> result = UserCollection.find().iterator();
            List<RecordData> finalResult = new ArrayList<>();

            // 迭代拿數據並存在arrayList
            while (result.hasNext()) {

                Document doc = result.next();// 抓取當前迭代器位置的資料
                String AppName = doc.getString("AppName");// 抓取AppName
                String Username = doc.getString("Username");// 抓取帳號
                String Password = AESEncryption.decrypt(doc.getString("Password"));// 抓取密碼並解密
                byte[] imageBytes = doc.get("Image", org.bson.types.Binary.class).getData();// 抓取圖像檔
                int Index = doc.getInteger("Index");

                // 將圖像檔轉換為Icon型態
                ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
                Image image = ImageIO.read(inputStream);
                Icon icon = new ImageIcon(image);
                // 加入到List中
                finalResult.add(new RecordData(AppName, Username, Password, icon, Index));
            }
            System.out.println("獲取所有資料成功!");
            return finalResult;
        } catch (Exception err) {// 獲取資料過程中出錯
            System.out.println("獲取所有資料失敗!");
            return null;
        }

    }

    // 新增一筆使用者使用的主題顏色
    public void updateOneUserColor( String Color) {
        try {

            Document query = new Document("Username", Username);

            Document update = new Document("$set", new Document("Color", Color));

            colorCollection.updateOne(query, update, new UpdateOptions().upsert(true));

            System.out.println("顏色資料上傳成功");

        } catch (Exception err) {
            System.out.println("顏色資料上傳失敗");
        }
    }

    // 獲取使用者使用主題顏色
    public String fetchOneUserColor() {
        try {
            Document query = new Document("Username", Username);
            MongoCursor<Document> cursor = colorCollection.find(query).iterator();
            System.out.println("抓取使用者顏色成功");
            if (cursor.hasNext()) {
                return cursor.next().getString("Color");
            } else
                return "yellow";

        } catch (Exception err) {
            System.out.println("抓取使用者顏色失敗");
        }
        return "yellow";
    }

    // 使用者新增一筆新資料
    public void insertOneUserData(String AppName, String Username, String Password, Icon image, int index)
            throws Exception {
        try {
            // 將新資料插入該使用者的資料庫
            BufferedImage bufferedImage = new BufferedImage(image.getIconWidth(), image.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            image.paintIcon(null, bufferedImage.getGraphics(), 0, 0);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();

            byte[] imageBytes = outputStream.toByteArray();

            UserCollection.insertOne(new Document("_id", new ObjectId())
                    .append("Index", index)
                    .append("AppName", AppName)
                    .append("Username", Username)
                    .append("Password", AESEncryption.encrypt(Password))
                    .append("Image", imageBytes));

            System.out.println("資料新增成功!");

        } catch (Exception err) {
            System.out.println("資料新增失敗!");

        }
    }

    public void updateOneUserData(RecordData OldData, RecordData NewData) {
        try {
            Icon oldIcon = OldData.getImage();
            Icon newIcon = NewData.getImage();
            BufferedImage bufferedImage = new BufferedImage(oldIcon.getIconWidth(), oldIcon.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            oldIcon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byteArrayOutputStream.flush();

            Document filter = new Document();
            filter.append("AppName", OldData.getAppName());
            filter.append("Username", OldData.getUsername());
            filter.append("Password", AESEncryption.encrypt(OldData.getPassword()));
            filter.append("Image", byteArrayOutputStream.toByteArray());
            filter.append("Index", OldData.getIndex());

            bufferedImage = new BufferedImage(newIcon.getIconWidth(), newIcon.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            newIcon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
            byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byteArrayOutputStream.flush();

            Document update = new Document("$set", new Document()
                    .append("AppName", NewData.getAppName())
                    .append("Username", NewData.getUsername())
                    .append("Password", AESEncryption.encrypt(NewData.getPassword()))
                    .append("Image", byteArrayOutputStream.toByteArray())
                    .append("Index", NewData.getIndex()));

            UserCollection.updateOne(filter, update);

            System.out.println("資料更新成功");
        } catch (Exception err) {
            System.out.println("資料更新失敗");
        }

    }

    // 刪除一筆資料
    public void deleteOneUserData(String AppName, String Username, String Password, int index) throws Exception {
        try {
            UserCollection.deleteOne(new Document("AppName", AppName)
                    .append("Index", index)
                    .append("Username", Username)
                    .append("Password", AESEncryption.encrypt(Password)));
            System.out.println("刪除資料成功!");
        } catch (Exception err) {
            System.out.println("資料刪除失敗!");
        }

    }

    public String toString() {
        return String.format("%s", "當前正在連結帳號為" + Username + "的資料庫");
    }
}
