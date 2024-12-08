package uz.bank.account.repository;

public class AccountInfosQuery {
    private static final String SAVE_ACCOUNT_INFO = """
            INSERT INTO account_service.account_infos VALUES ( id, phone, clientId, accountNumber, createdAt, updatedAt;)
            """;
}
