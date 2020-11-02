package com.tosh.quarkus_sample;

import io.vertx.mutiny.sqlclient.Row;

public class User {
    public String name;
    public String email;

    public User() {
    }

    public static User from(Row row){
        final User user = new User();
        user.email = row.getString("email");
        user.name = row.getString("name");

        return user;
    }
}
