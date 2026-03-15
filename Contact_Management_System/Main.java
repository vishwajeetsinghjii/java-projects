package Contact_Management_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while(true){
            System.out.println("\n 1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    System.out.println("Enter name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter phone");
                    String phone = sc.nextLine();
                    manager.addContact(name,phone);
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    System.out.println("Enter the name : ");
                    String sname = sc.nextLine();
                    manager.searchContact(sname);
                    break;

                case 4:
                    System.out.println("Enter the name : ");
                    String dname = sc.nextLine();
                    manager.deleteContact(dname);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter correct Input");
            }
        }

    }
}
