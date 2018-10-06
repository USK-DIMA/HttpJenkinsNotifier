package ru.uskov.dmitry.httpjenkinsnotifier.client.sound;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class DigitsSoundUtilsTest {

    @Test
    void getTracksClassic() {
        executeTestClassic("1", "1.wav");
        executeTestClassic("5", "5.wav");
        executeTestClassic("12", "12.wav");
        executeTestClassic("22", "20.wav", "2.wav");
        executeTestClassic("100", "100.wav");
        executeTestClassic("101", "100.wav", "1.wav");
        executeTestClassic("120", "100.wav", "20.wav");
        executeTestClassic("123", "100.wav", "20.wav", "3.wav");
        executeTestClassic("504", "500.wav", "4.wav");
        executeTestClassic("1000", "1f.wav", "thousand.wav");
        executeTestClassic("2000", "2f.wav", "thousands-i.wav");
        executeTestClassic("2001", "2f.wav", "thousands-i.wav", "1.wav");
        executeTestClassic("2010", "2f.wav", "thousands-i.wav", "10.wav");
        executeTestClassic("2013", "2f.wav", "thousands-i.wav", "13.wav");
        executeTestClassic("2100", "2f.wav", "thousands-i.wav", "100.wav");
        executeTestClassic("2104", "2f.wav", "thousands-i.wav", "100.wav", "4.wav");
        executeTestClassic("2117", "2f.wav", "thousands-i.wav", "100.wav", "17.wav");
        executeTestClassic("2120", "2f.wav", "thousands-i.wav", "100.wav", "20.wav");
        executeTestClassic("2129", "2f.wav", "thousands-i.wav", "100.wav", "20.wav", "9.wav");
        executeTestClassic("5000", "5.wav", "thousands.wav");
        executeTestClassic("9999", "9.wav", "thousands.wav", "900.wav", "90.wav", "9.wav");
        executeTestClassic("10000", "10.wav", "thousands.wav");
        executeTestClassic("21000", "20.wav", "1f.wav", "thousand.wav");
        executeTestClassic("22000", "20.wav", "2f.wav", "thousands-i.wav");
        executeTestClassic("20100", "20.wav", "thousands.wav", "100.wav");
    }

    @Test
    void getTracksSplit() {
        executeTestSplit("1", "1.wav");
        executeTestSplit("5", "5.wav");
        executeTestSplit("12", "12.wav");
        executeTestSplit("22", "20.wav", "2.wav");
        executeTestSplit("100", "100.wav");
        executeTestSplit("101", "100.wav", "1.wav");
        executeTestSplit("120", "100.wav", "20.wav");
        executeTestSplit("123", "100.wav", "20.wav", "3.wav");
        executeTestSplit("504", "500.wav", "4.wav");
        executeTestSplit("1504", "15.wav", "0.wav", "4.wav");
        executeTestSplit("2004", "20.wav", "0.wav", "4.wav");
        executeTestSplit("2000", "20.wav", "0.wav", "0.wav");
    }
    private void executeTestSplit(String inputNumber, String... expectedResult) {
        ArrayList<String> actual = DigitsSoundUtils.getTracksSplit(inputNumber);
        Assert.assertEquals(Arrays.asList(expectedResult), actual);
    }

    private void executeTestClassic(String inputNumber, String... expectedResult) {
        ArrayList<String> actual = DigitsSoundUtils.getTracksClassic(inputNumber);
        Assert.assertEquals(Arrays.asList(expectedResult), actual);
    }
}