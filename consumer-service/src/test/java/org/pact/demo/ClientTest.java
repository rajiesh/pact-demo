package org.pact.demo;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.pact.demo.*;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class ClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8153);

    @Test
    public void canProcessTheJsonPayloadFromTheProvider() throws UnirestException, InterruptedException {


        stubFor(get(urlPathEqualTo("/go/api/dashboard"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"count\": \"100\"}")));

        String data = new Client("http://localhost:8153/go").fetchAndProcessData();

        assertThat(data, is("100"));

    }

}
