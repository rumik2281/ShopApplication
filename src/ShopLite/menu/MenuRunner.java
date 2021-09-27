package ShopLite.menu;

import ShopLite.data.DataAcquirer;
import ShopLite.exception.InputDataTypeException;
import ShopLite.exception.InputStreamConsoleException;
import ShopLite.exception.InvalidChooseValueException;
import ShopLite.printer.ConsoleMessagePrinter;

import java.io.IOException;

public class MenuRunner {
    ConsoleMessagePrinter printer = new ConsoleMessagePrinter();
    MenuController menu = new MenuController();

    public void start() throws InputStreamConsoleException, InputDataTypeException, IOException {
        printer.printMenu();
        DataAcquirer acquirer = new DataAcquirer();
        int choice = acquirer.getChoice(1, 5);
        switch (choice) {
            case 1 -> {
                menu.sort();
                start();
            }
            case 2 -> {
                menu.add();
                start();
            }
            case 3 -> {
                menu.remove();
                start();
            }
            case 4 -> {
                menu.edit();
                start();
            }
            case 5 -> System.exit(0);
        }
    }
}
