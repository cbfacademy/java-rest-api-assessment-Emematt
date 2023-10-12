package com.cbfacademy.apiassessment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@MappedSuperclass
public class Abstract implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @JsonProperty("id")
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "create_date", updatable = false)
    protected LocalDateTime created;

    @PrePersist
    protected  void onCreate(){
        created = LocalDateTime.now();
    }


}
