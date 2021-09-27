package ShopLite.util;

import ShopLite.entity.Product;
import ShopLite.entity.Shop;
import ShopLite.exception.InputDataTypeException;
import ShopLite.exception.InputStreamConsoleException;
import ShopLite.menu.MenuRunner;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        MenuRunner menu = new MenuRunner();
        try {
            menu.start();
        } catch (InputStreamConsoleException | InputDataTypeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
