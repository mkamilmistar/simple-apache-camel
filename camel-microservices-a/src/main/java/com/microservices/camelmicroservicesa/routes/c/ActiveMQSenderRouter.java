package com.microservices.camelmicroservicesa.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    // timer
    from("timer:active-mq-timer?period=10000")
      .transform().constant("My Message for ActiveMQ")
      .log("${body}")
      .to("activemq:my-activemq-queue");
    // queue
  }
}

