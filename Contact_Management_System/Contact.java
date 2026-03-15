package Contact_Management_System;

public class Contact {
    private String name;
    private String phone;

    Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}
