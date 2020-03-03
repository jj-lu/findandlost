package org.fkit.findandlost.service;

import java.sql.Timestamp;
import java.util.List;

import org.fkit.findandlost.bean.Message;
import org.fkit.findandlost.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public int insertMessage(Message message) {
//		初始化发布留言的时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		message.setM_rtime(time);
		System.out.println(message);
		return messageRepository.insertMessage(message);
	}
	
	public int updateMessage(Message message) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		message.setM_rtime(timestamp);
		System.out.println(message);
		return messageRepository.updateMessage(message);
	}
	
	public int deleteMessage(int id) {
		return messageRepository.deleteMessage(id);
	}
	
	public Message findMessageById(int id) {
		return messageRepository.findMessageByMid(id);
	}
	
	public Page<Message> findMessageBy(Message message) {
		return messageRepository.findMessageBy(message);
	}
	
	public List<Message> findMessageByUser(Integer id){
		return messageRepository.findMessageByUser(id);
	}
}
