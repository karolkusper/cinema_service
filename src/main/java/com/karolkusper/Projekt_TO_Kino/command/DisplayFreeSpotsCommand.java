package com.karolkusper.Projekt_TO_Kino.command;

import com.karolkusper.Projekt_TO_Kino.console.ClientMenu;

import java.util.List;
import java.util.Map;

public class DisplayFreeSpotsCommand implements Command{
    Map<Integer, List<Integer>> freeSpots;

    public DisplayFreeSpotsCommand(Map<Integer, List<Integer>> freeSpots) {
        this.freeSpots = freeSpots;
    }

    @Override
    public void execute() {
        ClientMenu.displayFreeSpots(freeSpots);
    }
}
