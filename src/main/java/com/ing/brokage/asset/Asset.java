package com.ing.brokage.asset;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Asset {

    private @Id
    @GeneratedValue Long id;
    private Long customerId;
    private String assetName;
    private Double size;
    private Double usableSize;

    Asset() {}

    public Asset(Long customerId, String assetName, Double size, Double usableSize) {
        this.customerId = customerId;
        this.assetName = assetName;
        this.size = size;
        this.usableSize = usableSize;
    }

    public Asset(Long customerId, String assetName, Double usableSize) {
        this.customerId = customerId;
        this.assetName = assetName;
        this.usableSize = usableSize;
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

    public Double getSize() {
        return this.size;
    }

    public Double getUsableSize() {
        return this.usableSize;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setUsableSize(Double usableSize) {
        this.usableSize = usableSize;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Asset))
            return false;
        Asset Asset = (Asset) o;
        return Objects.equals(this.assetName, Asset.assetName) && Objects.equals(this.size, Asset.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.assetName, this.size);
    }

    @Override
    public String toString() {
        return "Asset{" + "assetName=" + this.assetName + ", size='" + '}';
    }
}
