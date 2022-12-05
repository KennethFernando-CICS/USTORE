
package model;

import java.util.*;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;
    private String sizeString;
    private List<String> sizeList;
    private String pictureName;
    
    public Product(){};

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public List<String> getSizeList() {
        return sizeList;
    }
    public String getSizeString() {
        return sizeString;
    }
    public String getPictureName() {
        return pictureName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSizeList(String sizeString) {
        List<String> tempList = new ArrayList<>();
        this.setSizeString(sizeString);
        String[] sizes = sizeString.split("/");
        for (String size : sizes) {
            tempList.add(size);
        }
        this.setSizeList(tempList);
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
        
    public String toString(){
        return this.getName();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSizeString(String sizeString) {
        this.sizeString = sizeString;
    }

    public void setSizeList(List<String> sizeList) {
        this.sizeList = sizeList;
    }
}
