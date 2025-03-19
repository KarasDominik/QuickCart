package com.karasdominik.QuickCart.notification.infrastructure.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MailServerConnection {

    private static final String MAILHOG_HTTP_URI = "http://localhost:%s/api/v2/messages";

    @Value("${spring.mail.http.port}")
    private int port;

    private final ObjectMapper mapper;

    public MailhogResponse getResponse() {
        try {
            var response = HttpClient.newHttpClient()
                    .send(HttpRequest.newBuilder()
                            .uri(URI.create(String.format(MAILHOG_HTTP_URI, port)))
                            .GET()
                            .build(), HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), MailhogResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public record MailhogResponse(int count, int total,
                                  List<MailhogEmail> items) {

        public record MailhogEmail(@JsonProperty("Content") Content content) {

            public String from() {
                return content.headers().from().getFirst();
            }

            public String to() {
                return content.headers().to().getFirst();
            }

            public String body() {
                return content.body();
            }

            public String subject() {
                return content.headers().subject().getFirst();
            }

            public record Content(@JsonProperty("Headers") Headers headers,
                                  @JsonProperty("Body") String body) {

                public record Headers(@JsonProperty("From") List<String> from,
                                      @JsonProperty("To") List<String> to,
                                      @JsonProperty("Subject") List<String> subject) {}
            }
        }
    }
}
