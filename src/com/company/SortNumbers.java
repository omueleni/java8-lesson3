package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortNumbers {

    public static void main(String[] args) {

        String fileLocation = "/Users/abayomikogbe/Downloads/data/line3.txt";

        try(Stream<String> stream = Files.lines(Paths.get(fileLocation))){

            List<String[]>  splitFileContent =  stream.map(line -> line.split(",")).
                    collect(Collectors.toList());

            List<Integer>  sortedlist = new ArrayList<String>(Arrays.asList(splitFileContent.get(0)))
                                       .stream().mapToInt(value ->  Integer.parseInt(value))
                                       .sorted()
                                       .boxed().collect(Collectors.toList());

            String reconstuctOutput = sortedlist.stream().map(value -> String.valueOf(value)).
                                      collect(Collectors.joining(","));

            System.out.println(reconstuctOutput);

        }catch (IOException ex){
            ex.getStackTrace();
        }


	// write your code here
    }
}
