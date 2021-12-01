package com.advent.day1part1;

import com.advent.day1part1.parser.DepthParser;

public class Day1Part1 {


    private static DepthParser depthParser;


    public static void main(String[] args) {

        DepthParser depthParser = new DepthParser();
        int depthIncreases = depthParser.parseDepths("depths.txt");

        System.out.println("Depths increases : " + depthIncreases);
    }

    public DepthParser getDepthParser() {
        return depthParser;
    }

    public void setDepthParser(DepthParser depthParser) {
        Day1Part1.depthParser = depthParser;
    }
}
