package level2;

import java.io.File;
import java.util.Objects;

public class Flight {
    private String from;
    private String to;
    private int takeoff;

    public Flight(String from, String to, String takeoff) {
        this.from = from;
        this.to = to;
        this.takeoff = Integer.parseInt(takeoff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return takeoff == flight.takeoff &&
                Objects.equals(from, flight.from) &&
                Objects.equals(to, flight.to);
    }

    public String getFrom() {
        return from;
    }

    public int getTakeoff() {
        return takeoff;
    }

    public String getTo() {
        return to;
    }
}
