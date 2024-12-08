package uz.bank.account.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "open-account-exchange";
    public static final String ROUTING_NAME = "open-account-routingKey";

	@Bean
	public RabbitAdmin rabbitAdmin(RabbitTemplate rabbitTemplate) {
		return new RabbitAdmin(rabbitTemplate);
	}

    @Bean
    public DirectExchange openAccountExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

//    @Bean
//    public Binding openAccountBinding(DirectExchange openAccountExchange) {
//        return BindingBuilder.bind(openAccountQueue).to(openAccountExchange).with(ROUTING_NAME);
//    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(EXCHANGE_NAME);
        return rabbitTemplate;
    }

}
