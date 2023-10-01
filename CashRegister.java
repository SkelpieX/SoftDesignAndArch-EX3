
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Database {
    private Map<String, Product> products;

    public Database() {
        this.products = new HashMap<>();
        loadProductsFromCSV("ItemData.csv");
    }

    private void loadProductsFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String productID = parts[0];
                    String productName = parts[1];
                    double productPrice = Double.parseDouble(parts[2]);
                    products.put(productID, new Product(productName, productPrice));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(String productID) {
        return products.get(productID);
    }
}



class Display {
    public void show(String message) {
        System.out.println(message);
    }
}


class CashRegister {
    private Database database;
    private Display display;

    public CashRegister(Database database, Display display) {
        this.database = database;
        this.display = display;
    }

    public void scan(String productID) {
        Product product = database.getProduct(productID);
        if (product != null) {
            display.show("Product: " + product.getName() + ", Price: " + product.getPrice());
        } else {
            display.show("Product not found.");
        }
    }
}

