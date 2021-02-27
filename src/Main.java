import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        //задание 1
        System.out.println("Task 1.");
        int[] array = {1, 1, 0, 0, 1, 1, 0, 0};

        System.out.println(Arrays.toString(array));
        changeZeroesAndOnes(array);
        System.out.println(Arrays.toString(array));

        //задание2
        System.out.println("Task 2");
        int[] emptyArray = new int[8];

        System.out.println(Arrays.toString(emptyArray));
        fillArrayWithProgression(emptyArray);
        System.out.println(Arrays.toString(emptyArray));

        // задание 3

        System.out.println("Task 3");
        int[] myArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println(Arrays.toString(myArray));
        multiplyOnSixIn(myArray);
        System.out.println(Arrays.toString(myArray));

        //задание 4
        System.out.println("Task 4");

        int[][] square = new int[10][10]; // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
        System.out.println("With zeroes");
        printSquare(square);

        fillDiagonalWithOnes(square);
        System.out.println("With ones.");
        printSquare(square);

//             задание 5

        System.out.println("Task 5");
        int[] minMaxArray = {1, 2, 7, 4, 0};
        System.out.println(Arrays.toString(minMaxArray));
        printMinAndMax(minMaxArray);

        //    Задание 6
        System.out.println("Task 6.");

        int[] sumsArray = { 1, 1, 1, 1, 1, 1 };
        System.out.println(Arrays.toString(sumsArray));
        boolean isBalanced = hasBalance(sumsArray);
        System.out.println("Суммы правой и левой части где либо равны? " + isBalanced);




//                Задание 7

        System.out.println("Task 7.");
        int[] rightShiftArray = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(rightShiftArray));
        shiftArray(rightShiftArray, 3);
        System.out.println(Arrays.toString(rightShiftArray));

        int[] leftShiftArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(Arrays.toString(leftShiftArray));
        shiftArray(leftShiftArray, -5);
        System.out.println(Arrays.toString(leftShiftArray));

    }


    static void changeZeroesAndOnes(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++){
            inputArray[i] = 1 - inputArray[i];
        }
    }
    static void fillArrayWithProgression (int[] inputArray){
        for (int i = 0; i <inputArray.length; i++ ){
            inputArray[i] = i * 3;
        }
    }
    static void multiplyOnSixIn(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (inputArray[i] < 6) ? (inputArray[i] * 2) : inputArray[i];
        }
    }
    static void fillDiagonalWithOnes(int[][] square) {
        //с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        for (int i = 0; i < square.length; i++) {
            // диагональные элементы имеют одинаковые индексы
            square[i][i] = 1;

            // заполнение другой диагонали
            square[i][square[i].length - 1 - i] = 1;
        }
    }
    static void printSquare(int[][] inputSquare) {
        for (int i = 0; i < inputSquare.length; i++)
        {
            System.out.println(Arrays.toString(inputSquare[i]));
        }
    }
    static void printMinAndMax(int[] inputArray) {
        int min = inputArray[0];
        int max = inputArray[0];

        // простой перебор массива.
        for (int i = 0; i < inputArray.length; i++)
        {
            if (min > inputArray[i]){
                min = inputArray[i];
            }
            if (max < inputArray[i]){
                max = inputArray[i];
            }
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }


    static boolean hasBalance(int[] inputArray){
        int leftSum = 0;
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        for (int i = 0; i < inputArray.length; i++) {
            leftSum += inputArray[i];
            int rightSum = 0;
            for (int j = (i + 1); j < inputArray.length; j++){
                rightSum += inputArray[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }

    static void rightShift(int [] inputArray){
        int buffer = inputArray[0];
        inputArray[0] = inputArray[inputArray.length - 1];
        for (int j = 1; j < inputArray.length; j++){
            inputArray[inputArray.length - j] = inputArray[inputArray.length - j - 1];
        }
        inputArray[1] = buffer;
    }

    static void shiftArray(int[] array, int shift) {

            if (isNegative(shift)) {

                for (int i = 0; i > shift; i--){
                    leftShift(array);
                }
            }
            else {
                for (int i = 0; i < shift; i++) {
                    rightShift(array);
                }
            }
    }

    static void leftShift(int [] inputArray){
        int buffer = inputArray[inputArray.length - 1];
        inputArray[inputArray.length - 1] = inputArray[0];
        for (int j = 1; j < inputArray.length; j++){
            inputArray[j -1] = inputArray[j];
        }
        inputArray[inputArray.length - 2] = buffer;
    }
    static boolean isNegative(int number)
    {
        return number < 0;
    }
}