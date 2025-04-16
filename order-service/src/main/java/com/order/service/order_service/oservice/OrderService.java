package com.order.service.order_service.oservice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.order.service.order_service.pojo.OrderInfo;

@Service
public class OrderService {
	@Autowired
	public StreamBridge streamBridge;
	public String createOrder()
	{
		OrderInfo newOrder=new OrderInfo();
		newOrder.setOrderId(UUID.randomUUID().toString());
		newOrder.setEmail("abc@gmail.com");
		newOrder.setPhoneNo("123456");
		newOrder.setOrderStatus(true);
		String msg=orderCreatedNotification(newOrder);
		System.out.println("order created successfully!!!.......orderservice sysout "+msg);
	
		return "message from order service : order created successfully...";
		
	}

	private String orderCreatedNotification(OrderInfo newOrder) {
		//System.out.println("notification send successfully");
		streamBridge.send("ordercreatednotification-out-0",newOrder);
		
		return "notification send successfully";
		
	}

}
