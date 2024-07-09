package edu.utvt.attendance.persistence.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "te_carrers")
public class Career {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Career(Long id, String name, String description, Double length, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.length = length;
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, description, id, length, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Career other = (Career) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(length, other.length)
				&& Objects.equals(name, other.name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 500)
	private String description;
	
	@Column(nullable = false)
	private Double length;
	
	@JsonIgnore
	@OneToMany(mappedBy = "career")
	private List<Course> courses; 
}
