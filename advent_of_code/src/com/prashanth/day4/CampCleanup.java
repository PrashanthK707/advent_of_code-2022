package com.prashanth.day4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CampCleanup {

    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "/src/com/prashanth/day4/input.txt";
        File file = new File(filePath);
        CampCleanup cc = new CampCleanup();
        //part 1
        System.out.println(cc.getPartOneResult(file));

        //part 2
        System.out.println(cc.getPartTwoResult(file));
    }

    private int getPartTwoResult(File file) {
        int counter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String pair = scanner.nextLine();
                String ranges[] = pair.split(",");
                String numbers[] = ranges[0].split("-");
                int min1 = Integer.parseInt(numbers[0]);
                int max1 = Integer.parseInt(numbers[1]);
                int len1 = max1 - min1;
                numbers = ranges[1].split("-");
                int min2 = Integer.parseInt(numbers[0]);
                int max2 = Integer.parseInt(numbers[1]);
                int len2 = max2 - min2;
                boolean overlaps = false;
                if (len1 > len2) {
                    for (int i = min2; i <= max2; i++) {
                        if (i >= min1 & i <= max1)
                            overlaps = true;
                    }
                } else {
                    for (int i = min1; i <= max1; i++) {
                        if (i >= min2 & i <= max2)
                            overlaps = true;
                    }
                }
                if (overlaps) counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private int getPartOneResult(File file) {
        int counter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String pair = scanner.nextLine();
                String ranges[] = pair.split(",");
                String numbers[] = ranges[0].split("-");
                int min1 = Integer.parseInt(numbers[0]);
                int max1 = Integer.parseInt(numbers[1]);
                int len1 = max1 - min1;
                numbers = ranges[1].split("-");
                int min2 = Integer.parseInt(numbers[0]);
                int max2 = Integer.parseInt(numbers[1]);
                int len2 = max2 - min2;
                boolean inside = true;
                if (len1 > len2) {
                    for (int i = min2; i <= max2; i++) {
                        if (i < min1 | i > max1)
                            inside = false;
                    }
                } else {
                    for (int i = min1; i <= max1; i++) {
                        if (i < min2 | i > max2)
                            inside = false;
                    }
                }
                if (inside) counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
