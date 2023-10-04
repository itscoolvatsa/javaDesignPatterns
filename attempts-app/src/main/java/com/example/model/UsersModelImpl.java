package com.example.model;

import com.example.bean.SignupBean;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class UsersModelImpl implements IUsersModel {
    @Override
    public String createUser(SignupBean signupBean) {
        Document userDocument = new Document("name", signupBean.Name).append("email", signupBean.Email).append("password", signupBean.Password);
        MongoCollection<Document> usersDatabase = MongoDBConn.getUserCollection();
        InsertOneResult result = usersDatabase.insertOne(userDocument);
        return result.getInsertedId().toString();
    }

    // @TODO("FIndUserByEmail is remaining for signin")
    @Override
    public String findUserByEmail(String email) {
        return null;
    }
}