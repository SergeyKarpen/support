package com.omertex.support.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;


@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}
