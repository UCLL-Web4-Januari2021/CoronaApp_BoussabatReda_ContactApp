package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contact {

    private String firstName, lastName, gsm, email, room;
    private LocalDate date;

    public Contact(String firstName, String lastName, String gsm, String room, LocalDate date) {
        setFirstName(firstName);
        setLastName(lastName);
        setGsm(gsm);
        setEmail();
        setRoom(room);
        setDate(date);
    }

    public Contact(String firstName, String lastName, String gsm) {
        setFirstName(firstName);
        setLastName(lastName);
        setGsm(gsm);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@ucll.be";
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void changeEmail(String thisUserEmail) {
        this.email = thisUserEmail;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gsm='" + gsm + '\'' +
                ", email='" + email + '\'' +
                ", room='" + room + '\'' +
                ", date=" + date +
                '}';
    }
}
