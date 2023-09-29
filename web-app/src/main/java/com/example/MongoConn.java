package com.example;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoConn {
    private static String MONGO_URI = "mongodb://localhost:27017";
    private static MongoClient instance = null;

    // Construct a ServerApi instance using the ServerApi.builder() method
    private static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    private static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(MONGO_URI))
            .serverApi(serverApi)
            .build();

    private MongoConn() {
        System.out.println("MongoConn called");
        try {
            instance = MongoClients.create(settings);
        } catch (Exception e) {
            System.out.println("Error creating MongoClient: " + e.getMessage());
        }
    }

    private static MongoClient getInstance() {
        System.out.println("getInstance called");
        if(instance == null) {
            new MongoConn();
        }
        return instance;
    }

    public static MongoDatabase getUserDatabase() {
        MongoClient mongoClient = getInstance();
        MongoDatabase database = mongoClient.getDatabase("users");
        try {
            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            System.out.println("MongoException called");
            System.out.println(me);
        }
        return database;
    }
}
