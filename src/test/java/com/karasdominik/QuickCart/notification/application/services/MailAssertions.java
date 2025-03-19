package com.karasdominik.QuickCart.notification.application.services;

import com.karasdominik.QuickCart.notification.infrastructure.configuration.MailServerConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Component
@RequiredArgsConstructor
public class MailAssertions {

    private final MailServerConnection mailServerConnection;

    public void assertEmailSent(String sender, String recipient, String content) {
        var response = mailServerConnection.getResponse();

        assertThat(response.count()).isEqualTo(1);

        var email = response.items().getFirst();
        assertThat(email.from()).isEqualTo(sender);
        assertThat(email.to()).isEqualTo(recipient);
        assertThat(email.subject()).isEqualTo("Order confirmation");
        assertThat(email.body()).contains(content);
    }
}
