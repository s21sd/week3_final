package com.springmvc.pmvc.dao;
import java.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import com.springmvc.pmvc.beans.*;
public class Studentdao {
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	public int save(Student s) {
		String qry="insert into student values(" + s.getRollno() + ",'"+s.getName() + "')";
		return jdbcTemplate.update(qry);
	}
	public List<Student> getStudents() {
	    String qry = "SELECT * FROM student";
	    return jdbcTemplate.query(qry, new RowMapper<Student>() {
	        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Student student = new Student();
	            student.setRollno(rs.getInt("rollno"));
	            student.setName(rs.getString("name"));
	            return student;
	        }
	    });
	}


}
