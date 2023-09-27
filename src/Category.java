import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Category {

    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addManyProducts(List<Product> fewProductList) {
        this.products = Stream.concat(this.products.stream(), fewProductList.stream()).toList();
    }
}