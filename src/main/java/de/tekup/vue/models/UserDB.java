package de.tekup.vue.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class UserDB {
	
	@Getter private static List<User> users;
	private static int counter;
	
	static {
		users = new ArrayList<>();
		counter=2;
		users.add(new User(1, "John Doe", "1235", LocalDate.of(2000, 1, 1), "john@gmail.com"));
		users.add(new User(2, "Jane Doe", "1235", LocalDate.of(1999, 1, 1), "jane@gmail.com"));
	}
	
	
	public static void remove(int id) {
		users.removeIf(user->user.getId()==id);
	}

	public static void add(User user) {
		if(user.getId()==0)
			user.setId(++counter);
		else
			remove(user.getId());
		users.add(user);
	}
	
	public static User get(int id) {
		return users.parallelStream()
				.filter(user->user.getId()==id)
				.findAny().get();
	}
}
