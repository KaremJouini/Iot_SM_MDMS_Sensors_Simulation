package com.example.mdms.services;

import com.example.mdms.models.Flow;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import static com.example.mdms.config.Config.HOSTNAME;


@Service
public class FlowService {

    //Publishing to a topic
    public void addFlowEvent(String topicName, Flow flow) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOSTNAME);
        try (Connection connection = factory.newConnection()){
                Channel channel = connection.createChannel();
                channel.exchangeDeclare(topicName, "topic");
                String routingKey = topicName;
                String message = flow.toString();
                channel.basicPublish(topicName, routingKey, null, message.getBytes("UTF-8"));
                System.out.println("Published: " + routingKey + "':'" + message + "'");
            } catch(Exception e){
            System.out.println(e);
        }
    }


}
