package domain;

import domain.db.ContactRepository;
import domain.db.UserRepository;
import domain.model.Contact;
import domain.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Service {

    private final ContactRepository repository = new ContactRepository();
    private final UserRepository userRepository = new UserRepository();
    private final ArrayList<String> positives = new ArrayList<>();

    public Service() {
    }

    public List<Contact> getTwenty(){
        return repository.getTwenty();
    }

    public void addContact(Contact contact) {
        repository.add(contact);
    }

    public List<Contact> searchByDate(LocalDate date) {
        return repository.searchByDate(date);
    }

    public List<Contact> searchContact(LocalDate date, String room) {
        return repository.searchContact(date, room);
    }

    public void addUser(User user) {
        userRepository.add(user);
    }

    public User CorrectLogin(String mail, String password) {
        return userRepository.CorrectLogin(mail, password);
    }

    public User getUser(String email){
        return userRepository.getUser(email);
    }

    public void addPositive(String name) {
        positives.add(name);
    }

    public ArrayList<String> getPositives() {
        return positives;
    }

    public User findUser(String name) {
        return userRepository.findUser(name);
    }

    public Set<String> allDifferentRooms() {
        return repository.allRooms();
    }

    public Contact get(String email){
        return repository.get(email);
    }

    public Map<String, Integer> topThree(){
        return repository.topThree();
    }
}
