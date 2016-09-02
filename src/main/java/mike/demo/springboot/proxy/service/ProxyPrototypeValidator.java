package mike.demo.springboot.proxy.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.common.annotation.PrototypeImplType;
import mike.demo.springboot.common.annotation.PrototypeQualifier;
import mike.demo.springboot.common.service.impl.AbstractPrototypeValidator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.Calendar;
import java.util.Random;

@Slf4j
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PrototypeQualifier(PrototypeImplType.PROXY)
public class ProxyPrototypeValidator extends AbstractPrototypeValidator {
    private long randomNumber;

    public ProxyPrototypeValidator() {
        randomNumber = Calendar.getInstance().getTimeInMillis();
    }

    @Override
    public Errors validate(Object o) {
        log.info(" {} validating ", this);
        return super.validate(o);
    }

    @Override
    public long getRandomNumber() {
        return randomNumber;
    }
}
