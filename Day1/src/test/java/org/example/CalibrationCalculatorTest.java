package org.example;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationCalculatorTest {

    public void validateCalibrationAlgorithm(Integer expected, List<String> input) {
        CalibrationCalculator calibrationCalculator = new CalibrationCalculator();
        List<Integer> result = calibrationCalculator.calculateCalibrations(input);
        assertEquals(expected, result.get(0));
    }

    @Test
    public void give_lineWithTwoNumbersAdTheEnd_when_calibration_then_twoDigitNumberCreated() {
        validateCalibrationAlgorithm(12, List.of("1abc2"));
    }

    @Test
    public void give_lineWithTwoNumbersWithRandomPosition_when_calibration_then_twoDigitNumberCreated() {
        validateCalibrationAlgorithm(38, List.of("pqr3stu8vwx"));
    }

    @Test
    public void give_lineWithMoreThanTwoNumbers_when_calibration_then_twoDigitNumberCreated() {
        validateCalibrationAlgorithm(15, List.of("a1b2c3d4e5f"));
    }

    @Test
    public void give_lineWithLessThanTwoNumbers_when_calibration_then_twoDigitNumberCreated() {
        validateCalibrationAlgorithm(77, List.of("treb7uchet"));
    }

    @Test
    public void give_lineWithNoNumbers_when_calibration_then_twoDigitNumberCreated() {
        validateCalibrationAlgorithm(0, List.of("trebuchet"));
    }
}
