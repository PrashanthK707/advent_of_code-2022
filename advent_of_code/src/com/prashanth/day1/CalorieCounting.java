package com.prashanth.day1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CalorieCounting {
    public static void main(String[] args) {
        try {
            String userDirectory = System.getProperty("user.dir");
            String filePath = userDirectory + "/src/com/prashanth/day1/input.txt";
            String content = new String(Files.readAllBytes(new File(filePath).toPath()));
            Supplier<LongStream> stream = () -> Arrays.stream(content.split("\n\n")).map(str -> Arrays.stream(str.split("\n")).mapToLong(Long::parseLong).sum())
                    .sorted(Comparator.reverseOrder()).mapToLong(Long::longValue);
            // Part 1
            System.out.println(stream.get().limit(1).sum());

            //Part 2
            System.out.println(stream.get().limit(3).sum());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
