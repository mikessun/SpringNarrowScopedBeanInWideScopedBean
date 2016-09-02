package mike.demo.springboot.methodinjection.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.annotation.PrototypeImplType;
import mike.demo.springboot.common.annotation.PrototypeQualifier;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import mike.demo.springboot.common.service.impl.AbstractSingletonService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@PrototypeQualifier(PrototypeImplType.SPRING_COUPLED)
public class MethodInjectionSingletonService extends AbstractSingletonService {

    @Lookup
    public PrototypeValidator getPrototypeValidator() {
        return null;
    }

    @Override
    public int process(RequestParamWrapper requestParamWrapper) {
        log.info("processing {}", requestParamWrapper);
        return super.process(requestParamWrapper);
    }
}
