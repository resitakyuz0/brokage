package com.ing.brokage.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public Asset save(Asset newAsset) {
        return assetRepository.save(newAsset);
    }

    public Asset findById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));
    }

    public void deleteById(Long id) {

        assetRepository.deleteById(id);
    }
}
