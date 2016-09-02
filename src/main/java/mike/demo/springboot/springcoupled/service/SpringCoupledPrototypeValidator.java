package mike.demo.springboot.springcoupled.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.annotation.PrototypeImplType;
import mike.demo.springboot.common.annotation.PrototypeQualifier;
import mike.demo.springboot.common.service.impl.AbstractPrototypeValidator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PrototypeQualifier(PrototypeImplType.SPRING_COUPLED)
@Slf4j
public class SpringCoupledPrototypeValidator extends AbstractPrototypeValidator {
    @Override
    public Errors validate(Object o) {
        log.info(" {} validating ", this);
        return super.validate(o);
    }
}
