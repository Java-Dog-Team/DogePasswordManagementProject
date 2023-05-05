package com.example;

import java.util.ArrayList;
import java.util.List;

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

    public UserInterface(String Username) {
        this.Username = Username;
        this.UserCollection = database.getCollection(Username);
    }

    // 獲取所有使用者儲存的資料
    public List<RecordData> fetchAllUserData() throws Exception {
        try {
            MongoCursor<Document> result = UserCollection.find().iterator();
            List<RecordData> finalResult = new ArrayList<>();

            while (result.hasNext()) {
                Document doc = result.next();
                finalResult.add(
                        new RecordData(doc.getString("AppName"), doc.getString("Username"),
                                AESEncryption.decrypt(doc.getString("Password"))));
            }
            System.out.println("獲取所有資料成功!");
            return finalResult;
        } catch (Exception err) {
            System.out.println("獲取所有資料失敗!");
            return null;
        }

    }

    // 獲取使用者特定資料
    public RecordData fetchOneUserData() {
        return null;
    }

    // 使用者新增一筆新資料
    public void updateOneUserData(String AppName, String Username, String Password) throws Exception {
        try {
            UserCollection.insertOne(new Document("_id", new ObjectId())
                    .append("AppName", AppName)
                    .append("Username", Username)
                    .append("Password", AESEncryption.encrypt(Password)));

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
}
