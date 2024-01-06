package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

public class BaseHandler implements Handler{
    private Handler nextHandler;
    @Override
    public void setNextHandler(Handler nextHandler) {
            this.nextHandler=nextHandler;
    }

    @Override
    public void handleRequest() {
        if(nextHandler!=null)
        {
            nextHandler.handleRequest();
        }
    }
}
