package com.avaj_launcher.simulator;

import com.avaj_launcher.Loging.Logger;
import com.avaj_launcher.interfaces.Flyable;

import java.util.ArrayList;
import java.util.Iterator;

public class Tower {

    private ArrayList<Flyable> observes = new ArrayList<Flyable>();
//    private ArrayList<Flyable> dead = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observes.contains(flyable))
            return ;
        observes.add(flyable);
        Logger.log("Tower Says: " + flyable.getInfo() + "registered to weather tower");
        System.out.println("Tower says:  registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        Logger.log("Tower Says: " + flyable.getInfo() + "unregistered to weather tower");
        System.out.println("Tower says:  unregistered to weather tower.");

        observes.removeIf(flyable1 -> flyable1 == flyable);

//TODO Think about unregister flyable (java.util.ConcurrentModificationException)
    }

    protected void conditionChanged() {
        observes.forEach(Flyable::updateConditions);
    }
}
