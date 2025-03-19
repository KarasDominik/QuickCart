package com.karasdominik.QuickCart.order.domain.entities;

import com.karasdominik.QuickCart.order.domain.dto.CreateOrderCommand;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.dto.OrderStatus;
import com.karasdominik.QuickCart.order.domain.dto.OrderedProductId;
import com.karasdominik.QuickCart.order.domain.valueobjects.Email;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static com.karasdominik.QuickCart.order.domain.dto.OrderStatus.WAITING_FOR_PAYMENT;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static java.util.stream.Collectors.toSet;

@Entity
@Table(name = "\"order\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Order {

    public static Order create(CreateOrderCommand command, Supplier<Instant> now) {
        var order = Order.builder()
                .id(OrderId.create())
                .email(command.email())
                .createdAt(now.get())
                .status(WAITING_FOR_PAYMENT)
                .build();

        order.addAll(command.orderedProducts().entrySet().stream()
                .map(entry -> OrderedProduct.builder()
                        .id(OrderedProductId.create())
                        .order(order)
                        .productId(entry.getKey())
                        .quantity(entry.getValue())
                        .build())
                .collect(toSet()));
        return order;
    }

    @EmbeddedId
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "id"))
    private OrderId id;

    private Instant createdAt;

    @Enumerated(STRING)
    private OrderStatus status;

    private Email email;

    @OneToMany(mappedBy = "order", fetch = EAGER, cascade = ALL)
    @Builder.Default
    private Set<OrderedProduct> orderedProducts = new HashSet<>();

    private void addAll(Collection<OrderedProduct> products) {
        this.orderedProducts.addAll(products);
    }
}
