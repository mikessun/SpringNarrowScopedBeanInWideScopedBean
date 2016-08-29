package mike.demo.springboot.methodinjection.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import mike.demo.springboot.common.service.abstraction.SingletonService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@Slf4j
@Qualifier("method.injection.single.service")
public class SingletonServiceImpl implements SingletonService{

    @Lookup
    public PrototypeValidator getPrototypeValidator() {
        return null;
    }

    @Override
    public int process(RequestParamWrapper requestParamWrapper) {
        log.info("processing "+requestParamWrapper);
        Errors errors=getPrototypeValidator().validate(requestParamWrapper);
        return getPrototypeValidator().getCount();
    }
}
