package mike.demo.springboot.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public class RequestParamWrapper {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;

    public String toString() {
        return name + "[" + age + "]";
    }
}
