package mike.demo.springboot.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import mike.demo.springboot.common.service.abstraction.SingletonService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Slf4j
@Service
public class AbstractSingletonService implements SingletonService {
    protected PrototypeValidator prototypeValidator;

    @Override
    public int process(RequestParamWrapper requestParamWrapper) {
        log.info("Processing {}", requestParamWrapper);
        Errors validate = prototypeValidator.validate(requestParamWrapper);
        return validate.getErrorCount();
    }
}
