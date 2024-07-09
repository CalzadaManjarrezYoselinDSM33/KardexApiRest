package edu.utvt.attendance.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "tc_courses")
public class Course implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4120669496925196193L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Course(Long id, String name, Integer fourMonthPeriod, Career career) {
		super();
		this.id = id;
		this.name = name;
		this.fourMonthPeriod = fourMonthPeriod;
		this.career = career;
	}

	@Override
	public int hashCode() {
		return Objects.hash(career, fourMonthPeriod, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(career, other.career) && Objects.equals(fourMonthPeriod, other.fourMonthPeriod)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
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

	public Integer getFourMonthPeriod() {
		return fourMonthPeriod;
	}

	public void setFourMonthPeriod(Integer fourMonthPeriod) {
		this.fourMonthPeriod = fourMonthPeriod;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false)
	private Integer fourMonthPeriod;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private Career career;
}
