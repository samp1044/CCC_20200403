package level1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Level1 {
    public static void run() {
        File file = new File("input/1");

        for(File f : file.listFiles()) {
            List<String> inputs = new ArrayList<>();

            try (
                    FileReader fr = new FileReader(f);
                    BufferedReader nr = new BufferedReader(fr);
                    )
            {
                String line;

                while((line = nr.readLine()) != null) {
                    inputs.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            inputs.remove(0);

            inputs = findMax(inputs);

            try (
                    FileWriter fw = new FileWriter("output/1/out." + f.getName());
                    ) {
                for(String line: inputs) {
                    fw.write(line + System.getProperty("line.separator"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static List<String> findMax(List<String> input) {
        int minTimestamp, maxTimestamp, intval;
        double minLat, maxLat, minLong, maxLong, maxAltitude, doubleval;

        List<String> results = new ArrayList<>();

        minTimestamp = Integer.MAX_VALUE;
        maxTimestamp = Integer.MIN_VALUE;
        minLat = minLong = Double.MAX_VALUE;
        maxLat = maxLong = maxAltitude = Double.MIN_VALUE;

        for(String line : input) {
            String[] splitted = line.split(",");

            minTimestamp = findMin(splitted[0], minTimestamp);
            maxTimestamp = findMax(splitted[0], maxTimestamp);

            minLat = findMin(splitted[1], minLat);
            maxLat = findMax(splitted[1], maxLat);

            minLong = findMin(splitted[2], minLong);
            maxLong = findMax(splitted[2], maxLong);

            maxAltitude = findMax(splitted[3], maxAltitude);
        }

        results.add(minTimestamp + " " + maxTimestamp);
        results.add(minLat + " " + maxLat);
        results.add(minLong + " " + maxLong);
        results.add("" + maxAltitude);

        return results;
    }

    private static double findMax(String value, double comparison) {
        double v = Double.parseDouble(value);
        return Math.max(v, comparison);
    }

    private static double findMin(String value, double comparison) {
        double v = Double.parseDouble(value);
        return Math.min(v, comparison);
    }

    private static int findMax(String value, int comparison) {
        int v = Integer.parseInt(value);
        return Math.max(v, comparison);
    }

    private static int findMin(String value, int comparison) {
        int v = Integer.parseInt(value);
        return Math.min(v, comparison);
    }
}
