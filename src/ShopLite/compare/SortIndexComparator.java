package ShopLite.compare;

import ShopLite.entity.Product;

import java.util.Comparator;

public class SortIndexComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getIndex() - o2.getIndex();
    }
}
