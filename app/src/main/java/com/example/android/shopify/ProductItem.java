package com.example.android.shopify;

public class ProductItem {

    int imageId;
    String productName;
    String productPrice;

    public ProductItem(int imageId, String productName, String productPrice) {
        this.imageId = imageId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
