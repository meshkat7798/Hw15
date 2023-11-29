package menu;

import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

@NoArgsConstructor
public class MainMenu {

    Scanner scanner = new Scanner(System.in);
    String userName;
    String passWord;

    public void start() {
        while (true) {
            String text = """
                    *** CHOOSE YOUR ROLE : ***
                    1- STUDENT
                    2- TEACHER
                    3- EMPLOYEE
                    4- EXIT
                    """;
            System.out.println(text);
            System.out.println("PLEASE ENTER A NUMBER FROM ABOVE:");
            int input = input();
            switch (input) {
                case 1:
                    login();
                    new StudentMenu(userName, passWord);
                    break;
                case 2:
                    login();
                    new TeacherMenu(userName, passWord);
                    break;
                case 3:
                    login();
                    new EmployeeMenu(userName, passWord);
                    break;
                case 4:
                    System.exit(-1);
                    break;
                default:
                    System.out.println("INVALID INPUT!!!");
                    start();
                    break;
            }
        }
    }


    void login() {

        System.out.println("PLEASE ENTER YOUR USERNAME : ");
        this.userName = scanner.next();
        System.out.println("PLEASE ENTER YOUR PASSWORD : ");
        this.passWord = scanner.next();

    }

    public Integer input() {
        int i;
        while (true) {
            try {
                i = scanner.nextInt();
                scanner.nextLine();
                return i;
            } catch (InputMismatchException in) {
                scanner.nextLine();
                System.out.println("PLEASE ENTER A VALID NUMBER !");
            }
        }
    }
}