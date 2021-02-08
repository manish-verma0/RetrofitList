package com.example.retrofitlist.model.pojo;
import com.google.gson.annotations.SerializedName;



public class RetroPhoto {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("image")
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
