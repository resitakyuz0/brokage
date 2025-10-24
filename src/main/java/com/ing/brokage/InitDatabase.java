package com.ing.brokage;

import com.ing.brokage.asset.Asset;
import com.ing.brokage.asset.AssetRepository;
import com.ing.brokage.order.OrdersRepository;
import com.ing.brokage.order.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
class SeedDatabase {

    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    private static final Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AssetRepository repository, OrdersRepository ordersRepository) {

        return args -> {
            log.info("Preloading " + repository.save(new Asset(1L,"TRY", 1000.00)));

            log.info("Preloading " + repository.save(new Asset(2L,"TRY", 3000.00)));

            log.info("Preloading " + repository.save(new Asset(3L,"TRY", 2000.00)));


            log.info("Preloading " + repository.save(new Asset(1L,"GOLD", 1000.00)));

            Date date = fmt.parse("2025-10-20");

            log.info("Preloading " + ordersRepository.save(new Orders(1L,"TRY","BUY",1000.00,1000L,"MATCHED",date)));

            log.info("Preloading " + ordersRepository.save(new Orders(2L,"TRY","BUY",3000.00,1000L,"MATCHED",date)));

            log.info("Preloading " + ordersRepository.save(new Orders(3L,"TRY","BUY",2000.00,1000L,"MATCHED",date)));


        };
    }
}
