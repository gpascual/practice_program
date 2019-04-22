import java.util.ArrayList;
import java.util.Objects;
import Products.Product;

public class Inventory {
  private ArrayList<Product> products;

  public Inventory() {
    products = new ArrayList<>();
  }

  public void updateQualities() {
    for (Product product : products) {
      product.updateQuality();
    }
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inventory inventory = (Inventory) o;
    return products.equals(inventory.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }
}
