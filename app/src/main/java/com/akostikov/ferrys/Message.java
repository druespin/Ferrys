package com.akostikov.ferrys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message  {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("time")
    @Expose
    private long time;
    @SerializedName("text")
    @Expose
    private String text;

    public Message(long id, long time, String text) {
        this.id = id;
        this.time = time;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}
