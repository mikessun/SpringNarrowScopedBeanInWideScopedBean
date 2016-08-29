package mike.demo.springboot.methodinjection.service;

import mike.demo.springboot.common.service.abstraction.OperatingSystem;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class OperatingSystemService {

    public String processOperatingSystem(){
        return getOperatingSystem().getOperatingSystemKernel();
    }

    @Lookup
    public OperatingSystem getOperatingSystem() {
        return null;
    }
}
