/* 
File: AddressBook.java
Class: Main
Author: Ahmad Safrin & Ahmad Zarith Imran
Description: Java code to display the information for Employee Address Book at most 10 people.
*/

import java.util.Scanner;

public class AddressBook {
    private Contact[] contacts; // Array to store contacts
    private int ctr;            // Counter to keep track of the number of contacts
    private Scanner scanner;    // Scanner object for user input

    public AddressBook() {
        contacts = new Contact[10];       // Initialize the contacts array with a capacity of 10
        ctr = 0;                          // Initialize the counter to 0
        scanner = new Scanner(System.in); // Initialize the scanner for user input
    }

    public void addContact() {
        if (ctr >= contacts.length) {
            System.out.println("Address book is full. Cannot add more employee,");
            return;
        } //If the counter at maximum capacity, diplay a limitation message. Prompt again

        // Prompt the user for contact details
		System.out.println("Enter Name: ");
        String name = scanner.nextLine();
		
        // Validate and get the phone number from the user
		String phoneNumber;
		
        while (true) {
            System.out.print("Enter Phone Number: ");
            Scanner scanner = new Scanner(System.in);
            phoneNumber = scanner.nextLine();

            if (phoneNumber.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter only numbers.");
            }
        } // If the input is not the same as the required information, prompt again
		
		// Get the email address from the user
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
		
		// Get the department from the user
		System.out.println("Enter Department: ");
        String department = scanner.nextLine();
		
		// Validate and get the room number from the user
		String roomNumber;
        while (true) {
            System.out.print("Enter your Room Number: ");
            Scanner scanner = new Scanner(System.in);
            roomNumber = scanner.nextLine();

            if (roomNumber.matches("\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter only four digit.");
            }
        } // If the input is not the same as the required information, prompt again

        // Create a new contact object with the provided details
		Contact contact = new Contact(name, phoneNumber, email, department, roomNumber);
        
		// Add the contact to the contacts array and increment the counter
		contacts[ctr] = contact;
        ctr++;

        System.out.println("");
        System.out.println("Contact added successfully!");
		System.out.println("");
		
    }

    public void viewContact() {
		// Display the information for each contact in the address book
		System.out.println("------------EMPLOYEE CONTACTS------------");
    for (int i = 0; i < ctr; i++) {
        System.out.println("-----------------------------------------");
		System.out.println("");
        System.out.println("The information for employee " + contacts[i].getName() + " is:");
        System.out.println(contacts[i]);
		System.out.println("");
        
    }
}

    public void editContact() {
		// Prompt the user for the contact name to be edited
        System.out.println("Enter the name of the contact that you want to edit:");
        String searchName = scanner.nextLine();
		
        // Search for the contact in the address book
        for (int i = 0; i < ctr; i++) {
            if (contacts[i].getName().equalsIgnoreCase(searchName)) {
                // Prompt the user for updated contact details
				System.out.println("Enter your phone number: ");
                String newPhoneNumber = scanner.nextLine();
                contacts[i].setPhoneNumber(newPhoneNumber);

                System.out.println("Enter your email: ");
                String newEmail = scanner.nextLine();
                contacts[i].setEmail(newEmail);
				
				System.out.println("Enter your department: ");
                String newDepartment = scanner.nextLine();
                contacts[i].setDepartment(newDepartment);
				
				System.out.println("Enter your room number: ");
                String newRoomNumber = scanner.nextLine();
                contacts[i].setRoomNumber(newRoomNumber);

                System.out.println("Contact edited successfully!");
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    public void workHour() {
        if (ctr == 0) {
            System.out.println("Address book is empty. Nothing to input.");
			System.out.println("");
            
            return;
        }
		
        System.out.print("Please enter the time in the HH:mm format ");
		System.out.println("");
		System.out.print("09:30 for 9:30 AM or 17:45 for 5:45 PM) in 24-hour system. ");
		System.out.println("");
		System.out.println("Enter the name of the contact to be searched:");
        String searchName = scanner.nextLine();

        for (int i = 0; i < ctr; i++) {
            if (contacts[i].getName().equalsIgnoreCase(searchName)) {
                
				// Prompt the user for the start and end times
				System.out.print("Enter the start time (in HH:mm format): ");
				String start = scanner.nextLine();
                String[] startTime = start.split(":");
                int startHour = Integer.parseInt(startTime[0]);
                int startMinute = Integer.parseInt(startTime[1]);

                System.out.print("Enter the end time (in HH:mm format): ");
                String end = scanner.nextLine();
                String[] endTime = end.split(":");
                int endHour = Integer.parseInt(endTime[0]);
                int endMinute = Integer.parseInt(endTime[1]);

            // Calculate the total working hours
			int totalHours;
                 if (endHour > startHour) {
                 totalHours = endHour - startHour;
                 } else {
                 totalHours = 24 - startHour + endHour;
        }

            int totalMinutes = endMinute - startMinute;
                 if (totalMinutes < 0) {
                 totalMinutes += 60;
                 totalHours--;
        }
               
		    System.out.println("");
            System.out.println( searchName +" total working hours: " + totalHours + " hours and " + totalMinutes + " minutes");
		    System.out.println("");
				
                return;
            }
        } // Required user to follow the input as same as the condition. Programme will be executed

        System.out.println("");
		System.out.println("Contact not found!");
		
    }

    public void displayMenu() {
        while (true) {
            System.out.println("-----------------------------------------");
			System.out.println("-------EMPLOYEES ADDRESS BOOK MENU-------");
			System.out.println("-----------------------------------------");
            System.out.println("1. Add New Contact");
            System.out.println("2. View Existing Employee");
            System.out.println("3. Edit Employee Information");
            System.out.println("4. Clock-in/out Calculator");
            System.out.println("5. Exit");
			
            // Ask the user to choose the menu number
			System.out.println("Enter your choice:");
			int choice = Integer.parseInt(scanner.nextLine());
			System.out.println("");
			System.out.println("-----------------------------------------");
			
            
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    workHour();
                    break;
                case 5:
                    System.out.println("         Exiting the Address Book        ");
					System.out.println("-----------------------------------------");
					System.out.println("");
					System.out.println("***************안녕히가세요****************");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            } // If the input is not the same as the required information, prompt again
        }
    }
}