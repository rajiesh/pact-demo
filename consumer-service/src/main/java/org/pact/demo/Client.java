package org.pact.demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Client {

  private final String url;

  public Client(String url) {
    this.url = url;
  }

  private Optional<JsonNode> loadProviderJson() throws UnirestException {
    HttpRequest getRequest = Unirest.get(url + "/api/dashboard").header("Accept", "application/vnd.go.cd+json");
//    System.out.println("This is the response body "+ getRequest.getBody().toString());

    HttpResponse<JsonNode> jsonNodeHttpResponse = getRequest.asJson();
    if (jsonNodeHttpResponse.getStatus() == 200) {
      return Optional.of(jsonNodeHttpResponse.getBody());
    } else {
      return Optional.empty();
    }
  }

  public String fetchAndProcessData() throws UnirestException {
    Optional<JsonNode> data = loadProviderJson();
    System.out.println("data=" + data);

    if (data != null && data.isPresent()) {
      JSONObject jsonObject = data.get().getObject();
      return jsonObject.getString("count");
    } else {
      return "empty";
    }

    }
}
