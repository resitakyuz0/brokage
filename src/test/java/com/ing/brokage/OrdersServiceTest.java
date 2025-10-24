package com.ing.brokage;

import com.ing.brokage.order.Orders;
import com.ing.brokage.order.OrdersRepository;
import com.ing.brokage.order.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrdersServiceTest {

    @Mock
    private OrdersRepository OrdersRepository;

    @InjectMocks
    private OrdersService OrdersService;

    @Test
    void shouldReturnUserWhenIdExists() throws ParseException {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date date = fmt.parse("2025-10-20");

        Orders mockOrders = new Orders(1L,"TRY","BUY",1000.00,1000L,"MATCHED",date);
        when(OrdersRepository.findById(1L)).thenReturn(Optional.of(mockOrders));

        Orders result = OrdersService.findById(1L);

        assertEquals("TRY", result.getAssetName());
        verify(OrdersRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenOrdersNotFound() {
        when(OrdersRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> OrdersService.findById(99L));

        assertEquals("Could not find Orders " + 99, exception.getMessage());
    }


}
