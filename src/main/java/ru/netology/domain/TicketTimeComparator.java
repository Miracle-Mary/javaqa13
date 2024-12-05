package ru.netology.domain;

import java.util.Comparator;


public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int timeOfFlight1 = t1.getTimeTo() - t1.getTimeFrom();
        int timeOfFlight2 = t2.getTimeTo() - t2.getTimeFrom();

        if (timeOfFlight1 < timeOfFlight2) {
            return -1;
        } else if (timeOfFlight1 > timeOfFlight2) {
            return 1;
        } else {
            return 0;
        }
    }

}
