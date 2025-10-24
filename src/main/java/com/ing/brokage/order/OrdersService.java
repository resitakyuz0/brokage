package com.ing.brokage.order;


import com.ing.brokage.asset.Asset;
import com.ing.brokage.asset.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private AssetRepository assetRepository;

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Orders save(Orders newOrders) {

        newOrders.setStatus("PENDING");


        Asset tryAsset = assetRepository.findByCustomerIdAndAssetName(newOrders.getCustomerId(),"TRY");
        Asset customerAsset = assetRepository.findByCustomerIdAndAssetName(newOrders.getCustomerId(),newOrders.getAssetName());

        if (customerAsset == null ) throw new NoUsableSizeAvailableException();

        if (newOrders.getOrderSide().equals("BUY")) {
            if (newOrders.getSize() > tryAsset.getUsableSize()) throw new NoUsableSizeAvailableException();
        } else {
            if ((newOrders.getSize() > customerAsset.getUsableSize())) throw new NoUsableSizeAvailableException();
        }


        return ordersRepository.save(newOrders);
    }

    public Orders findById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new OrdersNotFoundException(id));
    }

    public void deleteById(Long id) {

        ordersRepository.deleteById(id);
    }

    public Orders match(Long id) {

        Orders orderToBeMatched = ordersRepository.getReferenceById(id);

        if (!orderToBeMatched.getStatus().equals("PENDING")) throw new NoUsableSizeAvailableException();

        orderToBeMatched.setStatus("MATCHED");

        Asset tryAsset = assetRepository.findByCustomerIdAndAssetName(orderToBeMatched.getCustomerId(),"TRY");
        Asset customerAsset = assetRepository.findByCustomerIdAndAssetName(orderToBeMatched.getCustomerId(),orderToBeMatched.getAssetName());


        if (orderToBeMatched.getOrderSide().equals("BUY")) {
            if (orderToBeMatched.getSize() > tryAsset.getUsableSize()) throw new NoUsableSizeAvailableException();
            tryAsset.setUsableSize(tryAsset.getUsableSize() - orderToBeMatched.getSize());

            if (customerAsset == null) {
                customerAsset = new Asset(orderToBeMatched.getCustomerId(), orderToBeMatched.getAssetName(),null,orderToBeMatched.getSize());
            } else {
                customerAsset.setUsableSize(customerAsset.getUsableSize() + orderToBeMatched.getSize());
            }
        } else {
            if (orderToBeMatched.getSize() > customerAsset.getUsableSize()) throw new NoUsableSizeAvailableException();
            customerAsset.setUsableSize(customerAsset.getUsableSize() - orderToBeMatched.getSize());
            tryAsset.setUsableSize(tryAsset.getUsableSize() + orderToBeMatched.getSize());
            assetRepository.save(tryAsset);
        }

        assetRepository.save(customerAsset);

        return ordersRepository.save(orderToBeMatched);

    }
}

