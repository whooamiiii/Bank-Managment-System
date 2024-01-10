
public class CreateAccount {
	String firstname, secondname;
	int age, AccountNr, PIN;
	double balance;
	
	CreateAccount(String firstname, String secondname, int age, double balance, int accountnr, int PIN){
		this.firstname = firstname;
		this.secondname = secondname;
		this.age = age;
		this.balance = balance;
		this.AccountNr = accountnr;
		this.PIN = PIN;
	}
	
	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public int getAccountNr() {
		return AccountNr;
	}

	public void setAccountNr(int konotnr) {
		this.AccountNr = konotnr;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	void Withdraw(double Amount) {
		balance = balance - Amount;
	}
	
	void Deposit(double Amount) {
		balance = balance + Amount;
	}
	
	void Balance() {
		System.out.println("Balance: " + balance);
	}
}
