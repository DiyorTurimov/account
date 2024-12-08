package uz.bank.account.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import uz.bank.account.constant.RabbitQueues;

@Log4j2
@Component
@RequiredArgsConstructor
public class QueueManager {

    private final RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void initializeQueues(){
		RabbitQueues.getQueuesSetups().stream()
				.map(rabbitAdmin::declareQueue)
				.forEach(queueName -> log.info("Queue {} created.", queueName));
    }

}
