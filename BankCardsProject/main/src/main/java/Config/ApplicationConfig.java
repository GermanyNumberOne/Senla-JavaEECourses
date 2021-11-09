package Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper getMMbean(){
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper getOMbean(){
        return new ObjectMapper();
    }
}
