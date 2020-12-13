package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Agenda {

    public ArrayList<Event> myAgenda = new ArrayList<>();
    public ArrayList<Event> eventsInDay = new ArrayList<>();
    public ArrayList<Event> eventByTitle = new ArrayList<>();

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
        /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        for (Event e : myAgenda){
            if (e.getTitle().equals(title)){
                eventByTitle.add(e);
            }
        }
        return eventByTitle; 
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        LocalDateTime start = e.getStart();
        LocalDateTime end = e.getEnd();
        boolean isFree=false;
        for (Event event: myAgenda){
            if(start.isAfter(event.getEnd()) || end.isBefore(event.getStart())){
                isFree=true;
            }
        }
        return isFree;
    }
}