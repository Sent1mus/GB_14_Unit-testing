package HW.Shop;

import java.util.List;

public class Shop {
    private List<first.Shop.Product> products;

    // Геттеры, сеттеры:
    public List<first.Shop.Product> getProducts() {
        return products;
    }

    public void setProducts(List<first.Shop.Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<first.Shop.Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        return null;
    }

    // Метод должен вернуть самый дорогой продукт
    public first.Shop.Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        return null;
    }

}