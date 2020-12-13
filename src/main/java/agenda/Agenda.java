package agenda;

import java.time.LocalDate;
import java.util.*;

public class Agenda {

    public ArrayList<Event> myAgenda = new ArrayList<>();
    public ArrayList<Event> eventsInDay = new ArrayList<>();

    public void addEvent(Event e) {
        myAgenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        for (Event e : myAgenda) {
            if (e.isInDay(day)){
                eventsInDay.add(e);
            }
        }
        return eventsInDay;
    }
}