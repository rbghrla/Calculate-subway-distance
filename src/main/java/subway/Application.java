package subway;

import java.util.Scanner;

import subway.Controller.MainController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        MainController mainController = new MainController();
        mainController.startMain();
        mainController.inputMain(scanner.nextLine());
    }
}
