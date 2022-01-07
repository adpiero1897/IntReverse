import java.util.Scanner;

public class Api {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int inputNum;
        while (true) {
            System.out.println("Введите целое число, которое хотите перевернуть:");
            if (SC.hasNextInt()) {
                inputNum = SC.nextInt();
                System.out.println(intReverse(inputNum));
            }
            SC.nextLine();
        }
    }

    public static long intReverse(int inputNum) {
        int num = Math.abs(inputNum);
        double iReverse = 0;
        int maxPowerNum = maxPowerDec(num);
        for (int powerDec = 1; maxPowerNum >= powerDec; powerDec++) {
            //Начинаем с 1, т.к. нам нужна цифра n-го порядка за вычетом остатка предыдущих порядков
            iReverse += (num % Math.pow(10, maxPowerNum + 1 - powerDec) - num % Math.pow(10, maxPowerNum - powerDec))
                    / Math.pow(10, maxPowerNum - powerDec) * Math.pow(10, powerDec - 1); //Это главная формула реверса здесь!
            //Ставим изначальную цифру в порядок единиц (powerDec-1 начальное), вторую - в десятки и т.д.
        }
        if (inputNum > 0) {
            return (int) iReverse;
        } else {
            return -(int) iReverse;
        }
    }

    public static int maxPowerDec(int num) {       //Максимальный десятичный разряд нашего числа находим
        int power = 0;
        for (; Math.pow(10, power) < num; power++) {

        }
        return power;
    }
}
