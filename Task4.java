package tasks;

/*
4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        System.out.println("Task4:");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Input a string: ");
            String str = in.nextLine();
            try {
                if (str.isEmpty())
                    throw new MyException("String is Empty");
                System.out.println(str);
                break;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}