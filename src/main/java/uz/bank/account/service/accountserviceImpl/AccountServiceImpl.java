package uz.bank.account.service.accountserviceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uz.bank.account.constant.paging.AccountFilter;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.dto.PageableRequest;
import uz.bank.account.dto.PageableResponse;
import uz.bank.account.entity.AccountInfos;
import uz.bank.account.entity.Currency;
import uz.bank.account.exception.ApplicationException;
import uz.bank.account.exception.cause.ApplicationExceptionCause;
import uz.bank.account.mapper.AccountMapper;
import uz.bank.account.repository.AccountRepository;
import uz.bank.account.repository.CurrencyRepository;
import uz.bank.account.service.AccountService;
import uz.bank.account.util.AccountNumberGenerator;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountMapper accountMapper;
    private final AccountNumberGenerator accountNumberGenerator;


    @Override
    public AccountInfosDto openAccount(AccountReq accountReq) {

        Currency currency = currencyRepository.findByCurrencyId(accountReq.getCurrencyCode())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));

        Optional<AccountInfos> optionalAccountInfos = accountRepository
                .findByClientIdAndCurrency_CurrencyId(accountReq.getClientId(), accountReq.getCurrencyCode());
        if (optionalAccountInfos.isPresent()) {
            throw new DuplicateKeyException("Account already exists");
        }

        String accountNumber = accountNumberGenerator.retrieve(accountReq.getCurrencyCode());

        AccountInfos accountInfos = null;// TODO

        accountInfos.setAccountNumber(accountNumber);

        return accountMapper.toDto(accountRepository.save(accountInfos));
    }

    @Override
    public AccountInfosDto getById(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountInfos -> accountMapper.toDto(accountInfos))
                .orElseThrow(() -> new ApplicationException(ApplicationExceptionCause.ENTITY_NOT_FOUND_BY_ID.getCode()));
    }

	@Override
	public PageableResponse<AccountInfosDto> getAccountsByClientId(String clientId, PageableRequest<AccountFilter> pageableRequest) {
		Sort sort = switch (pageableRequest.direction()) {
			case ASC -> Sort.by(pageableRequest.sortProperty().getPropertyName()).ascending();
			case DESC -> Sort.by(pageableRequest.sortProperty().getPropertyName()).descending();
			case NONE -> Sort.by(pageableRequest.sortProperty().getPropertyName());
		};

		PageRequest pageRequest = PageRequest.of(pageableRequest.page(), pageableRequest.size(), sort);

		Specification<AccountInfos> specification = buildSpecification(pageableRequest.filterProperty(), pageableRequest.filterValue());

		Page<AccountInfos> accountPage = accountRepository.findAll(specification, pageRequest);

		List<AccountInfosDto> accountDtos = accountPage.stream()
				.map(accountMapper::toDto)
				.toList();

		return PageableResponse.<AccountInfosDto>builder()
				.isFirst(false)
				.isLast(false)
				.totalPages(0)
				.page(0)
				.size(0)
				.data(accountDtos)
				.build();
	}

	private Specification<AccountInfos> buildSpecification(AccountFilter filterProperty, String filterValue) {
		return (Root<AccountInfos> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			if (filterValue == null || filterValue.isBlank()) {
				return cb.conjunction();
			}

			String propertyName = filterProperty.getPropertyName();
			Expression<String> expression = root.get(propertyName).as(String.class);

			return cb.like(cb.lower(expression), "%" + filterValue.toLowerCase() + "%");
		};
	}

}
