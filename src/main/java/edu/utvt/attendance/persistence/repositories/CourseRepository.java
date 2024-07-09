package edu.utvt.attendance.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
