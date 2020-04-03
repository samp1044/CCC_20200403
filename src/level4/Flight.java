package level4;

import utils.Vector3;

import java.nio.file.StandardWatchEventKinds;
import java.util.HashMap;
import java.util.Map;

public class Flight {
    private int id;
    private String start;
    private String end;
    private int takeoff;

    private Map<Integer, String> positions;

    public Flight(int id, String start, String end, int takeoff) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.takeoff = takeoff;

        this.positions = new HashMap<>();
    }

    public Flight(int id, String start, String end, int takeoff, Map<Integer,String> positions) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.takeoff = takeoff;

        this.positions = positions;
    }

	@Override
	public String toString() {
		return "Flight [id=" + id + ", start=" + start + ", end=" + end + ", takeoff=" + takeoff + ", positions="
				+ positions + "]";
	}

    public String interpolate(int timestamp) {
        if (this.positions.containsKey(timestamp)) {
            return this.positions.get(timestamp);
        } else {
            int lower = timestamp, higher = timestamp;
            double latMin, latMax, loMin, loMax, altMin, altMax;
            double la, lo, alt;
            String[] splitted;

            for(;lower >= takeoff && this.positions.containsKey(lower) == false; lower--);
            for(;this.positions.containsKey(higher) == false; higher++);

            splitted = this.positions.get(lower).split(",");
            latMin = Double.parseDouble(splitted[0]);
            loMin = Double.parseDouble(splitted[1]);
            altMin = Double.parseDouble(splitted[2]);

            splitted = this.positions.get(lower).split(",");
            latMax = Double.parseDouble(splitted[0]);
            loMax = Double.parseDouble(splitted[1]);
            altMax = Double.parseDouble(splitted[2]);

            la = (latMin + latMax) / 2;
            lo = (loMin + loMax) / 2;
            alt = (altMin + altMax) / 2;

            return la + " " + lo + " " + alt;
        }
    }
}
