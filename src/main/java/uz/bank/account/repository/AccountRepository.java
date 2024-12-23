package uz.bank.account.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.PageableResponse;
import uz.bank.account.entity.AccountInfos;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfos, Long> {

    Optional<AccountInfos> findByClientId(String clientId);

    Optional<AccountInfos> findByClientIdAndCurrency_CurrencyId(String accountId, String currencyId);

	Optional<AccountInfos> findByAccountNumber(String accountNumber);

	Page<AccountInfos> findAll(Specification<AccountInfos> specification, Pageable pageable);

    PageableResponse<AccountInfosDto> findAll(Specification<AccountInfos> spec);
}
