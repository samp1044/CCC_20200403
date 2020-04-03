package main;

import io.Input;
import level4.Flight;
import utils.Vector3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level4 {
    public static final void main(String[] args) {
        Map<Integer, Flight> flights;

        flights = Input.readFlights();

        Input.forEachFile("4", inputs -> {
            List<String> output = new ArrayList<>();
            inputs.remove(0);

            for(String line : inputs) {
                String[] splitted = line.split(",");
                int flightId = Integer.parseInt(splitted[0]);
                int timestamp = Integer.parseInt(splitted[1]);
                Flight flight = flights.get(flightId);

                output.add(flight.interpolate(timestamp));
            }

            return output;
        });
    }
}
