package ui.controller.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Contact;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterUser extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Contact> contactList = getService().getTwenty();
        String users = objectMapper.writeValueAsString(contactList);

        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write(users);


        // Implement the changes
        String newFirstName = request.getParameter("firstName");
        String thisUserEmail = request.getParameter("email");
        String newLastName = request.getParameter("lastName");
        String newGsm = request.getParameter("gsm");
        String newPassword = request.getParameter("password");


        /*System.out.println(newFirstName);
        System.out.println(thisUserEmail);
        System.out.println(newLastName);
        System.out.println(newGsm);
        System.out.println(newPassword);*/


        Contact contact = new Contact(newFirstName, newLastName, newGsm);
        getService().addContact(contact);

    }
}
