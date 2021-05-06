package com.golaxy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class School implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String intro;

    public School(Long id, String name, String address, String intro) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.intro = intro;
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

    @ManyToMany(mappedBy = "school")
    private Set<Teacher> teachers = new HashSet<>();
}
