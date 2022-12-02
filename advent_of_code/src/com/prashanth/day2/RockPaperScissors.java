package com.prashanth.day2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "/src/com/prashanth/day2/input.txt";
        File file = new File(filePath);
        RockPaperScissors rps = new RockPaperScissors();
        System.out.println(rps.getPartOneResult(file));
        System.out.println(rps.getPartTwoResult(file));

    }

    private int getPartTwoResult(File file) {
        int score = 0;
        try (Scanner scanner = new Scanner(file)) {
            Game game = new Game();
            while (scanner.hasNext()) {
                String opponent = scanner.next();
                RPS o = getRpsOpponent(opponent);
                game.opponentPlayed(o);
                String me = scanner.next();
                RPS m = getRps(o, me);
                game.mePlayed(m);
                score += game.getScore();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return score;
    }

    private RPS getRps(RPS o, String me) {
        RPS result;
        switch (me) {
            case "X":
                if (o == RPS.ROCK)
                    result = RPS.SCISSOR;
                else if (o == RPS.PAPER)
                    result = RPS.ROCK;
                else
                    result = RPS.PAPER;
                break;
            case "Y":
                result = o;
                break;
            case "Z":
                if (o == RPS.ROCK)
                    result = RPS.PAPER;
                else if (o == RPS.PAPER)
                    result = RPS.SCISSOR;
                else
                    result = RPS.ROCK;
                break;
            default:
                result = null;
        }
        return result;
    }

    private int getPartOneResult(File file) {
        int score = 0;
        try (Scanner scanner = new Scanner((file))) {
            Game game = new Game();
            while (scanner.hasNext()) {
                String opponent = scanner.next();
                RPS o = getRpsOpponent(opponent);
                game.opponentPlayed(o);
                String me = scanner.next();
                RPS m = getRpsMe(me);
                game.mePlayed(m);
                score += game.getScore();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return score;
    }

    private RPS getRpsMe(String rps) {
        RPS result;
        switch (rps) {
            case "X":
                result = RPS.ROCK;
                break;
            case "Y":
                result = RPS.PAPER;
                break;
            case "Z":
                result = RPS.SCISSOR;
                break;
            default:
                result = null;
        }
        return result;
    }

    private RPS getRpsOpponent(String rps) {
        RPS result;
        switch (rps) {
            case "A":
                result = RPS.ROCK;
                break;
            case "B":
                result = RPS.PAPER;
                break;
            case "C":
                result = RPS.SCISSOR;
                break;
            default:
                result = null;
        }
        return result;
    }
}

