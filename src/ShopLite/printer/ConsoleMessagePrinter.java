package ShopLite.printer;

import ShopLite.entity.Product;
import ShopLite.entity.Shop;

import java.util.List;

public class ConsoleMessagePrinter {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        System.out.print("1. Вывод всех товаров\n2. Добавление товара\n3. Удаление товара\n4. Редактирование товара\n5. Выход\n");
    }

    public void printSortMenu() {
        System.out.print("1. По цене (возрастание)\n2. По цене (убывание)\n3. По добавлению\n");
    }

    public void printChooseString(int leftBorder, int rightBorder) {
        System.out.printf("Введите число от %d до %d\n", leftBorder, rightBorder);
    }

    public void printGoods(List<Product> productList, Shop shop) {
        for (Product prod : productList) {
            System.out.println(prod + " id: " + shop.getKeyByValue(prod));
        }
    }

}
