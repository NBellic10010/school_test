package com.golaxy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Builder;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@Table(name = "teacher")
public class Teacher implements Serializable {
    private Long userid;
    private String username;
    private String nickname;
    private String contactInfo;
    private String remark;
    private int userstatus;
    private boolean gender;
    private int age;
    private String userlevel;
    private Timestamp applyTime;
    private Timestamp enterTime;
    private Timestamp quitTime;
    private String realname;
    private boolean isMaster;

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Teacher() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    public Timestamp getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Timestamp quitTime) {
        this.quitTime = quitTime;
    }

    public void setUserid(Long id) {
        this.userid = id;
    }

    @Id
    public Long getUserid() {
        return userid;
    }
}
