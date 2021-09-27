package ShopLite.entity;

public class Product {
    private int sortIndex;
    private String name;
    private int price;

    public Product(String name, int price, int sortIndex) {
        this.sortIndex = sortIndex;
        this.name = name;
        this.price = price;
    }

    public Product(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public String toString() {
        return "index: " + sortIndex + " name: " + name + " price: " + price;
    }

    public int getIndex() {
        return sortIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
