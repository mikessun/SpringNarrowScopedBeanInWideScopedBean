package mike.demo.springboot.springcoupled.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.annotation.PrototypeImplType;
import mike.demo.springboot.common.annotation.PrototypeQualifier;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import mike.demo.springboot.common.service.impl.AbstractSingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@PrototypeQualifier(PrototypeImplType.SPRING_COUPLED)
public class SpringCoupledSingletonService extends AbstractSingletonService {
    @Autowired
    @PrototypeQualifier(PrototypeImplType.SPRING_COUPLED)
    private PrototypeValidator prototypeValidator;

    @Override
    public int process(RequestParamWrapper requestParamWrapper) {
        log.info("processing {}", requestParamWrapper);
        return super.process(requestParamWrapper);
    }
}
