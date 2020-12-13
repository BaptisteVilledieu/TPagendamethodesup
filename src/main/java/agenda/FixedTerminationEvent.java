package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FixedTerminationEvent extends RepetitiveEvent {
    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    
    LocalDate terminationInclusive;
    
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        this.terminationInclusive = terminationInclusive;

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    
    long numberOfOccurrences;
    
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public LocalDate getTerminationDate() {
        LocalDate end;
        end = this.getStart().plus(numberOfOccurrences-1, this.getFrequency()).toLocalDate();
        return end; 
    }

    public long getNumberOfOccurrences() {
        LocalDate start, end;
        start = this.getStart().toLocalDate();
        end = terminationInclusive;
        
        while(end.isAfter(start)){
            numberOfOccurrences +=1;
            end = end.minus(1, this.getFrequency());
        }
        return numberOfOccurrences;
    }
        
}
