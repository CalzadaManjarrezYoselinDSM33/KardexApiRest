package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Career;
import edu.utvt.attendance.persistence.entities.Course;
import edu.utvt.attendance.persistence.repositories.CareerRepository;
import edu.utvt.attendance.persistence.repositories.CourseRepository;

@Service
@Transactional
public class KardexServiceImplementation {
	
	@Autowired
	private CareerRepository careerRepository;
	private CourseRepository courseRepository;

	@Transactional(readOnly = false)
	public Career save(Career career) {
		return this.careerRepository.save(career);
	}

	@Transactional(readOnly = false)
	public Career update(Long id, Career career) {
		
		Optional<Career> careerOptional = null;		
		careerOptional =  this.careerRepository.findById(id);
		
		if (careerOptional.isPresent()) {
			careerOptional.get().setId(career.getId());
			careerOptional.get().setName(career.getName());
			careerOptional.get().setDescription(career.getDescription());
			careerOptional.get().setLength(career.getLength());
			careerOptional.get().setCourses(career.getCourses());
			
			this.careerRepository.save(careerOptional.get());
		}
					
		return careerOptional.orElseThrow();
	}
	
	
	
	

	public List<Course> getAll1() {
		return this.courseRepository.findAll();
	}

	public Optional<Course> findById1(Long id) {
		return this.courseRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public ResponseEntity<Course> deleteById1(Long id) {
		
		Optional<Course> courseOptional = null;		
		ResponseEntity<Course> responseEntity = null;
		
		
		courseOptional =  this.courseRepository.findById(id);
		
		if (courseOptional.isPresent()) {
			
			this.courseRepository.delete(courseOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		} else {
			responseEntity = ResponseEntity.notFound().build();
		}
			
		
		return responseEntity;
	}
	
	
	
	
	@Transactional(readOnly = false)
	public Course save(Course course) {
		return this.courseRepository.save(course);
	}

	@Transactional(readOnly = false)
	public Course update(Long id, Course course) {
		
		Optional<Course> courseOptional = null;		
		courseOptional =  this.courseRepository.findById(id);
		
		if (courseOptional.isPresent()) {
			courseOptional.get().setId(course.getId());
			courseOptional.get().setName(course.getName());
			courseOptional.get().setCareer(course.getCareer());
			courseOptional.get().setFourMonthPeriod(course.getFourMonthPeriod());
		
			
			this.courseRepository.save(courseOptional.get());
		}
					
		return courseOptional.orElseThrow();
	}

	public List<Course> getAll() {
		return this.courseRepository.findAll();
	}

	public Optional<Course> findById(Long id) {
		return this.courseRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public ResponseEntity<Course> deleteById(Long id) {
		
		Optional<Course> courseOptional = null;		
		ResponseEntity<Course> responseEntity = null;
		
		
		courseOptional =  this.courseRepository.findById(id);
		
		if (courseOptional.isPresent()) {
			
			this.courseRepository.delete(courseOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		} else {
			responseEntity = ResponseEntity.notFound().build();
		}
			
		
		return responseEntity;
	}

}
