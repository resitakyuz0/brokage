package com.ing.brokage.order;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="No usable asset left")
public class NoUsableSizeAvailableException extends RuntimeException{

}
