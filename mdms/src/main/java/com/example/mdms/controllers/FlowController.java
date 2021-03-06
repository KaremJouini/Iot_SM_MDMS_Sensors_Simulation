package com.example.mdms.controllers;

import com.example.mdms.models.Flow;
import com.example.mdms.services.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.mdms.config.Config.PUBLISHING_TOPICS;

@RestController
public class FlowController {
@Autowired
private FlowService flowService;
    @PostMapping("/flow/{topic}")
    public ResponseEntity  addFlowEvent(@PathVariable("topic") String topic, @RequestBody Flow flow){
        if(PUBLISHING_TOPICS.contains(topic)){
            //The server has the rights to publish to the queue
            flowService.addFlowEvent(topic.toLowerCase(),flow);
            return new ResponseEntity(flow, HttpStatus.CREATED) ;
        }else{
            return new ResponseEntity(new String("Forbidden access to the topic !"), HttpStatus.FORBIDDEN) ;
        }
    }
}
