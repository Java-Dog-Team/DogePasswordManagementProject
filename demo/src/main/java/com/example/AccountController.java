package com.example;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//與主資料庫做互動
public class AccountController {

    // Mongodb 連線
    private final String url = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
    private final String DatabaseName = "JavaProject";
    private MongoClient mongoClient = MongoClients.create(url);
    private MongoDatabase database = mongoClient.getDatabase(DatabaseName);
    private final MongoCollection<Document> UserCollection = database.getCollection("Users");// 連接到使用者名單資料庫

    // 電子郵件正規表達式
    private final String emailRegularExpression = "[a-zA-Z0-9._]+@([a-zA-Z0-9_]+.[a-zA-Z0-9_]+)+";

    // 常數
    public static final int OK = 0;// 成功
    public static final int USERNAME_NOT_EMAIL_FORMAT = 1;// 帳號不為電子郵件格式
    public static final int USERNAME_REPEAT = 2;// 帳號重複
    public static final int USERNAME_NOT_EXIST = 3;// 帳號不存在
    public static final int USER_PASSWORD_INCORRECT = 4;// 使用者輸入的密碼錯誤

    public void Account() {

    }

    // 帳密是否正確
    public int AccountIsCorrect(String username, String password) {

        try {

            // 找尋該使用者的帳號密碼
            Document query = new Document("Username", username);
            Document result = UserCollection.find(query).first();

            if (result != null) {// 沒找到該帳號

                String encrypPassword = result.getString("Password");// 獲取該帳號的加密密碼

                if (AESEncryption.decrypt(encrypPassword).equals(password))// 將密碼解密後與使用者輸入的密碼進行比對
                    return OK;// 密碼正確
                return USER_PASSWORD_INCORRECT;// 密碼錯誤

            } else
                return USERNAME_NOT_EXIST;

        } catch (Exception err) {
            System.out.println("User collection not found!");
            return USERNAME_NOT_EXIST;
        }
    }

    // 檢查帳號是否重複 true代表存在重複帳號
    public int reapeatedAccount(String username) throws Exception {

        // 嘗試找尋該帳號
        Document query = new Document("Username", username);
        Document result = UserCollection.find(query).first();

        if (result == null) {// 若該帳號不存在
            return OK;
        }

        System.out.println("使用者帳號重複");
        return USERNAME_REPEAT;
    }

    // 註冊帳號 return OK代表帳號創建成功
    public int regiserAccount(String username, String password, String phone) throws Exception {

        if (!username.matches(emailRegularExpression)) {// 判斷帳號是否為email格式
            System.out.println("帳號不為email");
            return USERNAME_NOT_EMAIL_FORMAT;
        }

        if (reapeatedAccount(username) == OK) {// 若此帳號不重複

            String encrypPassword = AESEncryption.encrypt(password);// 將密碼加密

            UserCollection.insertOne(new Document("_id", new ObjectId())// 新增新使用者
                    .append("Username", username)
                    .append("Password", encrypPassword)
                    .append("PhoneNumber", phone));

            database.createCollection(username);// 新增屬於該使用者的資料庫

            System.out.println("註冊成功!");
            return OK;
        }

        else
            return USERNAME_REPEAT;

    }

    // 中斷與資料庫的連線
    public void disconnectMongoDB() {
        mongoClient.close();
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