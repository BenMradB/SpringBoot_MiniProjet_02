package com.bilel.SpringBoot_TP01.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	
	@NotBlank(message = "User Name Field Must Have A Value .")
	@Size(min = 5, max = 20, message = "value of The user name field must be between 5 characters and 20 characters .")
	private String userName;
	
	@NotBlank(message = "First Name Field Must Have A Value .")
	@Size(min = 5, max = 10, message = "value of The first name field must be between 5 characters and 10 characters .")
	private String firstName;
	
	@NotBlank(message = "Last Name Field Must Have A Value .")
	@Size(min = 4, max = 10, message = "value of The last name field must be between 4 characters and 10 characters .")
	private String lastName;
	
	@NotBlank(message = "Email Field Must Have A Value .")
	@Email(message = "Email Field Must A Valid Email Adress Like This One 'example@test.com' .")
	private String email;
	
	@NotBlank(message = "Password Field Must Have A Value .")
	private String password;
	
	private String role;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Birthday Field Must Have A Value")
	@Past(message = "Date Of Birth Must Be From The Past .")
	private Date birthday;
	
	@OneToMany(mappedBy = "teacher")
	@JsonIgnore
	private List<Course> courses;
}
