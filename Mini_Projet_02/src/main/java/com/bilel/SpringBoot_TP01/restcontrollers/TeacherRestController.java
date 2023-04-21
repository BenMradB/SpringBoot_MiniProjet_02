package com.bilel.SpringBoot_TP01.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.services.TeacherService;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin
public class TeacherRestController {
	@Autowired
	private TeacherService teacherService;

	@GetMapping
	List<Teacher> getAllTeachers() {
		return this.teacherService.getAllTeachers();
	}

	@GetMapping("/{teacherId}")
	Teacher getTeacherById(@PathVariable("teacherId") Long teacherId) {
		return this.teacherService.getTeacher(teacherId);
	}

	@PostMapping
	Teacher createNewTeacher(@RequestBody Teacher teacher) {
		return this.teacherService.createTeacher(teacher);
	}

	@PatchMapping("/{teacherId}")
	Teacher updateTeacher(@PathVariable("teacherId") Long teaherId, @RequestBody Teacher teacher) {
		teacher.setTeacherId(teaherId);
		return this.teacherService.updateTeacher(teacher);
	}

	@DeleteMapping("/{teacherId}")
	void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
		this.teacherService.deleteTeacherById(teacherId);
	}
}
