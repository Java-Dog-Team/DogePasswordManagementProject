package com.example;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

//與儲存使用者資料的資料庫做互動 (帳號資料驗證)
public class AccountController {

    // Mongodb 連線
    private final String url = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
    private final String DatabaseName = "JavaProject";
    private MongoClient mongoClient = MongoClients.create(url);
    private MongoDatabase database = mongoClient.getDatabase(DatabaseName);
    private final MongoCollection<Document> UserCollection = database.getCollection("Users");// 連接到使用者名單資料庫

    // 電子郵件正規表達式
    private final String emailRegularExpression = "[a-zA-Z0-9._]+@([a-zA-Z0-9_]+.[a-zA-Z0-9_]+)+";
    // 手機正規表達式
    private final String phoneRegularEXpression = "09[0-9]{8}";
    // 常數
    public static final int OK = 0;// 成功
    public static final int USERNAME_REPEAT = 1;// 帳號重複
    public static final int USER_NOT_FOUND = 2;// 帳號不存在
    public static final int USER_PASSWORD_INCORRECT = 3;// 使用者輸入的密碼錯誤
    public static final int INPUT_FORMAT_NOT_CORRECT = 4;// 使用者輸入格式錯誤

    public void Account() {

    }

    public int AccountExist(String userInput) {
        Document query;
        Document result;
        if (userInput.matches(emailRegularExpression)) {// 檢查使用者輸入是否為電子郵件
            try {// 嘗試抓取該使用者資料
                query = new Document("Username", userInput);// 以電子郵件作為查詢參數
                result = UserCollection.find(query).first();// 抓取資料

                if (result != null) {// 若存在該使用者
                    return OK;
                } else// 不存在該使用者
                    return USER_NOT_FOUND;

            } catch (Exception err) {// 若找不到 回傳使用者不存在常數
                return USER_NOT_FOUND;
            }

        } else if (userInput.matches(phoneRegularEXpression)) {// 檢查使用者輸入是否為手機號碼
            try {
                query = new Document("PhoneNumber", userInput);
                result = UserCollection.find(query).first();
                if (result != null) {
                    // 若存在該使用者
                    return OK;
                } else// 不存在該使用者
                    return USER_NOT_FOUND;
            } catch (Exception err) {// 若找不到 回傳使用者不存在常數
                return USER_NOT_FOUND;
            }
        }

        return USER_NOT_FOUND;// 使用者輸入格式錯誤
    }

    // 檢查登入帳密是否正確
    public int AccountIsCorrect(String username, String password, int magicNumber) {

        try {

            // 找尋該使用者的帳號密碼

            Document query;
            if (magicNumber == 1) {// 若使用者輸入的為email
                query = new Document("Username", username);
            } else {// 若使用者輸入的是電話號碼
                query = new Document("PhoneNumber", username);
            }
            Document result = UserCollection.find(query).first();

            if (result != null) {// 找到該帳號

                String encrypPassword = result.getString("Password");// 獲取該帳號的加密密碼

                if (AESEncryption.decrypt(encrypPassword).equals(password))// 將密碼解密後與使用者輸入的密碼進行比對
                    return OK;// 密碼正確
                return USER_PASSWORD_INCORRECT;// 密碼錯誤

            } else// 沒找到該帳號
                return USER_NOT_FOUND;

        } catch (Exception err) {// 抓取過程出錯 沒有找到該帳號
            System.out.println("User collection not found!");
            return USER_NOT_FOUND;
        }
    }

    public int emailFormatCheck(String userInput) {
        if (userInput.matches(emailRegularExpression))
            return OK;
        return INPUT_FORMAT_NOT_CORRECT;
    }

    public int phoneFormatCheck(String userInput) {
        if (userInput.matches(phoneRegularEXpression))
            return OK;
        return INPUT_FORMAT_NOT_CORRECT;
    }

    // 忘記密碼 檢查電子郵件和手機是否存在
    public int forgetPasswordTest(String userInput) {
        Document query;
        Document result;
        if (userInput.matches(emailRegularExpression)) {// 檢查使用者輸入是否為電子郵件
            try {// 嘗試抓取該使用者資料
                query = new Document("Username", userInput);// 以電子郵件作為查詢參數
                result = UserCollection.find(query).first();// 抓取資料

                if (result != null) {// 若存在該使用者
                    return OK;
                } else// 不存在該使用者
                    return USER_NOT_FOUND;

            } catch (Exception err) {// 若找不到 回傳使用者不存在常數
                return USER_NOT_FOUND;
            }

        } else if (userInput.matches(phoneRegularEXpression)) {// 檢查使用者輸入是否為手機號碼
            try {
                query = new Document("PhoneNumber", userInput);
                result = UserCollection.find(query).first();
                if (result != null) {
                    // 若存在該使用者
                    return OK;
                } else// 不存在該使用者
                    return USER_NOT_FOUND;
            } catch (Exception err) {// 若找不到 回傳使用者不存在常數
                return USER_NOT_FOUND;
            }
        }

        return INPUT_FORMAT_NOT_CORRECT;// 使用者輸入格式錯誤

    }

    // 檢查帳號是否重複
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

    // 註冊帳號 並將新使用者資料上傳到資料庫
    public void regiserAccount(String username, String password, String phone) throws Exception {

        String encrypPassword = AESEncryption.encrypt(password);// 將密碼加密

        UserCollection.insertOne(new Document("_id", new ObjectId())// 新增新使用者
                .append("Username", username)
                .append("Password", encrypPassword)
                .append("PhoneNumber", phone));

        database.createCollection(username);// 新增屬於該使用者的資料庫

        System.out.println("註冊成功!");

    }

    // 用於忘記密碼 更新一位使用者的密碼
    public void updatePassword(String identifier, String newPassword, int magicNumber) throws Exception {
        try {
            if (magicNumber == 1) {// 若為使用email辨別
                UpdateResult updateResult = UserCollection.updateOne(Filters.eq("Username", identifier),
                        Updates.set("Password", AESEncryption.encrypt(newPassword)));
            } else {
                UpdateResult updateResult = UserCollection.updateOne(Filters.eq("PhoneNumber", identifier),
                        Updates.set("Password", AESEncryption.encrypt(newPassword)));
            }
        } catch (Exception err) {
            System.err.println(err.getStackTrace() + "更新密碼出現錯誤");
        }

    }

    // 中斷與資料庫的連線
    public void disconnectMongoDB() {
        mongoClient.close();
    }
}
