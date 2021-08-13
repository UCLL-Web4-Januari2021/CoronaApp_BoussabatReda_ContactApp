package ui.controller.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Contact;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Home extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Contact> twenty = getService().getTwenty();
            String contactJSON = this.toJSON(twenty);
            response.setContentType("application/json");
            response.getWriter().write(contactJSON);
        } catch (Exception e){
            List<Contact> twenty = getService().getTwenty();
            String contactJSON = this.toJSON(twenty);
            response.setContentType("application/json");
            response.getWriter().write(contactJSON);
        }
    }

    private String toJSON(List<Contact> contacts) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(contacts);
    }
}
