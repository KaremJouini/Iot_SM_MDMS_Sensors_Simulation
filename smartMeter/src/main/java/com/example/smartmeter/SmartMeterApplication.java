package com.example.smartmeter;


import com.example.smartmeter.services.SubscriptionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartMeterApplication {

    public static void main(String[] args) {

        SpringApplication.run(SmartMeterApplication.class, args);
        SubscriptionService subscriptionService = new SubscriptionService();
        subscriptionService.subscribeToTopics();
    }

}
