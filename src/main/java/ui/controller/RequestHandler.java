package ui.controller;

import domain.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class RequestHandler {

    private Service contactService;

    public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void setModel (Service contactService) {
        this.contactService = contactService;
    }

    public Service getService() {
        return contactService;
    }






}
