package com.khunwana.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	public static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Monias",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Nqobizitha",LocalDate.now().minusYears(24)));
		users.add(new User(++usersCount,"Khunwana",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User findOne(int id)
	{
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
}
