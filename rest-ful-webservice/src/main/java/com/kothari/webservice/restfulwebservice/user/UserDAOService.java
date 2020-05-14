package com.kothari.webservice.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	private static int userCount =5;
	
	static {
		users.add(new User(1,"Ram",new Date()));
		users.add(new User(2,"Tom",new Date()));
		users.add(new User(3,"Tim",new Date()));
		users.add(new User(4,"SIM",new Date()));
		users.add(new User(5,"YOUN",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		
		
		return user;
	}
	
	public User findUser(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User DeleteUser(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
		User user =iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				users.remove(id);
				return user;
			}
		}
		
		return null;
	}
		
	
	
}
