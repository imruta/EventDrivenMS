package com.order.service.order_service.functions;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationackFunction {
	
	@Bean
	public Consumer<String> receiveAckFromNotificationService()
	{
	return (str)->{
		System.out.println("ack from notification received="+ str);
	};
	}

}
