package mike.demo.springboot.springcoupled.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.service.impl.AbstractPrototypeValidatorImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Scope("prototype")
@Service
@Slf4j
public class SpringCoupledPrototypeValidator extends AbstractPrototypeValidatorImpl {
    @Override
    public Errors validate(Object o) {
        log.info(" {} validating ", this);
        return super.validate(o);
    }
}
