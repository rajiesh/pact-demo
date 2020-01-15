package org.pact.demo;


import com.mashape.unirest.http.exceptions.UnirestException;

public class ConsumerService {
  public static void main(String[] args) throws UnirestException {
    System.out.println(new Client("http://localhost:8153/go").fetchAndProcessData());
  }
}
