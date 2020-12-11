package com.example.smartmeter.threads;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import static com.example.smartmeter.config.Config.HOSTNAME;

public class Consumer extends Thread {
    private String topicName;
    private String routingKey;
    public Consumer(String topicName,String routingKey) {
        this.topicName = topicName;
        this.routingKey = routingKey;
    }

    @Override
    public void run() {
        try{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOSTNAME);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(topicName, "topic");
        if(topicName.equals("tension")){
            //Maximum qos for tension events
            channel.basicQos(1,false);
        }
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,topicName,this.routingKey);
        System.out.println(" [*] Waiting for "+ topicName+" messages from MDMS ...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" Message Received '" +
                    delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }catch(Exception e){
            System.out.println(e);
        }
    }
}
