package main.java.lessons.starter;

import main.java.lessons.services.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.logging.Logger;

public class Starter {

    private static final Logger logger = Logger.getLogger(Starter.class.getName());

    public static void main(String[] args) {
        logger.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
        context.registerShutdownHook();
    }
}