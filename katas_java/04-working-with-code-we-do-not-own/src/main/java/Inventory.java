import items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
  private ArrayList<Item> items;

  public Inventory() {
    this.items = new ArrayList<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inventory inventory = (Inventory) o;
    return items.equals(inventory.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  public void updateQuality() {
    for (Item item : items) {
      --item.sellIn;
      --item.quality;
    }
  }

  public void addItem(Item item) {
    items.add(item);
  }
}
