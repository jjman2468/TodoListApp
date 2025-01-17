package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
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
    public TodoItem(String title, String desc, String category, String due_date) {
    	this.title = title;
    	this.desc = desc;
    	this.current_date = sdf.format(now);
    	this.category = category;
    	this.due_date = due_date;
    }
    public TodoItem(String title, String desc, String category, String due_date, String date) {
    	this.title = title;
    	this.desc = desc;
    	this.current_date = date;
    	this.category = category;
    	this.due_date = due_date;
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
    	return "[" + category + "] "+ title + " - "+ desc + " - " + due_date + " - " + current_date;
    }
    public String toSaveString() {
    	return category + "##" + title + "##" + desc + "##" + due_date + "##" + current_date + "\n";
    }
}
