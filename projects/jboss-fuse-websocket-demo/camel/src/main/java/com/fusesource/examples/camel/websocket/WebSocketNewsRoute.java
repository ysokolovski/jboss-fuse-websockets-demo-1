/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fusesource.examples.camel.websocket;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.websocket.WebsocketComponent;

import javax.jms.ConnectionFactory;

public class WebSocketNewsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

           from("activemq:topic:newsTopic").routeId("fromJMStoWebSocketNews")
             .log(LoggingLevel.DEBUG,">> News info received : ${body}")
             .delay(5000)
             .to("websocket://0.0.0.0:9090/newsTopic?sendToAll=true&staticResources=classpath:webapp");

    }
}