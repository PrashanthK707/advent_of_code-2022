package com.prashanth.day3;

import com.prashanth.day2.Game;
import com.prashanth.day2.RPS;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RucksackReorganization {

    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "/src/com/prashanth/day3/input.txt";
        File file = new File(filePath);
        RucksackReorganization rr = new RucksackReorganization();
        //Part 1
        System.out.println(rr.getPartOneResult(file));

        //Part 2
        System.out.println(rr.getPartTwoResult(file));
    }

    private int getPartOneResult(File file) {
        int sum = 0;
        try (Scanner scanner = new Scanner(file)) {
            Game game = new Game();
            while (scanner.hasNext()) {
                String current = scanner.nextLine();
                String first = current.substring(0, current.length() / 2);
                String second = current.substring(current.length() / 2);
                for (char c : first.toCharArray()){
                    if(second.indexOf(c) >= 0) {
                        if(Character.isLowerCase(c)){
                            sum += c-'a' + 1;
                        } else {
                            sum += c - 'A' + 27;
                        }
                        break;
                    }
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return sum;
    }

    private int getPartTwoResult(File file) {
        int sum = 0;
        try (Scanner scanner = new Scanner(file)) {
            Game game = new Game();
            while (scanner.hasNext()) {
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                String third = scanner.nextLine();
                Set<Character> set = new HashSet<>();
                for (char c : first.toCharArray()){
                    if(second.indexOf(c) >= 0) {
                       set.add(c);
                    }
                }
                for(Character ch : set){
                    if(third.indexOf(ch) >= 0){
                        if(Character.isLowerCase(ch))
                            sum += ch - 'a' + 1;
                        else
                            sum += ch - 'A' + 27;
                        break;
                    }
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return sum;
    }
}
