import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        byte taskNumber = -1;

        while (taskNumber !=0){

            System.out.println("Введите номер задания от 1 до 5 (0 - для выхода): ");

            taskNumber = scanner.
                    nextByte();

            switch (taskNumber){
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    //task3();
                    break;
                case 4:
                    //task4();
                    break;
                case 5:
                    //task5();
                    break;
                default:
                    System.out.println("Введено некорректный номер задания. Введите номер от 1 до 5 или 0 для выхода");
            }
        }
    }

    static void task1(){

        final byte count = 100;

        //Генерация случ. числа
        Random random = new Random();
        int randomNumber = random.nextInt(count) + 1;

        //Колво попыток
        int attempCount = 1;

        //Число от пользователя
        int number = 0;

        System.out.println("Угадайте число от 1 до 100. (Для выхода введите 0) ");

        while (true){

            System.out.printf("Ваша версия (попытка № " + attempCount++ + "): ");

            number = scanner.nextInt();

            if (number == 0){
                return;
            }
            else if (number == randomNumber){
                System.out.println("Браво! Вы угадали!");
                return;
            }else if (number > randomNumber){
                System.out.println("Загаданное число меньше вашего! Попробуйте ещё раз!");
                System.out.println();
            } else {
                System.out.println("Загаданное число больше вашего! Пробуйте и у вас обязательно получиться!");
                System.out.println();
            }
        }
    }

   static void task2(){


        System.out.println("Выберете операцию, производимую над матрицами (0 - сумма/вычитание, 1 - произведение");

        byte operation = scanner.nextByte();

       switch (operation){
           case 0:
               task2_1();
               break;
           case 1:
               task2_2();
               break;
           default:
               System.out.println("Введён некорректный код операции!");
       }
   }

   static void task2_1(){

       int sum, div;
       System.out.printf("Введите количество строк и столбцов матриц соответственно (разделитель - пробел): ");


       byte length = scanner.nextByte();
       byte width = scanner.nextByte();

       System.out.println("Введите первую матрицу:");

       int[][] matrix1 = new int[length][width];
       int[][] matrix2 = new int[length][width];

       for (int i = 0; i < length; i++){
           for (int j = 0; j < width; j++){
               matrix1[i][j] = scanner.nextInt();
           }
       }

       System.out.println("Введите вторую матрицу:");

       for (int i=0; i < length; i++){
           for (int j=0; j < width; j++){
               matrix2[i][j] = scanner.nextInt();
           }
       }

       System.out.println("Сумма матриц:");
       for (int i=0; i<length; i++){
           for (int j=0; j<width; j++){
               sum = matrix1[i][j] + matrix2[i][j];
               System.out.printf(sum + "  ");
           }
           System.out.println();
       }

       System.out.println("Разность матриц:");
       for (int i=0; i<length; i++){
           for (int j=0; j<width; j++){
               div = matrix1[i][j] - matrix2[i][j];
               System.out.printf(div + "  ");
           }
           System.out.println();
       }
   }

   static void task2_2(){

       int prod;

       System.out.printf("Введите количество строк и столбцов соответственно для 1-й матрицы: ");

        int length1 = scanner.nextInt();
        int width1  = scanner.nextInt();

       System.out.printf("Введите количество строк и столбцов соответственно для 2-й матрицы" +
               " (количество строк должно равняться количеству столбцов первой матрицы): ");

       int length2 = scanner.nextInt();
       int width2  = scanner.nextInt();

        if (length1 != width2){
            System.out.println("Размерности матриц не соответствуют условию умножения матриц!");
            return;
        }

       System.out.println("Введите первую матрицу:");

       int[][] matrix1 = new int[length1][width1];

       for (int i = 0; i < length1; i++){
           for (int j = 0; j < width1; j++){
               matrix1[i][j] = scanner.nextInt();
           }
       }

       int[][] matrix2 = new int[length2][width2];

       System.out.println("Введите вторую матрицу:");

       for (int i=0; i < length2; i++){
           for (int j=0; j < width2; j++){
               matrix2[i][j] = scanner.nextInt();
           }
       }

        int sum1 = 0;

       System.out.println("Произведение матриц:");
       for (int i=0; i<length1; i++){
           for (int j=0; j<width2; j++){
               sum1 = 0;
               for (int k=0; k<width1; k++){
                  sum1 += matrix1[i][k]*matrix2[k][j];
               }
               System.out.printf(sum1 + "   ");
           }
           System.out.println();
       }
   }
}