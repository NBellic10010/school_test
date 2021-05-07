package com.golaxy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import lombok.Builder;

@Entity
public class Match implements Serializable {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
