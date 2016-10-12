package com.blumental.treamertestapp.repository;

import com.blumental.treamertestapp.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface TreamerService {

    String BASE_URL = "http://jsonplaceholder.typicode.com";

    @GET("/users")
    Observable<List<User>> getUsers();
}
