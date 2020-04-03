package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import level4.Flight;
import utils.Vector3;

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
    
    
    public static Map<Integer,Flight> readFlights() {
    	Map<Integer,Flight> flights = new HashMap<>();
    	
    	
    	File dir = new File("input\\flights");

        for(File f : dir.listFiles()) {  
            try (
                    FileReader fr = new FileReader(f);
                    BufferedReader nr = new BufferedReader(fr);
            )
            {
            	String start;
            	String end;
            	String takeof;
            	String n;
            	String[] pos;
            	String id = f.getName().substring(0, f.getName().indexOf('.'));
            	Map<Integer,String> m;
                while((start = nr.readLine()) != null) {
                	end= nr.readLine();
                	takeof = nr.readLine();
                	n = nr.readLine();
                	int ni = Integer.parseInt(n);
                	m = new HashMap<>();
                	for(int i = 0; i < ni; i++) {
                		pos = nr.readLine().split(",");
                		m.put(Integer.parseInt(pos[0]),pos[1]+","+pos[2]+","+pos[3]);
                	}
                	//int id, String start, String end, int takeoff
                	flights.put(Integer.parseInt(id),new Flight(Integer.parseInt(id),start,end,Integer.parseInt(takeof),m));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        return flights;
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
