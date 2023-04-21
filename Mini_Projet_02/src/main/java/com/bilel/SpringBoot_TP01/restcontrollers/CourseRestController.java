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

import com.bilel.SpringBoot_TP01.entities.Course;
import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.services.CourseService;
import com.bilel.SpringBoot_TP01.services.SpecialityService;
import com.bilel.SpringBoot_TP01.services.TeacherService;

@RequestMapping("/api/courses")
@RestController
@CrossOrigin
public class CourseRestController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private SpecialityService specialityService;

	@GetMapping
	List<Course> getAllCourses() {
		return this.courseService.getAllCourses();
	}

	@GetMapping("/{courseId}")
	Course getCourseById(@PathVariable("courseId") Long courseId) {
		return this.courseService.getCourse(courseId);
	}

	@GetMapping("/teacher_courses/{teacherId}")
	List<Course> getAllCoursesByTeacher(@PathVariable("teacherId") Long teacherId) {
		return this.courseService.findByTeacherTeacherId(teacherId);
	}

	@GetMapping("/speciality_courses/{specialityId}")
	List<Course> getAllCoursesBySpeciality(@PathVariable("specialityId") Long specialityId) {
		return this.courseService.findCoursesBySpecialityId(specialityId);
	}

	@PostMapping("/create_for/teacher/{teacherId}/under_speciality/{specialityId}")
	Course createNewCourse(@RequestBody Course course, @PathVariable("teacherId") Long teacherId,
			@PathVariable("specialityId") Long specialityId) {
		Teacher teacher = this.teacherService.getTeacher(teacherId);
		Speciality speciality = this.specialityService.getSpecialityById(specialityId);

		course.setTeacher(teacher);
		course.setSpeciality(speciality);

		return this.courseService.addCourse(course);
	}

	@PatchMapping("/{courseId}")
	Course updateCourse(@RequestBody Course course, @PathVariable("courseId") Long courseId) {
		Course oldCourseInfo = this.courseService.getCourse(courseId);

		course.setTeacher(oldCourseInfo.getTeacher());
		course.setSpeciality(oldCourseInfo.getSpeciality());

		course.setCourseId(courseId);

		return this.courseService.updateCourse(course);
	}

	@DeleteMapping("/{courseId}")
	void deleteCourse(@PathVariable("courseId") Long courseId) {
		this.courseService.deleteCourseById(courseId);
	}

}
