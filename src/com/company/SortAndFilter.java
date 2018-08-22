package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAndFilter {

    public static void main (String[] args){

        String fileLocation = "/Users/abayomikogbe/Downloads/data/line3.txt";

        //Read file content with try

        try(Stream<String> stream = Files.lines(Paths.get(fileLocation))){

            //Split line and convert to list of array
            List<String[]> splitFileContent = stream.map(line -> line.split(",")).sorted().collect(Collectors.toList());


            //List of Integer
            List<Integer> sortedList = new ArrayList<String>(Arrays.asList(splitFileContent.get(0)))
                    .stream().filter(value -> Integer.parseInt(value) % 2 == 0)
                    .mapToInt(value -> Integer.parseInt(value))
                    .sorted()
                    .boxed().collect(Collectors.toList());


            String output = sortedList.stream().map(value -> String.valueOf(value)).collect(Collectors.joining(","));

            System.out.println("Output: " + output);

        }catch(IOException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
