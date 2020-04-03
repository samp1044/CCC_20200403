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

}
