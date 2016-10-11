package com.example.administrator.pulltorefreshlistview;

/**
 * Created by Administrator on 2016-05-20.
 */
public class Bean {
    private String title;
    private String text;
    private String time;
    private String phone;

    public Bean(String title, String text, String time, String phone) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {

        return title;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public String getPhone() {
        return phone;
    }
}
