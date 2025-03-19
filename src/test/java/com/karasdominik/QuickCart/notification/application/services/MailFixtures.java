package com.karasdominik.QuickCart.notification.application.services;

import com.karasdominik.QuickCart.notification.infrastructure.configuration.MailServerConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailFixtures {

    private final MailServerConnection connection;

    public int count() {
        return connection.getResponse().count();
    }
}
