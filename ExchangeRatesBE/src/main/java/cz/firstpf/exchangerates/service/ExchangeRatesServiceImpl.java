package cz.firstpf.exchangerates.service;

import cz.firstpf.exchangerates.client.ExchangeRatesClient;
import cz.firstpf.exchangerates.dto.ExchangeRateDto;
import cz.firstpf.exchangerates.persistence.model.ExchangeRate;
import cz.firstpf.exchangerates.persistence.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementation of {@link ExchangeRatesService}
 *
 * @author Jiri Jasonek
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public final class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesClient exchangeRatesClient;
    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<ExchangeRateDto> getExchangeRates(boolean useDb) {
        if (useDb) {
            Iterable<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();
            return StreamSupport.stream(exchangeRates.spliterator(), false)
                    .map(this::entityToDto)
                    .collect(Collectors.toList());
        } else {
            List<ExchangeRateDto> exchangeRateDtos = exchangeRatesClient.getExchangeRates();
            exchangeRateDtos.stream()
                    .filter(this::validate)
                    .map(this::dtoToEntity)
                    .forEach(exchangeRateRepository::save);
            return exchangeRateDtos;
        }
    }

    private ExchangeRateDto entityToDto(ExchangeRate entity) {
        return modelMapper.map(entity, ExchangeRateDto.class);
    }

    private ExchangeRate dtoToEntity(ExchangeRateDto dto) {
        ExchangeRate entity = modelMapper.map(dto, ExchangeRate.class);
        entity.setHash(dto.hashCode());
        return entity;
    }

    private boolean validate(ExchangeRateDto dto) {
        int hashCode = dto.hashCode();
        if (exchangeRateRepository.existsByHash(hashCode)) {
            log.warn(String.format("Item with hash: %d is already saved.", hashCode));
            return false;
        } else {
            return true;
        }
    }
}
