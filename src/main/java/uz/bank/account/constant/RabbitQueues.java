package uz.bank.account.constant;


import java.util.List;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;

@Getter
@RequiredArgsConstructor
public enum RabbitQueues {

	GET_USER_INFOS(false, null, null),
	WITHDRAW_ACCOUNT(true, "withdraw-account", true),
	REFILL_ACCOUNT(true, "refill-account", true),
	OPEN_ACCOUNT(true, "open-account", true);

	private final Boolean handledByAccountService;
	private final String queueName;
	private final Boolean durable;

	public static List<Queue> getQueuesSetups() {
		return Stream.of(RabbitQueues.values())
				.filter(RabbitQueues::getHandledByAccountService)
				.map(rabbitQueues -> new Queue(rabbitQueues.getQueueName(), rabbitQueues.getDurable()))
				.toList();
	}

}
