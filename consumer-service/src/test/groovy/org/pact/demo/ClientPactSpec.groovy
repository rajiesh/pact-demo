package org.pact.demo

import au.com.dius.pact.consumer.PactVerificationResult
import au.com.dius.pact.consumer.groovy.PactBuilder
import spock.lang.Specification

class ClientPactSpec extends Specification {

  private Client client
  private PactBuilder provider

  def setup() {
    client = new Client('http://localhost:8153/go')
    provider = new PactBuilder()
    provider {
      serviceConsumer 'ConsumerService'
      hasPactWith 'ProviderService'
      port 8153
    }
  }

  def 'Pact with Provider service'() {
    given:
    def json = [
      count: "100"
    ]
    provider {
      given('data count > 0')
      uponReceiving('a request for json data')
      withAttributes(path: '/go/api/dashboard')
      willRespondWith(status: 200)
      withBody {
        count "100"
      }
    }

    when:
    def result
    PactVerificationResult pactResult = provider.runTest {
      result = client.fetchAndProcessData()
    }

    then:
    pactResult == PactVerificationResult.Ok.INSTANCE
  }

  def 'when there is no data'() {
    given:
    provider {
      given('data count == 0')
      uponReceiving('a request for json data')
      withAttributes(path: '/go/api/dashboard')
      willRespondWith(status: 404)
    }

    when:
    def result
    PactVerificationResult pactResult = provider.runTest {
      result = client.fetchAndProcessData()
    }

    then:
    pactResult == PactVerificationResult.Ok.INSTANCE
  }

}
