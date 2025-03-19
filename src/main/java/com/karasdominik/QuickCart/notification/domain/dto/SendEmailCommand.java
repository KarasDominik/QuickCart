package com.karasdominik.QuickCart.notification.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.notification.domain.valueobjects.Email;
import lombok.Builder;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record SendEmailCommand(OrderId orderId, Email email) {

    private static final FieldInfo ORDER_ID = new FieldInfo("orderId");
    private static final FieldInfo EMAIL = new FieldInfo("email");

    public SendEmailCommand {
        notNull(orderId, ORDER_ID);
        notNull(email, EMAIL);
    }
}
