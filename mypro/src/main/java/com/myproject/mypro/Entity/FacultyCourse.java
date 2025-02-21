package com.myproject.mypro.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "faculty_course")
public class FacultyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
