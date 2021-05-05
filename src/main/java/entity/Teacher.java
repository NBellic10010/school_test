package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
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
    private int state;
    private Date applyTime;
    private Date enterTime;
    private Date quitTime;

    Teacher(Long id, String username, String nickname, String contactInfo, String remark,
                   int userstatus, boolean gender, int age,
                   String userlevel, int state,
                   Date applyTime, Date enterTime, Date quitTime) {
        this.userid = id;
        this.username = username;
        this.nickname = nickname;
        this.contactInfo = contactInfo;
        this.remark = remark;
        this.userstatus = userstatus;
        this.gender = gender;
        this.age = age;
        this.userlevel = userlevel;
        this.state = state;
        this.applyTime = applyTime;
        this.enterTime = enterTime;
        this.quitTime = quitTime;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public void setUserid(Long id) {
        this.userid = id;
    }

    @Id
    public Long getUserid() {
        return userid;
    }

    @ManyToMany(targetEntity = Myclass.class, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_class_rel",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id")}
    )
    private Set<Myclass> classes = new HashSet<Myclass>();

    @ManyToMany(targetEntity = School.class, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_school_rel",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "school_id", referencedColumnName = "id")}
    )
    private Set<School> schools = new HashSet<School>();
}
