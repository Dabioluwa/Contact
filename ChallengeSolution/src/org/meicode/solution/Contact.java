package org.meicode.solution;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private String eMail;
    private ArrayList<Message> messages;

    public Contact(String name, String number, String eMail, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.eMail = eMail;
        this.messages = messages;
    }

    public Contact(String name, String number, String eMail) {
        this.name = name;
        this.number = number;
        this.eMail = eMail;
    }

    public void getDetails () {
        System.out.println("Name: " + this.name + " " +
                "\n Number: " + this.number + " " +
                "\n eMail: " + this.eMail);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
