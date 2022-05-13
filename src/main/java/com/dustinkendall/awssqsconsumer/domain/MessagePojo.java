package com.dustinkendall.awssqsconsumer.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MessagePojo
{
    private int id;
    private String text;

    //@JsonProperty("use this annotation if json key doesn't match the pojo")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessagePojo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
