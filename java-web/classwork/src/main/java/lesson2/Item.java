package lesson2;

public class Item {
  Integer id;
  String name;
  Double price;

  public Item(Integer id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }
}
