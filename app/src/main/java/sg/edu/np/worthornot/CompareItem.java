package sg.edu.np.worthornot;

public class CompareItem {
    public String Brand;
    public Double Price;
    public int Amount;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
    public Double CalculateValue() {
        double value;
        value = getAmount() / getPrice();
        return value;
    }


}
