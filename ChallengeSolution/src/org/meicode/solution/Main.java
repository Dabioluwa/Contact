package org.meicode.solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Bonjour_fam");
        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("What are you gonna do today" +
                "\n 1. Manage Contacts " +
                "\n 2. Messages " +
                "\n 3. Quit"
        );
        scanner = new Scanner(System.in);
        int choice =  scanner.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("What exactly are you gonna do: " +
                "\n 1. Show all messages" +
                "\n 2. Send a message" +
                "\n 3. Go back"
        );
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendMessage() {
        System.out.println("Who are you gonna text today? ");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter a valid reciepient");
        }else {
            boolean doesExist = false;
            for (Contact c: contacts){
                if (c.getName().equals(name)){
                    doesExist=true;
                }
            }
            if (doesExist){
                System.out.println("What are you gonna say today");
                String text = scanner.next();
                if (text.equals("")){
                    System.out.println("Enter message");
                    sendMessage();
                }else{
                    id++;
                    Message newMSG = new Message(text, name, id);
                    for (Contact c: contacts){
                        if (c.getName().equals(name)){
                            ArrayList<Message> newMSGs = c.getMessages();
                            newMSGs.add(newMSG);
                            Contact currentContact = c;
                            currentContact.setMessages(newMSGs);
                            contacts.remove(c);
                            contacts.add(currentContact);
                        }
                    }
                }
            }else {
                System.out.println("The contact does not exist on this device");
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> MSG = new ArrayList<>();
        for (Contact c: contacts){
            MSG.addAll(c.getMessages());
        }
        if (MSG.size()>0){
            for (Message m: MSG){
                m.getDetails();
                System.out.println("*********");
            }
        }else {
            System.out.println("You do not have any message on this device");
        }
    }

    private static void manageContacts(){
        System.out.println("What exactly are gonna you do: " +
                "\n 1. Show all contacts" +
                "\n 2. Add a new contact" +
                "\n 3. Search for a contact" +
                "\n 4. Delete a contact" +
                "\n 5. Go back"
        );
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Who's name are we gonna delete today");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter a valid contact");
            deleteContact();
        }else {
            boolean doesExist = false;
            for (Contact c: contacts){
                doesExist = true;
                contacts.remove(c);
            }if (!doesExist){
                System.out.println("Contact does not exist on your device");
            }
        }
    }

    private static void searchContact() {
        System.out.println("Who are gonna find today: ");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter a valid name");
        }else {
            boolean doesExist = false;
            for (Contact c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist){
                System.out.println("Contact does not exist on your device");
            }
        }
        showInitialOptions();
    }

    private static void addContact() {
        System.out.println("Adding new contact..." +
                "\n Enter contact's name: "
        );
        String name = scanner.next();
        System.out.println("Enter contact's phone number: ");
        String number = scanner.next();
        System.out.println("Enter contact's Email: ");
        String eMail = scanner.next();

        if (name.equals("") || number.equals("") || eMail.equals("")){
            System.out.println("Please enter all the required information");
            addContact();
        }else{

            boolean doesExist = false;
            for (Contact c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                }
            }

            if(doesExist){
                System.out.println("A contact has already been named " + name );
            }else {
                Contact contact = new Contact(name, number, eMail);
                contacts.add(contact);
                System.out.println(name + " saved successfully");
            }
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contact c: contacts){
            c.getDetails();
            System.out.println("**********");
        }
        showInitialOptions();
    }
}
