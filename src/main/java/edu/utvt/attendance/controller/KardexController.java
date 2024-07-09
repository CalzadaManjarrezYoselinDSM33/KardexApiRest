package edu.utvt.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.utvt.attendance.persistence.entities.Career;
import edu.utvt.attendance.persistence.entities.Course;
import edu.utvt.attendance.persistence.service.KardexService;


public class KardexController {

	@Autowired
	private KardexService kardexService;
	
	@GetMapping
	public List<Career> get() {
		return this.kardexService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Career> save(@RequestBody Career career) {
		return ResponseEntity.created(null).body(this.kardexService.save(career));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Career> update(@PathVariable("id") Long id,  @RequestBody Career career) {
		return ResponseEntity.ok(this.kardexService.update(id, career));
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Career> delete(@PathVariable("id") Long id) {
		return this.kardexService.deleteById(id);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Career> findById(@PathVariable("id") Long id) {
		return ResponseEntity.of(this.kardexService.findById(id));
	}
	
	
	
	
	
	@GetMapping
	public List<Course> get1() {
		return this.kardexService.getAll1();
	}
	
	@PostMapping
	public ResponseEntity<Course> save1(@RequestBody Course course) {
		return ResponseEntity.created(null).body(this.kardexService.save1(course));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Career> update1(@PathVariable("id") Long id,  @RequestBody Course course) {
		return ResponseEntity.ok(this.kardexService.update1(id, course));
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Course> delete1(@PathVariable("id") Long id) {
		return this.kardexService.deleteById1(id);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById1(@PathVariable("id") Long id) {
		return ResponseEntity.of(this.kardexService.findById1(id));
	}
}
