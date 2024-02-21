package com.example.sem.service;

import java.util.ArrayList;
import java.util.List;

import com.example.sem.bean.Subject;
import com.example.sem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
	@Autowired
	public SubjectRepository subjectRepo;

	public List<Subject> getAllSubjects()
	{
		List<Subject> subjects = new ArrayList<>();
		subjectRepo.findAll().forEach(subjects::add);
		return subjects;
	}

	public void addSubject(Subject subject) {
		subjectRepo.save(subject);
		
	}

	public void updateSubject(String id, Subject subject) {
		subjectRepo.save(subject);
		
	}

	public void deleteSubject(String id) {
		subjectRepo.deleteById(id);
		
	}
}
