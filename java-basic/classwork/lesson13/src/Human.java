public class Human {

	private Family family;

	private String name;

	public Human(String name) {
		this.name = name;
	}

	String printFamily() {
		Human a = family.getFather();
		Human b = family.getMother();
		if (a == this) {
			return "Family: me, my second:" + b.name + ",size:" + family.getSize();
		} else {
			return "Family: me, my second:" + a.name + ",size:" + family.getSize();
		}

	}

	@Override
	public String toString() {
		return "Human{" +
				//"family=" + printFamily() +
				", name='" + name + '\'' +
				'}';
	}

	public void setFamily(Family family) {
		this.family = family;
	}
}
