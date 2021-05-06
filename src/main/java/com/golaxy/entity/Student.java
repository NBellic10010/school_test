package com.golaxy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student implements Serializable {
    private Long userid;
    private String username;
    private boolean gender;
    private int age;
    private int userlevel;
    private String contactInfo;
    private int userstatus;
    private String remarks;
    private Date applyTime;
    private Date enterTime;
    private Date quitTime;
    private String nickname;
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Student(Long userid, String username,
                   boolean gender, int age, int userlevel,
                   String contactInfo, int userstatus,
                   String remarks, Date applyTime,
                   Date enterTime, Date quitTime, int state, String nickname,
                   String realname) {
        this.userid = userid;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.userlevel = userlevel;
        this.contactInfo = contactInfo;
        this.userstatus = userstatus;
        this.remarks = remarks;
        this.applyTime = applyTime;
        this.enterTime = enterTime;
        this.quitTime = quitTime;
        this.nickname = nickname;
        this.realname = realname;
    }

    public Student() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUserid(Long id) {
        this.userid = id;
    }

    @Id
    public Long getUserid() {
        return userid;
    }

    @ManyToMany(targetEntity = Myclass.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_class_rel",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id")}
    )
    private Set<Myclass> classes = new HashSet<>();

    @ManyToMany(targetEntity = Teacher.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "teacher_student_rel",
            joinColumns = {@JoinColumn(name = "student", referencedColumnName = "username")},
            inverseJoinColumns = {@JoinColumn(name = "teacher", referencedColumnName = "username")}
    )
    private Set<Teacher> teachers = new HashSet<>();
}
