package org.fkit.findandlost.service;

import java.sql.Timestamp;
import java.util.List;

import org.fkit.findandlost.bean.Apply;
import org.fkit.findandlost.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

@Service
public class ApplyService {

	@Autowired
	private ApplyRepository applyRepository;
	
	public int insertApply(Apply apply) {
//		初始化发布留言的时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		apply.setA_rtime(time);
		apply.setA_status("未审核");
		System.out.println(apply);
		return applyRepository.insertApply(apply);
	}
	
	public int updateApply(Apply apply) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		apply.setA_rtime(timestamp);
		System.out.println(apply);
		return applyRepository.updateApply(apply);
	}
	
	public int checkApply(Apply apply) {
		return applyRepository.checkApply(apply);
	}
	
	public int deleteApply(int id) {
		return applyRepository.deleteApply(id);
	}
	
	public Apply findApplyById(int id) {
		return applyRepository.findApplyById(id);
	}
	
	public Page<Apply> findApplyBy(Apply apply) {
		return applyRepository.findApplyBy(apply);
	}
	
	public List<Apply> findApplyByUser(Integer id){
		return applyRepository.findApplyByUser(id);
	}
}
