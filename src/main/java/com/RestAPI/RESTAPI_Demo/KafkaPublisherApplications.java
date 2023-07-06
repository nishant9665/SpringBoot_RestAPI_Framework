package com.RestAPI.RESTAPI_Demo;
import com.RestAPI.RESTAPI_Demo.Config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplications {
    @Autowired
    private KafkaTemplate<String, Object> template;
    private String topic = "july6-topic";

    @GetMapping("/public/{name}")
    public String publishMessage(@PathVariable String name) {
        template.send(topic, "Hi " + name + " Welcome to java topic on 6 July");
        return "Data Published by Nishant";
    }


    @GetMapping("/publishJsonData")
    public String publishMessage() {
        User user = new User(23,"NISHANT",new String[]{"ABC","PimpleGurav","Pune"});
        template.send(topic,user);
        return "JSON DATA Published by Nishant";
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherApplications.class, args);
        System.out.println("Kafka Testing Done");

    }
}
