package com.karasdominik.QuickCart.notification.application.ports.inbound;

import com.karasdominik.QuickCart.notification.domain.dto.SendEmailCommand;

public interface EmailMessagingApi {

    void send(SendEmailCommand command);
}
