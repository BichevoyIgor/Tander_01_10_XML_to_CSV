package com.github;

public class Article {
    private int id_art;
    private String name;
    private String code;
    private String userName;
    private String guid;

    public Article() {
    }

    public int getId_art() {
        return id_art;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getUserName() {
        return userName;
    }

    public String getGuid() {
        return guid;
    }

    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}