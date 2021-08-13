package ui.controller;

import domain.Service;

public class ControllerFactory {

    public RequestHandler getController(String key, Service model) {
        return createHandler(key, model);
    }

    private RequestHandler createHandler(String handlerName, Service model) {
        RequestHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("ui.controller.handlers."+ handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }
        return handler;
    }
}
