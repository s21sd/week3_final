package com.myproject.mypro.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    private int id;

    private String name;
    private String email;
    private String password;
    private String mob;
}
