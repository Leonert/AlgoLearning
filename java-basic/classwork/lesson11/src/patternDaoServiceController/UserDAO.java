package patternDaoServiceController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {
	private final List<User> users;   // database


	public UserDAO() {
		this.users = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User u) {
		this.users.add(u);
	}
}
