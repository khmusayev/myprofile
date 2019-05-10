package com.myprofile.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprofile.entity.User;
import com.myprofile.entity.UserEducation;
import com.myprofile.service.UserEducationService;
import com.myprofile.service.UserService;

@RestController
@RequestMapping("/userapi/users/{userId}")
public class UserEducationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserEducationService userEducationService;

	@GetMapping("/studies")
	public List<UserEducation> getAllStudies(@PathVariable int userId) {

		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		List<UserEducation> studies = userEducationService.findAll(userId);
		return studies;
	}

	@PostMapping("/studies")
	public UserEducation addStudyEntry(@PathVariable int userId, @RequestBody UserEducation theJob) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		theJob.setId((long) 0);
		theJob.setUser(theUser.get());
		userEducationService.save(theJob);
		return theJob;
	}
	
	@PutMapping("/studies/{studyId}")
	public UserEducation updateStudyEntry(@PathVariable int userId, @PathVariable int studyId, @RequestBody UserEducation theJob) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		List<UserEducation> studies = userEducationService.findAll(userId);
		if(studyId >= studies.size()) {
			throw new RuntimeException("UserJob id not found - " + userId);
		}
		long edittedstudyId = studies.get((int) studyId).getId();
		theJob.setUser(theUser.get());
		theJob.setId(edittedstudyId);
		userEducationService.save(theJob);
		return theJob;
	}
	
	@DeleteMapping("/studies/{studyId}")
	public String deleteStudyEntry(@PathVariable int userId, @PathVariable int studyId) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		List<UserEducation> studies = userEducationService.findAll(userId);
		if(studyId >= studies.size()) {
			throw new RuntimeException("UserJob id not found - " + userId);
		}
		long deletedstudyId = studies.get((int) studyId).getId();
		userEducationService.delete(studies.get((int) studyId));
		return "Deleted userJob id - " + deletedstudyId;
	}

}
