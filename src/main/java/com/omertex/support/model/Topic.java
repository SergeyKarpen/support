package com.omertex.support.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "topics")
@Data
public class Topic extends BaseEntity {

    @Column(name = "information")
    private String information;

    @Column(name = "user_id")
    private Long user_id;
}
