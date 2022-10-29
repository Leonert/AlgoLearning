package patternDaoServiceController;

import java.util.List;

public class UserService {

	private final UserDAO userDAO;

	UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	public void addUser(User user) {
		user.setSurname("BLA");  // business
		userDAO.addUser(user);
	}
}
