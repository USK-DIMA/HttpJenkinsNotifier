package ru.uskov.dmitry.httpjenkinsnotifier.client.sound;

import java.util.*;

public class DigitsSoundUtils {

    private static final char DEFAULT = ' ';

    public static ArrayList<String> getTracksSplit(String number) {
        if(number.length() == 1) {
            return getTracksClassic(number);
        }
        int length = number.length();
        int rest = length % 2;
        int partCount = length / 2;
        ArrayList<String> result = new ArrayList<>(partCount);
        for (int i = 0; i < partCount; i++) {
            int beginIndex = i * 2;
            int endIndex = beginIndex + 2;
            if (i == partCount - 1) {
                endIndex += rest;
            }
            String part = number.substring(beginIndex, endIndex);
            //case when part start with '0'
            char[] chars = part.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '0') {
                    result.add("0.wav");
                } else {
                    part = part.substring(j);
                    break;
                }
            }
            result.addAll(getTracksClassic(part));
        }
        return result;
    }

    public static ArrayList<String> getTracksClassic(String number) {
        char[] chars = number.toCharArray();
        char units = getChar(chars, chars.length - 1);
        char tens = getChar(chars, chars.length - 2);
        char hundreds = getChar(chars, chars.length - 3);
        char thousandths1 = getChar(chars, chars.length - 4);
        char thousandths2 = getChar(chars, chars.length - 5);
        ArrayDeque<String> result = new ArrayDeque<>();
        addTens(result, units, tens);
        addHundreds(result, hundreds);
        addThousandths(result, thousandths1, thousandths2);
        return new ArrayList<>(result);
    }

    private static void addTens(ArrayDeque<String> result, char units, char tens) {
        if (tens == '1') { //10, 11, 12, 13, 14, 15, 16, 17, 18, 19
            result.addFirst("1" + units + ".wav");
            return;
        }

        if (units != '0') {
            result.addFirst(units + ".wav");
        }

        if (tens != DEFAULT && tens != '0') {
            result.addFirst(tens + "0.wav");
        }
    }

    private static void addHundreds(ArrayDeque<String> result, char hundreds) {
        if (hundreds == DEFAULT) {
            return;
        }
        if (hundreds != '0') {
            result.addFirst(hundreds + "00.wav");
        }
    }

    private static void addThousandths(ArrayDeque<String> result, char thousandthsUnit, char thousandthsTen) {
        if (thousandthsTen == '1') { //10 000, 11 000, 12 000, 13 000, 14 000, 15 000, 16 000, 17 000, 18 000, 19 000
            result.addFirst("thousands.wav");
            result.addFirst("1" + thousandthsUnit + ".wav");
            return;
        }
        if (thousandthsUnit == '0' && thousandthsTen != DEFAULT) { //20 000, 30 000, 40 000, 50 000, 60 000, 70 000, 80 000, 90 000
            result.addFirst("thousands.wav");
            result.addFirst(thousandthsTen + "0.wav");
            return;
        }

        if (thousandthsUnit != DEFAULT && thousandthsUnit != '0') {
            switch (thousandthsUnit) {
                case '1':
                    result.addFirst("thousand.wav");
                    result.addFirst("1f.wav");
                    break;
                case '2':
                    result.addFirst("thousands-i.wav");
                    result.addFirst("2f.wav");
                    break;
                case '3':
                    result.addFirst("thousands-i.wav");
                    result.addFirst("3.wav");
                    break;
                case '4':
                    result.addFirst("thousands-i.wav");
                    result.addFirst("4.wav");
                    break;
                case '5':
                    result.addFirst("thousands.wav");
                    result.addFirst("5.wav");
                    break;
                case '6':
                    result.addFirst("thousands.wav");
                    result.addFirst("6.wav");
                    break;
                case '7':
                    result.addFirst("thousands.wav");
                    result.addFirst("7.wav");
                    break;
                case '8':
                    result.addFirst("thousands.wav");
                    result.addFirst("8.wav");
                    break;
                case '9':
                    result.addFirst("thousands.wav");
                    result.addFirst("9.wav");
                    break;
            }
        }
        if (thousandthsTen != DEFAULT) {
            result.addFirst(thousandthsTen + "0.wav");
        }
    }

    private static char getChar(char[] chars, int index) {
        try {
            return chars[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return DEFAULT;
        }
    }


}
