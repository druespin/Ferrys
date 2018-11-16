package com.akostikov.ferrys;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    Button search;
    TextView tv3;
    //Spinner spin1, spin2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        tv3 = findViewById(R.id.textView3);
    }

    public void clickSearch(View v) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/com.akostikov.datab.data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessageApi api = retrofit.create(MessageApi.class);

        Call<List<Message>> messages = api.getMessage();

        messages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful()) {

                    tv3.setText(response.body().size());
                }
                else
                    Log.d("response", response.message());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.e("failure" , t.toString());
            }
        });
    }
}
