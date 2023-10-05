package com.example.model;

import com.example.bean.SigninBean;
import com.example.bean.SignupBean;
import com.example.utils.Pair;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Date;
import java.util.Objects;

public class UsersModelImpl implements IUsersModel {
    @Override
    public String createUser(SignupBean signupBean) {
        Document userDocument = new Document("name", signupBean.Name)
                .append("email", signupBean.Email)
                .append("password", signupBean.Password)
                .append("lastAttempt", new Date())
                .append("attemptCount", 0);
        MongoCollection<Document> usersDatabase = MongoDBConn.getUserCollection();
        InsertOneResult result = usersDatabase.insertOne(userDocument);
        return Objects.requireNonNull(result.getInsertedId())
                      .asObjectId()
                      .getValue()
                      .toString();
    }

    // @TODO("FIndUserByEmail is remaining for signin")
    @Override
    public SigninBean findUserByEmail(String email) {
        MongoCollection<Document> usersDatabase = MongoDBConn.getUserCollection();
        Bson filter = Filters.eq("email", email);
        Document userDocument = usersDatabase.find(filter)
                                             .first();
        if (userDocument == null) {
            return null;
        }

        String name = userDocument.getString("name");
        String password = userDocument.getString("password");
        Date lastAttempt = userDocument.getDate("lastAttempt");
        Integer attemptCount = userDocument.getInteger("attemptCount");

        SigninBean signinBean = new SigninBean(name, email, password, attemptCount, lastAttempt);

        return signinBean;
    }

    @Override
    public Pair<Date, Integer> findUserByEmailAndUpdateDate(String email) {
        MongoCollection<Document> usersDatabase = MongoDBConn.getUserCollection();
        Bson filter = Filters.eq("email", email);
        Document userDocument = usersDatabase
                .find(filter)
                .first();
        if (userDocument == null) {
            return null;
        }
        Date lastAttempt = new Date();
        Integer attemptCount = userDocument.getInteger("attemptCount");
        if(attemptCount >= 3) {
            attemptCount = 1;
        }else{
            attemptCount ++;
        }

        Bson updateDocument = Updates.combine(
                Updates.set("attemptCount", attemptCount),
                Updates.set("lastAttempt", lastAttempt)
        );

        usersDatabase
                .findOneAndUpdate(Filters.eq("email", email), updateDocument);
        return new Pair<>(lastAttempt, attemptCount);
    }

    @Override
    public void findUserByEmailAndUpdateAttempts(String email, int attempts) {
        MongoCollection<Document> usersDatabase = MongoDBConn.getUserCollection();

        Date lastAttempt = new Date();
        Bson updateDocument = Updates.combine(
                Updates.set("attemptCount", attempts),
                Updates.set("lastAttempt", lastAttempt)
        );

        usersDatabase
                .findOneAndUpdate(Filters.eq("email", email), updateDocument);
    }
}