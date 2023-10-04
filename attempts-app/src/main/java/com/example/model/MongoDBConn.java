package com.example.model;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBConn {
    private static final String MONGODB_URI = "mongodb://localhost:27017";
    private static final String DATABASE = "users";
    private static final String COLLECTION = "users";
    private static MongoClient instance = null;

    // Construct a ServerApi instance using the ServerApi.builder() method
    private static final ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    private static final MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(MONGODB_URI))
            .serverApi(serverApi)
            .build();

    private MongoDBConn() {
        System.out.println("MongoDBConn called");
        try {
            instance = MongoClients.create(settings);
        } catch (Exception e) {
            System.out.println("Error creating MongoClient: " + e.getMessage());
        }
    }

    private static MongoClient getInstance() {
        System.out.println("getInstance called");
        if (instance == null) {
            new MongoDBConn();
        }
        return instance;
    }

    private static MongoDatabase getUserDatabase() {
        MongoClient mongoClient = getInstance();
        MongoDatabase database = mongoClient.getDatabase(DATABASE);
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

    public static MongoCollection<Document> getUserCollection() {
        MongoDatabase usersDatabase = getUserDatabase();
        return usersDatabase.getCollection(COLLECTION);
    }
}
