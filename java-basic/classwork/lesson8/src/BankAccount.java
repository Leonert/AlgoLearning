public class BankAccount {

	private int bankAccountNumber;
	private int balance;

	public void showBalance() {
		System.out.println(this.balance);
	}

	public void putMoney(int money) {
		if (money < 0) {
			// show error
			return;
		}

		balance += money;
	}
}
