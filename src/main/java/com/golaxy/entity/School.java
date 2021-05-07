package com.golaxy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "school")
@Builder
public class School implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String intro;
    private int teacherMaxnum;
    private int studentMaxnum;

    public int getTeacherMaxnum() {
        return teacherMaxnum;
    }

    public void setTeacherMaxnum(int teacherMaxnum) {
        this.teacherMaxnum = teacherMaxnum;
    }

    public int getStudentMaxnum() {
        return studentMaxnum;
    }

    public void setStudentMaxnum(int studentMaxnum) {
        this.studentMaxnum = studentMaxnum;
    }

    public School() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
