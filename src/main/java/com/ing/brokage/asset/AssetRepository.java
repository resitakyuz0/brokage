package com.ing.brokage.asset;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Asset findByCustomerId(Long customerId);
    Asset findByCustomerIdAndAssetName(Long customerId, String assetName);

}
