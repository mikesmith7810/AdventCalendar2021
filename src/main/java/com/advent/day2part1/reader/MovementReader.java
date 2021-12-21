package com.advent.day2part1.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MovementReader {
    public int analyseMovements(InputStream movementInputStream) {

        ArrayList<Pair> movements = readMovements(movementInputStream);

        int finalPosition = findFinalPosition(movements);

        return finalPosition;
    }

    private int findFinalPosition(ArrayList<Pair> movements) {
        int horizontalPosition = 0;
        int depthPosition = 0;
        int finalPosition = 0;

        for (int i=0;i<movements.size();i++) {

            String direction = ((Pair) movements.get(i)).getKey();
            Integer hops = ((Pair) movements.get(i)).getValue();

            switch (direction) {
                case "forward":
                    horizontalPosition += hops.intValue();
                    break;
                case "down":
                    depthPosition += hops;
                    break;
                case "up":
                    depthPosition -= hops;
                    break;
                default:
                    break;
            }

        }

        finalPosition = horizontalPosition * depthPosition;
        System.out.println("Horizontal :" + horizontalPosition);
        System.out.println("Depth :" + depthPosition);
        System.out.println("Final Position :" + horizontalPosition*depthPosition);

        return finalPosition;
    }

    private ArrayList<Pair> readMovements(InputStream movementInputStream) {
        ArrayList<Pair> movements = new ArrayList<Pair>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(movementInputStream));

        String movement;
        String direction;
        Integer hops;

        try {
            while ((movement = reader.readLine()) != null) {
                int seperatorIndex = movement.indexOf(" ");
                direction = movement.substring(0,seperatorIndex);
                hops = new Integer(movement.substring(seperatorIndex+1, movement.length()));
                Pair movementStep = new Pair(direction, hops);

                movements.add(movementStep);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movements;
    }
}
