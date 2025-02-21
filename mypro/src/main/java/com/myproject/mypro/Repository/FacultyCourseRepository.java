package com.myproject.mypro.Repository;

import com.myproject.mypro.Entity.Course;
import com.myproject.mypro.Entity.FacultyCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyCourseRepository extends JpaRepository<FacultyCourse, Integer> {
    @Query("SELECT fc.course FROM FacultyCourse fc WHERE fc.faculty.name = :facultyName")
    List<Course> findCoursesByFacultyName(@Param("facultyName") String facultyName);
}
