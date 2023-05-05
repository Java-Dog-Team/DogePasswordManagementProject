package com.example;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AccounterController {

    // Mongodb Connect URL
    private final String url = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
    private final String CollectionName = "JavaProject";
    private MongoClient mongoClient = MongoClients.create(url);
    private MongoDatabase database = mongoClient.getDatabase(CollectionName);

    // 電子郵件正規表達式
    private final String emailRegularExpression = "[a-zA-Z0-9._]+@([a-zA-Z0-9_]+.[a-zA-Z0-9_]+)+";

    public static final int USERNAME_NOT_EMAIL_FORMAT = 1;// 帳號不為電子郵件格式
    public static final int USERNAME_REPEAT = 2;// 帳號重複
    public static final int OK = 0;// 成功

    public void Account() {

    }
    // 帳密是否正確

    // 檢查帳號是否重複 true代表存在重複帳號
    public boolean reapeatedAccount(String username) throws Exception {

        MongoCollection<Document> collection = database.getCollection("Users");

        Document doc = collection.find(new Document("username", username)).first();

        if (doc != null)
            return true;

        return false;
    }

    // 註冊帳號 return OK代表帳號創建成功
    public int regiserAccount(String username, String password, String phone) throws Exception {

        if (!username.matches(emailRegularExpression)) {// 判斷帳號是否為email格式
            System.out.println("帳號不為email");
            return USERNAME_NOT_EMAIL_FORMAT;
        }

        if (!reapeatedAccount(username)) {// 若此帳號不重複

            String encrypPassword = AESEncryption.encrypt(password);// 將密碼加密

            MongoCollection<Document> collection = database.getCollection("Users");// 連接到資料庫

            collection.insertOne(new Document("_id", new ObjectId())// 新增新使用者
                    .append("username", username)
                    .append("password", encrypPassword));

            System.out.println("註冊成功!");
            return OK;
        }

        return USERNAME_REPEAT;

    }

}


// try () {

// MongoCollection<Document> collection = database.getCollection("Users");

// InsertOneResult result = collection.insertOne(new Document()
// .append("_id", new ObjectId())
// .append("username", "Hi")
// .append("password", "女人"));
// System.out.println("Success insert!");
// } catch (MongoException e) {
// System.out.println("Unable to insert due to an error " + e);
// }