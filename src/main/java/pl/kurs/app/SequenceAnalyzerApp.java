package pl.kurs.app;

import pl.kurs.services.SequenceService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SequenceAnalyzerApp {
    public static void main(String[] args) {

        SequenceService sequenceService = new SequenceService();

        int[] sequence1 = {2, 5, 8, 11, 14};
        int[] sequence2 = {10, 8, 6, 6, 56};
        int[] sequence3 = {3, 6, 12, 24};
        int[] sequence4 = {1, 3};

        System.out.println(sequenceService.isArithmetic(sequence1));
        System.out.println(sequenceService.isArithmetic(sequence2));
        System.out.println(sequenceService.isArithmetic(sequence4));

        System.out.println(sequenceService.getSequenceName(sequence3));
        System.out.println(sequenceService.getSequenceName(sequence1));
        System.out.println(sequenceService.getSequenceName(sequence2));
        System.out.println(sequenceService.getSequenceName(sequence4));

        System.out.println(Arrays.toString(sequenceService.superPrimes(0, 55)));
        System.out.println(Arrays.toString(sequenceService.superPrimes(8, 320)));

        System.out.println("------------------------------------------");


        String fileName = "liczby.txt";

        try (Scanner sequenceAnalyzer = new Scanner(new File(fileName))) {
            while (sequenceAnalyzer.hasNextLine()) {
                String line = sequenceAnalyzer.nextLine();
                int[] sequence = sequenceService.convertLineToSequence(line);
                System.out.println("Analizowana sekwencja to: " + line);
                boolean isMonotonic = sequenceService.isMonotonic(sequence);
                int min = sequenceService.findMin(sequence);
                int max = sequenceService.findMax(sequence);
                String mostFrequent = sequenceService.findMostFrequentNumber(sequence);
                boolean containsAllNaturalNumbers = sequenceService.containsAllNaturalNumbersBetweenMinAndMax(sequence);
                System.out.println("Monotoniczność: " + (isMonotonic ? "Tak" : "Nie"));
                System.out.println("Min: " + min);
                System.out.println("Max: " + max);
                System.out.println("Najpopularniejsza liczba: " + mostFrequent);
                System.out.println("Czy wszystkie liczby naturalne między min a max są obecne: " + (containsAllNaturalNumbers ? "Tak" : "Nie"));
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
