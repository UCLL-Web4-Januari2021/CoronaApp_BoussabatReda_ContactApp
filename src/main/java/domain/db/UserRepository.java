package domain.db;

import domain.model.User;

import java.util.ArrayList;

import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        User user = new User("peter", "peeters", "t", "peter.peeters@hotmail.com");
        User userA = new User("A", "A", "t", "A.A@hotmail.com");
        User userB = new User("B", "B", "t", "B.B@hotmail.com");
        User userC = new User("C", "C", "t", "C.C@hotmail.com");
        add(user);
        add(userA);
        add(userB);
        add(userC);
        user.setPositive(true);
        userA.setPositive(true);
        userB.setPositive(true);
    }

    public void add(User user){
        users.add(user);
    }

    public User CorrectLogin(String mail, String password) {
        User user = null;
        for (User u : users){
            if(u.getEmail().equalsIgnoreCase(mail) && u.getPassword().equalsIgnoreCase(password)){
                user = u;
            }
        }
        return user;
    }

    public User getUser(String email){
        User user = new User();
        for(User u : users){
            if(u.getEmail().equalsIgnoreCase(email)){
                user = u;
            }
        }
        return user;
    }

    public User findUser(String name){
        for(User u : users){
            if(u.getFirstname().equalsIgnoreCase(name)){
                return u;
            }
        }
        return null;
    }
}
