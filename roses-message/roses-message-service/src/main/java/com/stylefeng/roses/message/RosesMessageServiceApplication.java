package com.stylefeng.roses.message;

import com.stylefeng.roses.api.message.model.ReliableMessage;
import com.stylefeng.roses.message.activemq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 消息服务子系统
 *
 * @author stylefeng
 * @Date 2018/1/22 21:27
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class RosesMessageServiceApplication {

    @Autowired
    private MessageSender messageSender;

    public static void main(String[] args) {
        SpringApplication.run(RosesMessageServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                ReliableMessage reliableMessage = new ReliableMessage();
                reliableMessage.setConsumerQueue("aaa");
                reliableMessage.setMessageBody("aasdfasdfasdfasdf");

                messageSender.sendMessage(reliableMessage);
            }
        };
    }

}