package org.fkit.findandlost.service;

import org.fkit.findandlost.bean.Classification;
import org.fkit.findandlost.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassificationService {

	@Autowired
	private ClassificationRepository classificationRepository;
	
	public int findC_id(Classification classification) {
		return classificationRepository.findC_id(classification);
	}
}
