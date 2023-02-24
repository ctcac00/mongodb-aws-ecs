package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class App {

    public static void main(String[] args) {
        String uri = System.getenv("MONGODB_URI");
        MongoClient mongoClient = MongoClients.create(
                uri);

        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("movies");
        System.out.println("Fetching doc...");
        Document doc = collection.find().first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            System.out.println(doc.toJson());
        }

        mongoClient.close();
        System.out.println("mongoClient closed");
    }
}