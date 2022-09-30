package com.spring.test;

public class Product implements Comparable<Product> {
    private String productName;
    private int price;

    @Override
    public String toString() {
        return "{" +
            " productName='" + getProductName() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public int compareTo(Product o) {
        // TODO Auto-generated method stub
        if (price == o.price) {
            return 0;
        } else if (price > o.price) {
            return 1;
        }
        return -1;
    }

}
