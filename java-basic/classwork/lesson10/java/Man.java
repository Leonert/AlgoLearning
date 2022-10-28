package main.java;

import java.util.Objects;

public class Man extends Human implements Comparable {

	final int n;

	public Man(int n) {
		this.n = n;
	}

	public Man() {
		this.n = 5;
	}


	public void imMan() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Man man = (Man) o;
		return n == man.n;
	}

	@Override
	public int hashCode() {
		return Objects.hash(n);
	}

	@Override
	public String toString() {
		return "Man{" +
				"n=" + n +
				'}';
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
