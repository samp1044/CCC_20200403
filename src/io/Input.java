package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static void forEachFile()

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
}
