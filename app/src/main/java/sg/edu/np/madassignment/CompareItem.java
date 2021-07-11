package sg.edu.np.madassignment;

public class CompareItem {
    public String Brand;
    public Double Price;
    public Double Amount;

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

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }
    public Double CalculateValue() {
        double value;
        value = getAmount() / getPrice();
        return value;
    }


}
