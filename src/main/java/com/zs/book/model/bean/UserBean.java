/**
 * Copyright 2017 bejson.com
 */
package com.zs.book.model.bean;

/**
 * Auto-generated: 2017-03-30 14:22:31
 *
 * @author bejson.com (i@bejson.com)
 */
public class UserBean {
    /*}{
    "figureurl_qq_1": "http:\/\/q.qlogo.cn\/qqapp\/1105124117\/C4EE9066BA01983E4F8714EAFBBF30E0\/40",
    "figureurl_qq_2": "http:\/\/q.qlogo.cn\/qqapp\/1105124117\/C4EE9066BA01983E4F8714EAFBBF30E0\/100",
    "nickname": "what happened！",
    "msg": "",
    "city": "渭南",
    "province": "陕西",
    "gender": "男",
}*/
    private String id;
    private String username;/*用户名*/
    private String password;/*密码*/
    private String nickname;
    private String sex;/*性别*/
    private String gender;
    private String phone;/*手机号*/
    private String create_time;/*注册时间*/
    private String figureurl_qq_1;
    private String figureurl_qq_2;
    private String city;
    private String province;
    private String content; /*详细说明*/
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public void setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}