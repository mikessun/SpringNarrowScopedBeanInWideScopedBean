package mike.demo.springboot.methodinjection.service;

import mike.demo.springboot.common.service.impl.AbstractPrototypeValidatorImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class MethodInjectionPrototypeValidator extends AbstractPrototypeValidatorImpl{

    public MethodInjectionPrototypeValidator() {
    }
}
