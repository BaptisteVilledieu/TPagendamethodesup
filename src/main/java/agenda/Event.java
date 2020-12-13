package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Event {

    private String myTitle;
    private LocalDateTime myStart;
    private Duration myDuration;
    private ArrayList<LocalDateTime> daysofEvent = new ArrayList<>();
    protected boolean isInDay= false; //booleen indique si l'evenement est dans un jour choisi
    private LocalDateTime myEnd; 
    

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        //On calcule d'abord la différence entre le debut et la fin de l'evenement
        int dayStart = myStart.getDayOfMonth();
        int dayEnd = this.getEnd().getDayOfMonth();
        int diff = dayEnd - dayStart;
        
        //On ajoute le jour du debut de l'evenement
        daysofEvent.add(myStart);
        
        //On ajoute ensuite les autres jours de l'evenement
        for (int i = 1; i <= diff; i++) {
            daysofEvent.add(myStart.plus(i, ChronoUnit.DAYS));
            System.out.println(daysofEvent);
        }
        
        //On teste la presence du jour en parametre
        for (LocalDateTime d : daysofEvent){
            if(d.toLocalDate().equals(aDay)){
                isInDay=true;
            }
        }
        return isInDay;
    }

    public String getTitle() {
        return myTitle;
    }

    public LocalDateTime getStart() {
        return myStart;
    }

    public Duration getDuration() {
        return myDuration;
    }
    
    public LocalDateTime getEnd(){
        this.myEnd = this.myStart.plus(this.myDuration.toMinutes(), ChronoUnit.MINUTES);
        return this.myEnd;
    }
    public String toString(){
        return myTitle;
    }

}
