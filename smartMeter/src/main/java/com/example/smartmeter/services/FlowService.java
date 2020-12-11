package com.example.smartmeter.services;

import com.example.smartmeter.models.Flow;
import com.example.smartmeter.threads.Consumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import static com.example.smartmeter.config.Config.HOSTNAME;
import static com.example.smartmeter.config.Config.SUBSCRIPTION_TOPICS;


@Service
public class FlowService {

    //Publishing to a topic
    public void addFlowEvent(String topicName, Flow flow) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOSTNAME);
        try (Connection connection = factory.newConnection()){
                Channel channel = connection.createChannel();
                channel.exchangeDeclare(topicName, "topic");
                String routingKey = "stock";
                String message = flow.toString();
                channel.basicPublish(topicName, routingKey, null, message.getBytes("UTF-8"));
                System.out.println("Published: " + routingKey + "':'" + message + "'");
            } catch(Exception e){
            System.out.println(e);
        }
    }


}
