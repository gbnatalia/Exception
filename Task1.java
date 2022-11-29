package tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args) {

        System.out.println("Task1:");

        while (true) {
            System.out.println("Input a Float: ");
            Scanner in = new Scanner(System.in);
            try {
                Float f = in.nextFloat();
                in.nextLine();
                System.out.println(f);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
