package org.fkit.findandlost.repository;

import java.util.List;

import org.fkit.findandlost.bean.Message;

import com.github.pagehelper.Page;

public interface MessageRepository {
	public int insertMessage(Message message);
	
	public Message findMessageById(int id);
	
	public Message findMessageByMid(int id);
	
	public Page<Message> findMessageBy(Message message);
	
	public int deleteMessage(int id);
	
	public int updateMessage(Message message);
	
	public List<Message> findMessageByUser(Integer id);
	
}
