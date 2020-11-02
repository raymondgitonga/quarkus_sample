package com.tosh.quarkus_sample;


import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.Row;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/user")
public class UserResource {
    @Inject
    MySQLPool pool;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<List<User>> hello() {
        return pool.query("SELECT * FROM nubi_email")
                .map(rows -> {
                    final List<User> users = new ArrayList<>();
                    for (Row row: rows){
                        users.add(User.from(row));
                    }
                    return users;
                }).subscribeAsCompletionStage();
    }

}
