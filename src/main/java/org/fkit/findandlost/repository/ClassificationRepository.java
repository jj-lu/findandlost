package org.fkit.findandlost.repository;

import org.fkit.findandlost.bean.Classification;

public interface ClassificationRepository {

	public int findC_id(Classification classification);
	
	public Classification findClassificationById(Integer id);
}
