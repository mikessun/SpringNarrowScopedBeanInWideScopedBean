package mike.demo.springboot.methodinjection.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.service.impl.AbstractPrototypeValidatorImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Slf4j
@Scope("prototype")
@Service
public class MethodInjectionPrototypeValidator extends AbstractPrototypeValidatorImpl {
    @Override
    public Errors validate(Object o) {
        log.info(" {} validating ", this);
        return super.validate(o);
    }
}
