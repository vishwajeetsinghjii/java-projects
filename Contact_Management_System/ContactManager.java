package Contact_Management_System;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

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
        saveContactsToFile();
        System.out.println("Contact added Successfully!");
    }

    void saveContactsToFile(){
        try{
            FileWriter fw = new FileWriter("Contact_Management_System/contacts.txt",true);

            for(Contact c : contacts){
                fw.write(c.getName() + " --> " + c.getPhone() + "\n");
            }

            fw.close();

        } catch(IOException e){
            System.out.println("Error saving contacts.");
        }
    }


    void loadContactsFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Contact_Management_System/contacts.txt"));

            String line;

            while((line = reader.readLine()) != null){

                String[] parts = line.split(",");

                if(parts.length == 2){
                    Contact c = new Contact(parts[0], parts[1]);
                    contacts.add(c);
                }
            }

            reader.close();

        } catch(IOException e){
            System.out.println("No existing contacts found.");
        }
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
                saveContactsToFile();
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
                saveContactsToFile();
                System.out.println("Contact updated Successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

}
