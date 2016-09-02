package mike.demo.springboot.common.service.abstraction;

import org.springframework.validation.Errors;

public interface PrototypeValidator {
    public Errors validate(Object o);

    public long getRandomNumber();
}
