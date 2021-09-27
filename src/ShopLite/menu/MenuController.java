package ShopLite.menu;

import ShopLite.compare.PriceComparator;
import ShopLite.compare.SortIndexComparator;
import ShopLite.data.DataAcquirer;
import ShopLite.entity.Product;
import ShopLite.entity.Shop;
import ShopLite.exception.InputDataTypeException;
import ShopLite.exception.InputStreamConsoleException;
import ShopLite.exception.InvalidChooseValueException;
import ShopLite.exception.InvalidKeyException;
import ShopLite.printer.ConsoleMessagePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuController {
    ConsoleMessagePrinter printer = new ConsoleMessagePrinter();
    Shop shop = new Shop();
    DataAcquirer acquirer = new DataAcquirer();
    int index = 0;

    public void sort() {
        printer.printSortMenu();
        try {
            int choose = acquirer.getChoice(1, 3);
            List<Product> productList = new ArrayList<>(shop.getAllProducts());
            switch (choose) {
                case 1 -> {
                    Comparator<Product> priceComparator = new PriceComparator();
                    productList.sort(priceComparator);
                    printer.printGoods(productList, shop);
                }
                case 2 -> {
                    Comparator<Product> reversedPriceComparator = Collections.reverseOrder(new PriceComparator());
                    productList.sort(reversedPriceComparator);
                    printer.printGoods(productList, shop);
                }
                case 3 -> {
                    Comparator<Product> reversedIndexComparator = Collections.reverseOrder(new SortIndexComparator());
                    productList.sort(reversedIndexComparator);
                    printer.printGoods(productList, shop);
                }
            }
        } catch (InputStreamConsoleException | InputDataTypeException | IOException e) {
            printer.printMessage(e.getMessage());
        }
    }

    public void remove() {
        printer.printMessage("Введите id");
        try {
            int id = acquirer.readNum(0, Integer.MAX_VALUE);
            shop.remove(id);
        } catch (InputStreamConsoleException | InputDataTypeException | IOException | InvalidChooseValueException e) {
            printer.printMessage(e.getMessage());
        }
    }

    public void add() {
        printer.printMessage("Введите id");
        try {
            int id = acquirer.readNum(0, Integer.MAX_VALUE);
            shop.add(acquirer.getNewProduct(index++), id);
        } catch (InputStreamConsoleException | InputDataTypeException | IOException | InvalidKeyException | InvalidChooseValueException e) {
            printer.printMessage(e.getMessage());
        }
    }

    public void edit() {
        printer.printMessage("Введите id");
        try {
            int id = acquirer.readNum(0, Integer.MAX_VALUE);
            shop.edit(id, acquirer.getNewProduct(index++));
        } catch (InputStreamConsoleException | InputDataTypeException | IOException | InvalidChooseValueException e) {
            printer.printMessage(e.getMessage());
        }
    }
}
