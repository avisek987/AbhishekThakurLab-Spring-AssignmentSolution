package com.college.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.reg.entity.Participant;

@Repository
public interface DebateRegistrationRepository extends JpaRepository<Participant, Integer> {

}
