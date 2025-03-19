package com.karasdominik.QuickCart.notification.application.services;

import com.karasdominik.QuickCart.notification.application.ports.inbound.EmailMessagingApi;
import com.karasdominik.QuickCart.notification.domain.dto.SendEmailCommand;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmailServiceImpl implements EmailMessagingApi {

    @Value("${quickcart.mail.from}")
    private String from;

    private final JavaMailSender mailSender;

    @Override
    public void send(SendEmailCommand command) {
        mailSender.send(mimeMessage -> {
            mimeMessage.setFrom(from);
            mimeMessage.setSubject("Order confirmation");
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(command.email().value()));
            mimeMessage.setText("Your order with id " + command.orderId() + " has been created");
        });
    }
}
