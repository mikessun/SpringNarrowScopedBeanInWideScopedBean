package mike.demo.springboot.springcoupled.config;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.annotation.PrototypeQualifier;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class PrototypeBeanConfig {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @PrototypeQualifier(PrototypeQualifier.PrototypeImplType.SPRING_COUPLED)
    public PrototypeValidator getPrototypeValidator() {
        return applicationContext.getBean(PrototypeValidator.class);
    }
}
