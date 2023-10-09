package com.example.model;

import com.example.utils.LoggerUtil;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConn {
    private static final String MONGODB_URI = "mongodb://localhost:27017";
    private static final String DATABASE = "users";
    private static final String COLLECTION = "users";
    // Construct a ServerApi instance using the ServerApi.builder() method
    private static final ServerApi serverApi = ServerApi
            .builder()
            .version(ServerApiVersion.V1)
            .build();
    private static final MongoClientSettings settings = MongoClientSettings
            .builder()
            .applyConnectionString(new ConnectionString(MONGODB_URI))
            .serverApi(serverApi)
            .build();
    private static MongoClient instance = null;

    private MongoDBConn() {
        try {
            instance = MongoClients.create(settings);
            LoggerUtil
                    .getInstance(MongoDBConn.class)
                    .info("mongodb instance is created");
        } catch (Exception e) {
            LoggerUtil
                    .getInstance(MongoDBConn.class)
                    .fatal("Error creating MongoClient: " + e.getMessage());
        }
    }

    private static MongoClient getInstance() {
        if (instance == null) {
            LoggerUtil
                    .getInstance(MongoDBConn.class)
                    .info("new database accessed");
            new MongoDBConn();
        }
        return instance;
    }

    private static MongoDatabase getUserDatabase() {
        MongoClient mongoClient = getInstance();
        return mongoClient.getDatabase(DATABASE);
    }

    public static MongoCollection<Document> getUserCollection() {
        MongoDatabase usersDatabase = getUserDatabase();
        return usersDatabase.getCollection(COLLECTION);
    }
}
