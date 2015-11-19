package main.java.lessons.starter;

import main.java.lessons.services.CommandManager;
import main.java.lessons.services.GreetingService;
import main.java.lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class LessonsConfiguration {
    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }
    @Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}