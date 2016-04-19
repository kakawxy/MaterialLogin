package com.weico.materiallogin.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by weico on 16/4/15.
 */
public class User extends BmobUser {
    /**
     * 一句话介绍

     */
    private String intro;

    /**
     * 个人介绍
     */
    private String description;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像（路径）
     */
    private String image;

    /**
     * 所在城市
     */
    private String city;

    public String getIntro() {
        return intro;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }

    public String getCity() {
        return city;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
