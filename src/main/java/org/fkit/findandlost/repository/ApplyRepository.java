package org.fkit.findandlost.repository;

import java.util.List;

import org.fkit.findandlost.bean.Apply;

import com.github.pagehelper.Page;

public interface ApplyRepository {
	public int insertApply(Apply apply);
	
	public Apply findApplyById(int id);
	
	//public Message findMessageByMid(int id);
	
	public Page<Apply> findApplyBy(Apply apply);
	
	public int deleteApply(int id);
	
	public int updateApply(Apply apply);
	
	public int checkApply(Apply apply);
	
	public List<Apply> findApplyByUser(Integer id);
	
}
