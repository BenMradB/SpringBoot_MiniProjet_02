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

import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.services.SpecialityService;

@RequestMapping("/api/sepcialities")
@RestController
@CrossOrigin
public class SpecialityRestController {
	@Autowired
	private SpecialityService specialityService;

	@GetMapping
	List<Speciality> getAllSpecialities() {
		return this.specialityService.getSpecialities();
	}

	@GetMapping("/{specialityId}")
	Speciality getSpecialityById(@PathVariable("specialityId") Long specialityId) {
		return this.specialityService.getSpecialityById(specialityId);
	}

	@PostMapping
	Speciality createNewSpeciality(@RequestBody Speciality speciality) {
		return this.specialityService.createSpeciality(speciality);
	}

	@PatchMapping("/{specialityId}")
	Speciality updateSpeciality(@PathVariable("specialityId") Long specialityId, @RequestBody Speciality speciality) {
		speciality.setSpecialityId(specialityId);
		return this.specialityService.updateSpeciality(speciality);
	}

	@DeleteMapping("/{specialityId}")
	void deleteSpeciality(@PathVariable("specialityId") Long specialityId) {
		this.specialityService.deleteSpecialityById(specialityId);
	}
}
