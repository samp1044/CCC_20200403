package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static void forEachFile(String level, FileProcessor processor) {
        File dir = new File("input/" + level);

        for(File f : dir.listFiles()) {
            List<String> output = processor.process(readFile(f));
            writeOutput(level, f, output);
        }
    }

    public static List<String> readFile(File f) {
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

        return inputs;
    }

    public static void writeOutput(String level, File f, List<String> output) {
        try (
                FileWriter fw = new FileWriter("output/" + level + "/out." + f.getName());
                )
        {
            for(String line : output) {
                fw.write(line + System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
