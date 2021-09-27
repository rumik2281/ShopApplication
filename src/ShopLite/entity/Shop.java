package ShopLite.entity;

import ShopLite.exception.InvalidChooseValueException;
import ShopLite.exception.InvalidKeyException;

import java.util.*;

public class Shop {
    private final HashMap<Integer, Product> productMap = new HashMap<>();

    public void add(Product product, int id) throws InvalidKeyException {
        if (!productMap.containsKey(id)) {
            productMap.put(id, product);
        } else {
            throw new InvalidKeyException("Товар с таким id уже присутствует.");
        }
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public void remove(int id) throws InvalidChooseValueException {
        if (!productMap.isEmpty())
            if (productMap.containsKey(id)) {
                productMap.remove(id);
            } else {
                throw new InvalidChooseValueException("Товар с таким id не найден.");
            }
    }

    public void edit(int id, Product product) throws InvalidChooseValueException {
        if (productMap.containsKey(id)) {
            productMap.put(id, product);
        } else {
            throw new InvalidChooseValueException("Товар с таким id не найден.");
        }
    }

    public int getKeyByValue(Product value) {
        int key = 0;
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }

    /*
    public void add(Product product) {
        Optional<Product> first = productList.stream().filter(product1 -> product1.getId() == product.getId()).findFirst();
        if (first.isEmpty()) {
            productList.add(product);
        }
    }

    public ArrayList<Product> getAllProducts() {
        return productList;
    }

    public void remove(int id) {
        Optional<Product> first = productList.stream().filter(product1 -> product1.getId() == id).findFirst();
        first.ifPresent(productList::remove);
    }

    public void edit(int id, Product product) {
        Optional<Product> first = productList.stream().filter(product1 -> product1.getId() == product.getId()).findFirst();
        first.ifPresent(value -> productList.set(productList.indexOf(value), product));
    }

     */

}
