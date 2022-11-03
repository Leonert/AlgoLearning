public class User {

	int id;
	int age;
	String name;
	String surname;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}

	public User(int id, int age, String name, String surname) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public User setSurname(String surname) {
		this.surname = surname;
		return this;
	}
}
