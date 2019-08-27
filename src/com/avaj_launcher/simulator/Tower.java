package com.avaj_launcher.simulator;

import com.avaj_launcher.Loging.Logger;
import com.avaj_launcher.interfaces.Flyable;

import java.util.LinkedList;
import java.util.List;


public class Tower {

    private List<Flyable> observes = new LinkedList<Flyable>();
    private List<Flyable> dead = new LinkedList<Flyable>();

    public void register(Flyable flyable) {
        if (observes.contains(flyable))
            return;
        observes.add(flyable);
        Logger.log("Tower Says: " + flyable.getInfo() + "registered to weather tower");
        System.out.println("Tower says:  registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        Logger.log("Tower Says: " + flyable.getInfo() + "unregistered to weather tower");
        System.out.println("Tower says:  unregistered to weather tower.");
        dead.add(flyable);

//TODO Think about unregister flyable (java.util.ConcurrentModificationException)
    }

    protected void conditionChanged() {
        observes.forEach(Flyable::updateConditions);

        for (Flyable flyable: dead) {
            observes.removeIf(flyable1 -> flyable1 == flyable);
        }
//        for (Flyable flyable: observes){
//            System.out.println(flyable.getInfo());
//        }
        System.out.println("SIZE SUKA: " + observes.size());
    }
}
