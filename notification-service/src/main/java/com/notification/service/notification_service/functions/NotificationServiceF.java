package com.notification.service.notification_service.functions;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notification.service.notification_service.pojo.OrderInfo;

@Configuration
public class NotificationServiceF {
	
	//this is for testing purpose
	@Bean
	public Supplier<String> testing()
	{
		return ()->"This is for testing purpose!!!";
	}
	@Bean
	public Function<String,String> inout()
	{
		return (message)->"hi this is good "+message;
	}
	
	@Bean
	public Function<OrderInfo,String> orderNotification()
	{
		return (orderInfo)->{
			sendNotification(orderInfo);
			System.out.println(orderInfo.getEmail());
			System.out.println(orderInfo.getOrderId());
			return orderInfo.getOrderId();
		};
	}
	private void sendNotification(OrderInfo orderInfo) {
		System.out.println("notification send.....");
		
	}

}
