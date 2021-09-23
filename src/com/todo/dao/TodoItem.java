package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        this.current_date=sdf.format(now);
    }
    public TodoItem(String title, String desc, String date){
        this.title=title;
        this.desc=desc;
        this.current_date=date;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    
    @Override
    public String toString() {
    	return "[" + title + "] " + desc + " - " + current_date;
    }
    public String toSaveString() {
    	return title + "##" + desc + "##" + current_date + "\n";
    }
}
