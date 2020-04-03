package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Direction implements Comparable<Direction> {
    private String from;
    private String to;

    private List<Flight> flights;

    public Direction(String from, String to) {
        this.from = from;
        this.to = to;
        this.flights = new ArrayList<>();
    }

    public boolean addFlight(Flight flight) {
        if(flight.getFrom() == this.from && flight.getTo() == this.to) {
            if(!this.flights.contains(flight)) {
                flights.add(flight);
            }

            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Direction direction) {
        int first = this.from.compareTo(direction.from);
        int second = this.to.compareTo(direction.to);

        return first == 0 ? second : first;
    }

    @Override
    public String toString() {
        return this.from + " " + this.to + " " + this.flights.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return Objects.equals(from, direction.from) &&
                Objects.equals(to, direction.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
