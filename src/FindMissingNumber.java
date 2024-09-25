import java.util.Arrays;

public class FindMissingNumber {
    public static int findMissingNumber(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            throw new IllegalArgumentException("Последовательность не должна быть пустой.");
        }

        int min = Arrays.stream(sequence).min().getAsInt();
        int max = Arrays.stream(sequence).max().getAsInt();

        // Используем XOR для нахождения пропущенного числа
        int xorSum = 0;
        for (int num : sequence) {
            xorSum ^= num;
        }

        // Вычисляем XOR всех чисел от минимального до максимального
        for (int i = min; i <= max; i++) {
            xorSum ^= i;
        }

        return xorSum;
    }

    public static void main(String[] args) {
        int[] input1 = {5, 0, 1, 3, 2};
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + findMissingNumber(input1));

        int[] input2 = {-1, 0, 2, 3, 4, 1, 6};
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + findMissingNumber(input2));

        int[] input3 = {1, 2, 3, 5, 4, 6};
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + findMissingNumber(input3));

        int[] input4 = {7, 9, 10, 11, 12, 13};
        System.out.println("Input: " + Arrays.toString(input4));
        System.out.println("Expected Output: 8");
        System.out.println("Actual Output: " + findMissingNumber(input4));
    }
}

