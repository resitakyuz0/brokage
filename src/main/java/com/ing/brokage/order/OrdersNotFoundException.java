package com.ing.brokage.order;


class OrdersNotFoundException extends RuntimeException {

    OrdersNotFoundException(Long id) {
        super("Could not find Orders " + id);
    }
}
