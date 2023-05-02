package com.example;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class AccounterController {
    public void Account() {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://say859462:0000@cluster0.n4rhnlu.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("JavaProject");
            MongoCollection<Document> collection = database.getCollection("Users");

            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("username", "test")
                    .append("password", "test"));
            System.out.println("Success insert!");
        } catch (MongoException e) {
            System.out.println("Unable to insert due to an error " + e);
        }
    }
}