package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.entities.StripeProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class StripeProductRepositoryImpl implements StripeProductRepository {

    private final StripeProductJpaRepository repository;

    @Override
    public void save(StripeProduct product) {
        repository.save(product);
    }

    @Override
    public StripeProduct findOrThrow(ProductId id) {
        return repository.findById(id)
                .orElseThrow();
    }

    @Override
    public Optional<StripeProduct> getBy(ProductId id) {
        return repository.findById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
