package mike.demo.springboot.common.model;

import mike.demo.springboot.common.service.abstraction.OperatingSystem;
import mike.demo.springboot.common.annotation.OperatingSystemQualifier;

import javax.inject.Named;

@Named
@OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Linux)
public class OperatingSystemLinux implements OperatingSystem {
    @Override
    public String getOperatingSystemKernel() {
        return "Linux Kernel 3.10";
    }
}
