package main;

import io.Input;
import level2.Direction;
import level2.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level2 {
    public static final void main(String[] args) {
        Input.forEachFile("2", inputs -> {
            List<String> output = new ArrayList<>();
            List<Direction> directions = new ArrayList<>();
            inputs.remove(0);

            for(String line : inputs) {
                String[] splitted = line.split(",");
                String a = splitted[4];
                String b = splitted[5];
                String takeoff = splitted[6];

                Direction direction = new Direction(a, b);

                if(directions.contains(direction)) {
                    direction = directions.get(directions.indexOf(direction));
                } else {
                    directions.add(direction);
                }

                direction.addFlight(new Flight(a, b, takeoff));
            }

            Collections.sort(directions);

            for(Direction d : directions) {
                output.add(d.toString());
            }

            return output;
        });
    }
}
