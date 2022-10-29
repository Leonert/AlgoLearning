package patternDaoServiceController;

import java.util.List;

public class UserController {
	private final UserService userService;


	public UserController() {
		this.userService = new UserService();
	}


	public List<User> getUsers() {
		return userService.getUsers();
	}

	public void addUser(User user) {
		userService.addUser(user);
	}
}
