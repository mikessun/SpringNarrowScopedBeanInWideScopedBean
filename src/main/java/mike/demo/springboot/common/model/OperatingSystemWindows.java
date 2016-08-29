package mike.demo.springboot.common.model;

import mike.demo.springboot.common.service.abstraction.OperatingSystem;
import mike.demo.springboot.common.annotation.OperatingSystemQualifier;

import javax.inject.Named;

@Named
@OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Windows)
public class OperatingSystemWindows implements OperatingSystem {
    @Override
    public String getOperatingSystemKernel() {
        return "x86";
    }
}
