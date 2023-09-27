import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Basket {

    private List<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addManyProducts(List<Product> fewProductList) {
        this.products = Stream.concat(this.products.stream(), fewProductList.stream()).toList();
    }
}
