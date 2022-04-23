package com.college.reg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.reg.entity.Participant;
import com.college.reg.repository.DebateRegistrationRepository;
import com.college.reg.service.DebateRegistration;

@Service
public class DebateRegistrationImpl implements DebateRegistration {

	@Autowired
	DebateRegistrationRepository regRepository;

	@Override
	public String save(Participant student) {
		regRepository.saveAndFlush(student);
		return "New participant: " + student.getName() + ", is added to the DB.";
	}

	@Override
	public String deleteParticipantById(int id) {
		regRepository.deleteById(id);
		return "Participant is deleted from the DB.";
	}

	@Override
	public List<Participant> findAll() {
		return regRepository.findAll();
	}

	@Override
	public Participant findById(int id) {
		return regRepository.findById(id).get();
	}

}
