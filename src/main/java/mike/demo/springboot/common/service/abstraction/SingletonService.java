package mike.demo.springboot.common.service.abstraction;

import mike.demo.springboot.common.model.RequestParamWrapper;

public interface SingletonService {
    public int process(RequestParamWrapper requestParamWrapper);

    public PrototypeValidator getPrototypeValidator();

    public long getRandomNumber();
}
