package apps;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean running = true;
		double balance = 100000.0; // initial balance

		// Account number input and validation
		System.out.print("Enter your 10-digit account number: ");
		String accountNumber = input.nextLine();

		if (!(accountNumber.length() == 10 && accountNumber.matches("\\d{10}"))) {
			System.out.println("Error: Account number must be exactly 10 digits long and numeric.");
			input.close();
			return; // Exit the program
		}

		System.out.println("Account number accepted: " + accountNumber);

		// Main loop
		while (running) {
			// Display menu
			System.out.println("\n--- Main Menu ---");
			System.out.println("1. Enter Account Number Again");
			System.out.println("2. View Balance");
			System.out.println("3.Withdraw");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice;
			if (input.hasNextInt()) {
				choice = input.nextInt();
				input.nextLine(); // Consume newline
			} else {
				System.out.println("Invalid input. Please enter a number.");
				input.nextLine(); // Consume invalid input
				continue;
			}

			switch (choice) {
			case 1:
				// Form 2: Enter Account Number
				while (true) {
					System.out.print("Enter 10-digit account number (or type 'back'): ");
					String acc = input.nextLine();

					if (acc.equalsIgnoreCase("back")) {
						break; // back to main menu
					} else if (acc.matches("\\d{10}")) {
						System.out.println("Account number accepted: " + acc);
						break;
					} else {
						System.out.println("Invalid account number.");
					}
				}
				break;

			case 2:
				// Form 3: View Balance (simulated)
				System.out.println("Your balance is: $1,00,000");
				break;

			case 3:
				// Form 4: Withdraw
				System.out.print("Enter amount to withdraw: ");

				if (input.hasNextDouble()) {
					double amount = input.nextDouble();
					input.nextLine(); // consume newline

					if (amount <= 0) {
						System.out.println("Amount must be greater than zero.");
					} else if (amount > balance) {
						System.out.println("Insufficient balance. Your current balance is: $" + balance);
					} else {
						balance -= amount;
						System.out.println("Withdrawal successful. New balance is: $" + balance);
					}
				} else {
					System.out.println("Invalid amount. Please enter a number.");
					input.nextLine(); // consume invalid input
				}
				break;

			case 4:
				// Exit the app

				System.out.println("Thank you for using the bank app.");
				running = false;
				break;

			default:
				System.out.println("Invalid option. Try again.");
			}
		}

		input.close();
	}
}
