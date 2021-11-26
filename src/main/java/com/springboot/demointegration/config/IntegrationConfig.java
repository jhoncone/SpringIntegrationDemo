package com.springboot.demointegration.config;

import com.springboot.demointegration.model.Alumno;
import com.springboot.demointegration.model.Escuela;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {

    @Bean
    public MessageChannel reiceverChanell(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }


    @ServiceActivator(inputChannel = "router.channel")
    @Bean
    public PayloadTypeRouter router(){
        PayloadTypeRouter router=new PayloadTypeRouter();
        router.setChannelMapping(Alumno.class.getName(),"student.channel");
        router.setChannelMapping(Escuela.class.getName(),"school.channel");
        return router;
    }
/*
    @Bean
    @Transformer(inputChannel = "integration.student.gateway.channel",outputChannel ="integration.student.objectToJson.channel")
    public HeaderEnricher enrichHeader(){
        Map<String, HeaderValueMessageProcessor<String>> headersToAdd=new HashMap<>() ;
        headersToAdd.put("header1",new StaticHeaderValueMessageProcessor<String>("Test Header 1"));
        headersToAdd.put("header2",new StaticHeaderValueMessageProcessor<String>("Test Header 2"));
        HeaderEnricher enricher=new HeaderEnricher(headersToAdd);
        return enricher;
    }

    @Bean
    @Transformer(inputChannel = "integration.student.gateway.channel",outputChannel ="integration.student.objectToJson.channel")
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());
    }

    @Bean
    public Jackson2JsonObjectMapper getMapper(){
        ObjectMapper mapper =new ObjectMapper();
        return new Jackson2JsonObjectMapper(mapper);
    }

    @Bean
    @Transformer(inputChannel = "integration.student.objectToJson.channel",outputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Student.class);
    }

 */
}
