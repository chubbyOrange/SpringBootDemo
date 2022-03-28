package com.example;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book /* implements Comparable */ {
    @TableId
    private String bid = null;

    private String name = null;
    private String title = null;
    private float price = 0.0F;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date year;

    @JsonIgnore
    private String description = null;

    public Book() {
    }

    public Book(String bid, String name, String title,
            float price, Date year, String description) {
        this.bid = bid;
        this.name = name;
        this.title = title;
        this.price = price;
        this.year = year;
        this.description = description;
    }

    public String getbid() {
        return bid;
    }

    public void setbid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getyear() {
        return year;
    }

    public void setyear(Date year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // @Override
    // public int compareTo(Object o) {
    // Books n = (Books) o;
    // int lastCmp = title.compareTo(n.title);
    // return (lastCmp);
    // }

    @Override
    public String toString() {
        return "Book [bid=" + bid + ", name=" + name + ", title=" + title + ", price=" + price + ", year="
                + year + ", description=" + description + "]";
    }
}
