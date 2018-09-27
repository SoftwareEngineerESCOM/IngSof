package com.san;

import javax.persistence.*;

@Entity
public class ModelTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public ModelTemplate() {
        
    }
}