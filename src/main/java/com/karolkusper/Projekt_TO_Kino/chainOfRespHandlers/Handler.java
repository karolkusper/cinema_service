package com.karolkusper.Projekt_TO_Kino.chainOfRespHandlers;

public interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest();
}
