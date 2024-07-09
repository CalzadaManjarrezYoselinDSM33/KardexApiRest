package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Career;
import edu.utvt.attendance.persistence.entities.Course;

public interface KardexService {

public Career save(Career career);
	
	public Career update(Long id, Career career);
	
	public List<Career> getAll();
	
	public Optional<Career> findById(Long id);
	
	public ResponseEntity<Career> deleteById(Long id);
	
	
	
	public Course save1(Course course);
	
	public Career update1(Long id, Course course);

	public List<Course> getAll1();
	
	public Optional<Course> findById1(Long id);
	
	public ResponseEntity<Course> deleteById1(Long id);	
}
