package com.ing.brokage.order;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
class OrdersController {

    private final OrdersService ordersService;

    OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Orders")
    List<Orders> all() {
        return ordersService.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Orders")
    Orders newOrders(@RequestBody Orders newOrders) {
        return ordersService.save(newOrders);
    }

    // Single item

    @GetMapping("/Orders/{id}")
    Orders one(@PathVariable Long id) {

        return ordersService.findById(id);
    }

    @DeleteMapping("/Orders/{id}")
    void deleteOrders(@PathVariable Long id) {
        ordersService.deleteById(id);
    }

    @PostMapping("/Orders/{id}")
    Orders matchOrders(@PathVariable Long id) {
        return ordersService.match(id);
    }

}
