package Contact_Management_System;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts = new ArrayList<>();

    boolean contactExists(String name){
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println("Contact already exist");
                return true;
            }
        }
        return false;
    }

    void addContact(String name, String phone){
        if(contactExists(name)){
            return;
        }
        contacts.add(new Contact(name,phone));
        System.out.println("Contact added Successfully!");
    }

    void viewContacts(){
        System.out.println();
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

    void editContact(String name, String newPhone){
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)){
                c.setPhone(newPhone);
                System.out.println("Contact updated Successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

}
