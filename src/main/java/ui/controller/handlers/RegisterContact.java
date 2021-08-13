package ui.controller.handlers;

import domain.model.Contact;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterContact extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String room = request.getParameter("room");
        String dateString = request.getParameter("date");
        String gsm = request.getParameter("gsm");
        String password = request.getParameter("password");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, dateTimeFormatter);

        Contact contact = new Contact(firstName, lastName, gsm, room, date);

        getService().addContact(contact);
    }
}
