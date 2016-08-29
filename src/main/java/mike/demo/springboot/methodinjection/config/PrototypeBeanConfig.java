package mike.demo.springboot.methodinjection.config;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import mike.demo.springboot.methodinjection.service.MethodInjectionPrototypeValidator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class PrototypeBeanConfig {


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeValidator getPrototypeValidator() {
        return new MethodInjectionPrototypeValidator();
    }
}
