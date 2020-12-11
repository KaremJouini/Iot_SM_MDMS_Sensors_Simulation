package com.example.smartmeter.services;

import com.example.smartmeter.threads.Consumer;

import static com.example.smartmeter.config.Config.SUBSCRIPTION_TOPICS;

public class SubscriptionService {
    public SubscriptionService() {
    }

    public static void subscribeToTopics(){
        //For every topic to subcribe to intialize a consumer thread
        for(String topicName : SUBSCRIPTION_TOPICS){
            Consumer consumerThread = new Consumer(topicName,topicName);
            //Starts the consumer thread to watch the topic and get messages
            consumerThread.start();
        }
    }
}
