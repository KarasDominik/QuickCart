package com.karasdominik.QuickCart.order.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orders;

    @Override
    public void save() {

    }
}
