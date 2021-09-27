package ShopLite.data;

import ShopLite.entity.Product;
import ShopLite.exception.InputDataTypeException;
import ShopLite.exception.InputStreamConsoleException;
import ShopLite.exception.InvalidChooseValueException;
import ShopLite.printer.ConsoleMessagePrinter;
import ShopLite.validator.MenuInputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataAcquirer {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final ConsoleMessagePrinter consoleMessagePrinter = new ConsoleMessagePrinter();

    public int readNum(int leftBorder, int rightBorder) throws InputStreamConsoleException, InputDataTypeException, IOException, InvalidChooseValueException {
        MenuInputValidator dataValidator = new MenuInputValidator();
        consoleMessagePrinter.printChooseString(leftBorder, rightBorder);
        int number;
        try {
            number = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            throw new InputDataTypeException("Недопустимое значение");
        } catch (IOException e) {
            throw new InputStreamConsoleException("Ошибка ввода");
        }
        if (!dataValidator.isChoiceCorrect(number, leftBorder, rightBorder)) {
            throw new InvalidChooseValueException("Введённое значение недопустимо");
        }
        return number;
    }

    public int getChoice(int leftBorder, int rightBorder) throws InputStreamConsoleException, InputDataTypeException, IOException {
        int choice;
        try {
            choice = readNum(leftBorder, rightBorder);
        } catch (InputStreamConsoleException | InputDataTypeException | IOException | InvalidChooseValueException e) {
            System.out.println(e.getMessage());
            choice = getChoice(leftBorder, rightBorder);
        }
        return choice;
    }


    public int getMenuOption() throws InputStreamConsoleException, InputDataTypeException, IOException {
        int option = 0;
        try {
            option = getChoice(1, 4);
        } catch (InputStreamConsoleException | InputDataTypeException | IOException e) {
            consoleMessagePrinter.printMessage(e.getMessage());
        }
        return option;
    }

    public Product getNewProduct(int index) throws IOException, InvalidChooseValueException, InputStreamConsoleException, InputDataTypeException {
        Product newProduct = new Product(index);
        consoleMessagePrinter.printMessage("Введите название товара");
        newProduct.setName(bufferedReader.readLine());
        consoleMessagePrinter.printMessage("Введите цену (целое число)");
        newProduct.setPrice(readNum(0, Integer.MAX_VALUE));
        return newProduct;
    }

}
