package Contact_Management_System;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts = new ArrayList<>();

    void addContact(String name, String phone){
        contacts.add(new Contact(name,phone));
        System.out.println("Contact added Successfully!");
    }

    void viewContacts(){
        for(Contact c : contacts){
            System.out.println(c.getName() + " " + c.getPhone());
        }
    }

    void searchContact(String name){
        boolean found = false;
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)) {
                System.out.println(c.getName() + " " + c.getPhone());
                found = true;
            }
        }
        if(!found){
            System.out.println("Contacts Not Found.");
        }
    }

    void deleteContact(String name){
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)){
                contacts.remove(c);
                System.out.println("Contact deleted Successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }



}
