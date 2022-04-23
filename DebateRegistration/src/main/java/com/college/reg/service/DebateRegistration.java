package com.college.reg.service;

import java.util.List;

import com.college.reg.entity.Participant;

public interface DebateRegistration {

	public String save(Participant student);

	public String deleteParticipantById(int id);

	public List<Participant> findAll();

	public Participant findById(int id);
}
