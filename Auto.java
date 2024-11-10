import java.math.BigDecimal;

public class Auto {
    private static int counter = 0;
    private int id;
    private String brand;
    private int year;
    private BigDecimal price;
    public Auto(String brand, int year, BigDecimal price) {
        this.id = ++counter;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public BigDecimal getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("%03d %s (%d) - %s Евро", id,brand,year,price);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id;
    }
    @Override
    public int hashCode() {
        return id;
    }
}
