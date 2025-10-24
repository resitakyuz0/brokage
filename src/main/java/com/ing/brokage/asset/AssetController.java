package com.ing.brokage.asset;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AssetController {

    private final AssetService assetService;

    AssetController(AssetService assetService) {
        this.assetService = assetService;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Assets")
    List<Asset> all() {
        return assetService.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Assets")
    Asset newAsset(@RequestBody Asset newAsset) {
        return assetService.save(newAsset);
    }

    // Single item

    @GetMapping("/Assets/{id}")
    Asset one(@PathVariable Long id) {

        return assetService.findById(id);
    }

    @DeleteMapping("/Assets/{id}")
    void deleteAsset(@PathVariable Long id) {
        assetService.deleteById(id);
    }
}
