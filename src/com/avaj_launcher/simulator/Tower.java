package com.avaj_launcher.simulator;

import com.avaj_launcher.Loging.Logger;
import com.avaj_launcher.interfaces.Flyable;

import java.util.LinkedList;
import java.util.List;


public class Tower {

    private final List<Flyable> observes = new LinkedList<>();
    private final List<Flyable> dead = new LinkedList<>();

    public void register(Flyable flyable) {
        if (observes.contains(flyable))
            return;
        observes.add(flyable);
        Logger.log("Tower Says: " + flyable.getInfo() + "registered to weather tower");
    }

    public void unregister(Flyable flyable) {
        Logger.log("Tower Says: " + flyable.getInfo() + "unregistered to weather tower");
        dead.add(flyable);
    }

    protected void conditionChanged() {
        observes.forEach(Flyable::updateConditions);

        for (Flyable flyable : dead) {
            observes.removeIf(flyable1 -> flyable1 == flyable);
        }
    }

    public boolean hasMoreRegistredObjects(){
        return !observes.isEmpty();
    }
}
