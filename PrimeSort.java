import java.io.*;
import java.util.*;

class NumberArray {
    private int[] numbers;
    private int size;

    public NumberArray(int n) {
        numbers = new int[n];
        size = n;
    }

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] tokens = line.split(" ");
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(tokens[i]);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public void rearrangeArray() {
        int[] primeNumbers = new int[size];
        int[] nonPrimeNumbers = new int[size];
        int primeCount = 0, nonPrimeCount = 0;

        for (int i = 0; i < size; i++) {
            if (isPrime(numbers[i])) {
                primeNumbers[primeCount++] = numbers[i];
            } else {
                nonPrimeNumbers[nonPrimeCount++] = numbers[i];
            }
        }

        Arrays.sort(primeNumbers, 0, primeCount);
        Arrays.sort(nonPrimeNumbers, 0, nonPrimeCount);

        System.arraycopy(primeNumbers, 0, numbers, 0, primeCount);
        System.arraycopy(nonPrimeNumbers, 0, numbers, primeCount, nonPrimeCount);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void displayArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < size; i++) {
                writer.write(numbers[i] + " ");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class PrimeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        NumberArray array = new NumberArray(n);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt"))) {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int num = random.nextInt(100) + 1; 
                writer.write(num + " ");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        array.readFromFile("numbers.txt");

        System.out.println("Original Array:");
        array.displayArray();

        array.rearrangeArray();

        System.out.println("Sorted Array with Prime Numbers First:");
        array.displayArray();

        array.writeToFile("sorted_numbers.txt");

        System.out.println("Array stored in sorted_numbers.txt");
    }
}