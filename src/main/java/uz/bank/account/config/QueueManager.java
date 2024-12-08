package uz.bank.account.config;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// TODO queue initialization on application startup

@Component
public class QueueManager {


    private final RabbitAdmin  rabbitAdmin;
    private final Queue queue;

    @Autowired
    public QueueManager(RabbitAdmin rabbitAdmin, Queue queue) {
        this.rabbitAdmin = rabbitAdmin;
        this.queue= queue;
    }

    @PostConstruct
    public void initizializeQueues(){
    rabbitAdmin.declareQueue(queue);
        System.out.println("Queue initizized");
    }

}
