package com.bilel.SpringBoot_TP01.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@NotBlank(message = "Course Name Field Must Have A Value .")
	@Size(min = 4, max = 15, message = "value of The Course name field must be between 4 characters and 15 characters .")
	private String courseName;
	
	@NotBlank(message = "Course Description Field Must Have A Value .")
	@Size(min = 5, max = 200, message = "value of The Course Description field must be between 5 characters and 200 characters .")
	private String courseDesc;
	@ManyToOne
	private Teacher teacher;
	
	@ManyToOne
	private Speciality speciality;
}
