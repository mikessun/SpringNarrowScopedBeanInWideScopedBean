package mike.demo.springboot.common.service.impl;

import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.PrototypeValidator;
import org.springframework.util.Assert;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractPrototypeValidator implements PrototypeValidator {
    public static final String NAME = "name";
    public static final String AGE = "age";

    @Override
    public Errors validate(Object o) {
        Assert.isAssignable(o.getClass(), RequestParamWrapper.class);
        Errors errors = new DirectFieldBindingResult(o, NAME);

        ValidationUtils.rejectIfEmpty(errors, NAME, "name.empty");
        RequestParamWrapper requestParamWrapper = (RequestParamWrapper) o;
        if (requestParamWrapper.getAge() < 0) {
            errors.rejectValue("age", "negativevalue");
        } else if (requestParamWrapper.getAge() % 2 == 0) {
            errors.rejectValue("age", "too.darn.old");
        }

        return errors;
    }
}
