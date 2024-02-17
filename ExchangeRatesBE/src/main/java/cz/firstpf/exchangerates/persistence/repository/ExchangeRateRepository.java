package cz.firstpf.exchangerates.persistence.repository;

import cz.firstpf.exchangerates.persistence.model.ExchangeRate;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * Repository for {@link ExchangeRate}
 *
 * @author Jiri Jasonek
 **/

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByHash(@NonNull long hash);
    boolean existsByHash(@NonNull long hash);
}