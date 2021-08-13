package domain.db;

import domain.model.Contact;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public ContactRepository() {
    }

    public List<Contact> getTwenty() {
        return contacts;
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> searchByDate(LocalDate date){
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getDate().equals(date)){
                result.add(contact);
            }
        }
        return result;
    }


    public List<Contact> searchContact(LocalDate date, String room) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getDate().equals(date) && contact.getRoom().trim().equalsIgnoreCase(room)){
                result.add(contact);
            }
        }
        return result;
    }

    public Set<String> allRooms() {
        Set<String> rooms = new HashSet<>();
        for (Contact c: contacts) {
            rooms.add(c.getRoom());
        }
//        System.out.println(topThree());
        return rooms;
    }

    public Map<String, Integer> topThree() {
        Map<String, Integer> topThree = new HashMap<>();
        for(String room : allRooms()){
            topThree.put(room, 0);
        }
        for (Contact contact : contacts){
            for(String room : allRooms()){
                if(contact.getRoom().equalsIgnoreCase(room)) {
                    topThree.put(room,topThree.get(room) +1);
                }
            }
        }


        return topThree;
    }


    public Contact get(String email) {
        Contact contact = null;
        for (Contact c: contacts){
            if(c.getEmail().equalsIgnoreCase(email)){
                contact = c;
            }
        }
        return contact;
    }
}
