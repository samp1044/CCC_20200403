package main;

import io.Input;
import level2.Direction;
import level2.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level3 {
    public static final void main(String[] args) {
        Input.forEachFile("3", inputs -> {
            List<String> output = new ArrayList<>();
            output.remove(0);

            for(String line : inputs) {
                String[] splitted = line.split(",");
                String lat = splitted[0];
                String longitude = splitted[1];
                String altitude = splitted[2];


            }

            return output;
        });
    }
}
