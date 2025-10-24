package com.ing.brokage.order;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Orders {

    private @Id
    @GeneratedValue Long id;
    private Long customerId;
    private String assetName;
    private String orderSide;
    private Double size;
    private Long price;
    private String status;
    private Date createDate;

    Orders() {}

    public Orders(Long customerId, String assetName, String orderSide, Double size, Long price, String status, Date createDate) {
        this.customerId = customerId;
        this.assetName = assetName;
        this.orderSide = orderSide;
        this.size = size;
        this.price = price;
        this.status = status;
        this.createDate = createDate;
    }

    public Long getId() {
        return this.id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public String getAssetName() {
        return this.assetName;
    }

    public String getOrderSide() {
        return this.orderSide;
    }

    public Double getSize() {
        return this.size;
    }

    public Long getPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setOrderSide(String orderSide) {
        this.orderSide = orderSide;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Orders))
            return false;
        Orders Orders = (Orders) o;
        return Objects.equals(this.assetName, Orders.assetName) && Objects.equals(this.size, Orders.size)
                && Objects.equals(this.price, Orders.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.assetName, this.size, this.price);
    }

    @Override
    public String toString() {
        return "Order{" + "assetName=" + this.assetName + ", size='" + this.size + '\'' + ", price='" + this.price + '\'' + '}';
    }
}
