import java.util.*;
public class main {
	static Scanner s = new Scanner(System.in);
	static ArrayList<CreateAccount> Clients = new ArrayList<CreateAccount>();
	static int AccountNumber = 4;
	static int PIN, OldPin, NewPin, RepeatPin;
	static int Tries = 2;
	
	static void ExistingAccounts() {
		Clients.add(new CreateAccount("Gustavo", "Fring", 43, 123,1,2564));
		Clients.add(new CreateAccount("Walter", "White", 42, 123,2,1234));
		Clients.add(new CreateAccount("Jesse", "Pinkman", 23, 123,3,0000));
		Clients.add(new CreateAccount("Hank", "Schrader", 38, 123,4,1111));
	}
	
	static void Menu() {
		ExistingAccounts();
		System.out.println("Choose one: ");
		System.out.println("");
		System.out.println("1. Create account");
		System.out.println("2. Check Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Change PIN");
		System.out.println("6. Exit");
		
		int option = s.nextInt();
		switch(option) {
			case 1:
				Create();
				break;
			case 2:
				CheckBalance();
				break;
			case 3:
				Deposit();
				break;
			case 4:
				Withdraw();
				break;
			case 5:
				ChangePin();
				break;
			case 6:
				Exit();
		}
	}
	
	static void Create() {
		System.out.print("Enter your first name: ");
		String firstname = s.next();
		System.out.print("Enter your last name: ");
		String lastname = s.next();
		System.out.print("Enter your age: ");
		int age = s.nextInt();
		System.out.print("Enter a 4 digit PIN: ");
		PIN = s.nextInt();
		AccountNumber = AccountNumber+1;
		Clients.add(new CreateAccount(firstname, lastname, age, 0,AccountNumber, PIN));
		System.out.println("");
		System.out.println("You have successfully created an account.");
		System.out.println("Your account number is: " + AccountNumber);
		System.out.println("");
		System.out.println("/////////////////////////////");
		System.out.println("");
		Menu();
		
	}
	
	static void CheckBalance() {
		System.out.print("Enter your account number: ");
		int accountnr = s.nextInt();
		for(int x = 0; x<Clients.size();x++) {
			if(Clients.get(x).getAccountNr() == accountnr) {
				System.out.print("Enter PIN: ");
				 PIN = s.nextInt();
				if(Clients.get(x).getPIN() == PIN) {
					System.out.println("Your balance is: " + Clients.get(x).getBalance());
					System.out.println("");
					Menu();
					
				}else {
					System.out.println("Wrong PIN");
					System.out.println("");
					Menu();
				}
			}
		}
		Menu();
	}
	
	static void Deposit() {
		System.out.print("Enter your account number: ");
		int accountnr = s.nextInt();
		for(int x = 0; x<Clients.size();x++) {
			if(Clients.get(x).getAccountNr() == accountnr) {
				System.out.print("Enter the amount you want to deposit: ");
				double amount = s.nextDouble();
				Clients.get(x).Deposit(amount);
				System.out.println("The amount of: " + amount + " Euros has been successfully deposited.");
				System.out.println("");
				Menu();
			}
		}
	}

	static void Withdraw() {
		System.out.print("Enter your account number: ");
		int accountnr = s.nextInt();
		for(int x = 0; x<Clients.size();x++) {
			if(Clients.get(x).getAccountNr() == accountnr) {
				System.out.print("Enter PIN: ");
				PIN = s.nextInt();
				if(Clients.get(x).getPIN() == PIN) {
					System.out.print("Enter the amount you want to withdraw: ");
					double amount = s.nextDouble();
					Clients.get(x).Withdraw(amount);
					System.out.println("The amount of: " + amount + " Euros has been withdrawn.");
					System.out.println("");
					Menu();
				}else {
					System.out.println("Wrong PIN.");
					System.out.println("");
					Menu();
				}
			}
		}
	}
	
	static void ChangePin() {
		System.out.print("Enter your account number: ");
		int accountnr = s.nextInt();
		for(int x = 0; x<Clients.size();x++) {
			if(Clients.get(x).getAccountNr() == accountnr) {
				System.out.print("Enter your old pin: ");
				OldPin = s.nextInt();	
				if(Clients.get(x).getPIN() == OldPin) {
					System.out.print("Enter new pin: ");
					NewPin = s.nextInt();
					if(NewPin == OldPin) {
						System.out.println("Your new pin cannot be the same as your old one.");
						pinchange();
					}else {
						System.out.print("Repeat new pin: ");
						RepeatPin = s.nextInt();
					}
					if(NewPin == RepeatPin) {
						Clients.get(x).setPIN(NewPin);
						System.out.println("Pin changed successfully");
						Menu();
					}else if(NewPin != RepeatPin){
						while(Tries >0) {
							System.out.println("");
							System.out.println("The new pins do not match!");
							System.out.println("You have " + Tries + " more tries left.");
							System.out.println("");
							pinchange();
							if(NewPin == RepeatPin) {
								Clients.get(x).setPIN(NewPin);
								System.out.println("Pin changed successfully");
								Menu();
							}
							Tries--;
						}
						System.out.println("You have tried too many times!");
						Menu();
					}
				}else {
					System.out.println("You have entered the wrong pin!");
					System.out.println("");
					Menu();
				}
			}
		}
	}
	
	static void pinchange() {
		System.out.print("Enter new pin: ");
		NewPin = s.nextInt();
		System.out.print("Repeat new pin: ");
		RepeatPin = s.nextInt();
	}
	
	static void Exit() {
		System.out.println("Have a nice day");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Menu();
	}
}
