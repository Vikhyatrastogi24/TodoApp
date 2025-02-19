package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "Note_Taker")
public class TODO {
@Id
    private int id;
    private String title;
    @Column(length = 2000)
    private String description;
    private Date addedDate;

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TODO() {
        super();
    }

    public TODO(Date addedDate, String description, String title) {
        this.addedDate = addedDate;
        this.description = description;
        this.id = new Random().nextInt(10000);
        this.title = title;
    }

}
