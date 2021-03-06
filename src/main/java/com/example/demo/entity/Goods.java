package com.example.demo.entity;

public class Goods {
    private int gid;
    private int uid;
    private String name;
    private int num;
    private String price;
    private String description;
    private String image;
    private String created;
    private String updated;
    private String token;
    private String encoderUid;

    public Goods() {
    }

    public Goods(int gid, int uid, String name, int num, String price, String description, String image, String created, String updated, String token, String encoderUid) {
        this.gid = gid;
        this.uid = uid;
        this.name = name;
        this.num = num;
        this.price = price;
        this.description = description;
        this.image = image;
        this.created = created;
        this.updated = updated;
        this.token = token;
        this.encoderUid = encoderUid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", token='" + token + '\'' +
                ", encoderUid='" + encoderUid + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncoderUid() {
        return encoderUid;
    }

    public void setEncoderUid(String encoderUid) {
        this.encoderUid = encoderUid;
    }
}
