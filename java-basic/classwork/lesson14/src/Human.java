import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Human {
	String name;

	List<String> friends = new ArrayList<>();

	public Human(String name, List<String> friends) {
		this.name = name;
		this.friends.addAll(friends);
	}

	public List<String> getFriends() {
		return friends;
	}


	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Human addFriend(String friend) {
		this.friends.add(friend);
		return this;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public String getName2() {
		if (name != null) return name;
		else getSomeEx();
		return null;
	}

	// Exception example

	private String getSomeEx() {
		throw new MyException();
	}
	public Human removeFriend(Predicate<? super String> pred) {
		friends = friends.stream().filter(pred.negate()).collect(Collectors.toList());
		return this;
	}

	@Override
	public String toString() {
		return "Human{" +
				"name='" + name + '\'' +
				", friends=" + friends +
				'}';
	}
}
