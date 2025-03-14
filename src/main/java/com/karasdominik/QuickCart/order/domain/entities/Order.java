package com.karasdominik.QuickCart.order.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Order {

    @Id
    private UUID id;
}
