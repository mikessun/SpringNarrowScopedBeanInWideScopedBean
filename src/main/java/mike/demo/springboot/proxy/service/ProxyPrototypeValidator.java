package mike.demo.springboot.proxy.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.service.impl.AbstractPrototypeValidatorImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Slf4j
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProxyPrototypeValidator extends AbstractPrototypeValidatorImpl {
    @Override
    public Errors validate(Object o) {
        log.info(" {} validating ", this);
        return super.validate(o);
    }
}
