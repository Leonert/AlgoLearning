public class Family {
	public int getSize() {
		return size;
	}

	private int size;


	public Human getMother() {
		return mother;
	}

	public Human getFather() {
		return father;
	}

	private Human mother;
	private Human father;

	public Family(int size, Human mother, Human father) {
		this.size = size;
		this.mother = mother;
		this.father = father;

		this.mother.setFamily(this);
		this.father.setFamily(this);

	}

	@Override
	public String toString() {
		return "Family{" +
				"size=" + size +
				", mother=" + mother +
				", father=" + father +
				'}';
	}
}
