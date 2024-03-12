package org.example;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CalibrationCalculator {

    public static void main( String[] args ) throws IOException {
        Path pathToFile = Paths.get("/Users/robin/Documents/Axxes/repo/AdventOfCode/Day1/input.txt");
        List<String> input = Files.readAllLines(pathToFile);
        CalibrationCalculator calibrationCalculator = new CalibrationCalculator();
        List<Integer> calibrations = calibrationCalculator.calculateCalibrations(input);
        System.out.println("Calibration sum is: " + calibrations.stream().mapToInt(Integer::intValue).sum());
    }

    public List<Integer> calculateCalibrations(List<String> input) {
        return input.stream().map(this::getNumberFromCalibrationLine).toList();
    }

    public Integer getNumberFromCalibrationLine(String line) {
        List<String> filteredLine = Arrays.stream(line.split("")).filter(NumberUtils::isDigits).toList();

        if (filteredLine.isEmpty()) {
            return 0;
        }

        String result = filteredLine.get(0) + filteredLine.get(filteredLine.size() - 1);
        return Integer.parseInt(result);
    }

}
