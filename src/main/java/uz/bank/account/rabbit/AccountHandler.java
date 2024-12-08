    package uz.bank.account.rabbit;

    import lombok.RequiredArgsConstructor;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.stereotype.Component;
    import uz.bank.account.dto.AccountReq;
    import uz.bank.account.service.accountserviceImpl.AccountServiceImpl;

    @Component
    @RequiredArgsConstructor
    public class AccountHandler {
        private static final Logger log = LoggerFactory.getLogger(AccountHandler.class);
        private final AccountServiceImpl accountService;

        @RabbitListener(queues = "open-account")
        public void accountCreation(AccountReq accountReq){
            accountService.openAccount(accountReq);
            log.info("Account created" + accountReq );
        }

    // A2A - account to account -- 20206 to 20206
    // A2P - account to per -- 20206 to 17810
    // P2A - per to account -- 17810 to 20206
    // Conversion - account to account  -- 20206 to 20206


}
