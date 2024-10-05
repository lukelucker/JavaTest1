package pl.kurs.services;

public class SequenceService {

    public static boolean isArithmetic(int[] sequence) {
        if (sequence.length < 3) {
            return false;
        }
        int difference = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length ; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }

        }
        return true;
    }

    public static String getSequenceName(int[] sequence) {
        if (sequence.length < 3) {
            return "INNY";
        }
        if (isArithmetic(sequence)) {
            return "ARYTMETYCZNY";
        }
        double q = (double) sequence[1] / sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if ((double) sequence[i] / sequence[i - 1] != q) {
                return "INNY";
            }
        }
        return "GEOMETRYCZNY";
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] superPrimes(int from, int to) {
        int primeNmbCnt = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                primeNmbCnt++;
            }
        }
        int[] primeNumbers = new int[primeNmbCnt];
        int cnt = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                primeNumbers[cnt] = i;
                cnt++;
            }
        }
        int superPrimeCnt = 0;
        for (int i = 0; i < primeNumbers.length; i++) {
            if (isPrime(i + 1)) {
                superPrimeCnt++;
            }
        }
        int[] superPrimesArray = new int[superPrimeCnt];
        int cnt1 = 0;
        for (int i = 0; i < primeNumbers.length; i++) {
            if (isPrime(i + 1)) {
                superPrimesArray[cnt1] = primeNumbers[i];
                cnt1++;
            }
        }
        return superPrimesArray;
    }

    public static boolean isMonotonic(int[] sequence) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] > sequence[i - 1]) {
                decreasing = false;
            }
            if (sequence[i] < sequence[i - 1]) {
                increasing = false;
            }
        }
        return decreasing || increasing;
    }

    public static int findMin(int[] sequence) {
        int min = sequence[0];
        for (int num : sequence) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMax(int[] sequence) {
        int max = sequence[0];
        for (int num : sequence) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static String findMostFrequentNumber(int[] sequence) {
        int mostFrequent = sequence[0];
        int maxCount = 0;
        boolean multipleFrequentNmb = false;
        for (int i = 0; i < sequence.length; i++) {
            int count = 0;
            for (int j = 0; j < sequence.length; j++) {
                if (sequence[i] == sequence[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = sequence[i];
                multipleFrequentNmb = false;
            } else if (count == maxCount && sequence[i] != mostFrequent) {
                multipleFrequentNmb = true;
            }
        }
        if (maxCount == 1) {
            return "Brak powtórzeń.";
        }
        if (multipleFrequentNmb) {
            return "Kilka liczb występuje najczęściej";
        }
        return "" + mostFrequent;
    }

    public static boolean containsAllNaturalNumbersBetweenMinAndMax(int[] sequence) {
        int min = findMin(sequence);
        int max = findMax(sequence);
        if (min < 0 || max < 0) {
            return false;
        }
        for (int i = min; i <= max; i++) {
            boolean found = false;
            for (int num : sequence) {
                if (num == i) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static int[] convertLineToSequence(String line) {
        String[] numbers = line.split(" ");
        int[] sequence = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sequence[i] = Integer.parseInt(numbers[i]);
        }
        return sequence;
    }
}
