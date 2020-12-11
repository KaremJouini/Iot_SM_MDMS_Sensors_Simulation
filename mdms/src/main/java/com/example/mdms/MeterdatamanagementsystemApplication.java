package com.example.mdms;

import com.example.mdms.services.SubscriptionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeterdatamanagementsystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(MeterdatamanagementsystemApplication.class, args);
        SubscriptionService subscriptionService = new SubscriptionService();
        subscriptionService.subscribeToTopics();
    }

}
