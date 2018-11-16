package com.akostikov.ferrys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface MessageApi {

    @GET("messages1.json")
    Call<List<Message>> getMessage();
}
