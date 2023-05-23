package com.example;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

//與使用者資料庫做互動
public class UserInterface {

    private final String Username;

    // 與Mongodb連線
    private final String url = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
    private final String DatabaseName = "JavaProject";
    private MongoClient mongoClient = MongoClients.create(url);
    private MongoDatabase database = mongoClient.getDatabase(DatabaseName);
    private final MongoCollection<Document> UserCollection;

    // 物件Constructor 帳號作為參數 抓取該使用者資料
    public UserInterface(String Username) {
        this.Username = Username;
        this.UserCollection = database.getCollection(Username);// 與儲存該使用者資料的資料庫做連線
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
                // 將圖像檔轉換為BufferedImage型態
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bais);
                // 加入到List中
                finalResult.add(new RecordData(AppName, Username, Password, bufferedImage));
            }
            System.out.println("獲取所有資料成功!");
            return finalResult;
        } catch (Exception err) {// 獲取資料過程中出錯
            System.out.println("獲取所有資料失敗!");
            return null;
        }

    }

    // 獲取使用者特定資料 (還不知道須不須要)
    public RecordData fetchOneUserData(String AppName) {
        return null;
    }

    // 使用者新增一筆新資料
    public void updateOneUserData(String AppName, String Username, String Password, BufferedImage image)
            throws Exception {
        try {
            // 將新資料插入該使用者的資料庫
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            UserCollection.insertOne(new Document("_id", new ObjectId())
                    .append("AppName", AppName)
                    .append("Username", Username)
                    .append("Password", AESEncryption.encrypt(Password))
                    .append("Image", imageBytes));

            System.out.println("資料新增成功!");
        } catch (Exception err) {
            System.out.println("資料新增失敗!");

        }
    }

    // 刪除一筆資料
    public void deleteOneUserData(String AppName, String Username, String Password) throws Exception {
        try {
            UserCollection.deleteOne(new Document("AppName", AppName)
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
