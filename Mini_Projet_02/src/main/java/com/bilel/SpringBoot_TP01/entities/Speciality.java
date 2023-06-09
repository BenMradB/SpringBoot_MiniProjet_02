package com.bilel.SpringBoot_TP01.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long specialityId;
	
	@NotBlank(message = "Speciality Name Field Must Have A Value .")
	@Size(min = 4, max = 30, message = "value of The Speciality name field must be between 4 characters and 30 characters .")
	private String specialityName;
	
	@OneToMany(mappedBy = "speciality")
	@JsonIgnore
	private List<Course> courses;
}
