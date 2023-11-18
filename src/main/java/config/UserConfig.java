package config;

import com.cbfacademy.apiassessment.entities.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User userBean(){
        return new User();
    }

}
