package mike.demo.springboot.methodinjection.service;

import mike.demo.springboot.SpringBootNarrowScopedInWideScopedBeanDemoApplication;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.SingletonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class MethodInjectionSingletonServiceTest {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    private SingletonService singletonService;

    @Before
    public void before() {
        this.context.register(SpringBootNarrowScopedInWideScopedBeanDemoApplication.class);
        this.context.refresh();
        //singletonService = (SingletonService) this.context.getBean(null);
    }

    @Test
    public void testProcess() throws Exception {
        RequestParamWrapper requestParamWrapper = new RequestParamWrapper("mike", 33);
        int process = singletonService.process(requestParamWrapper, );

        assertThat(process, comparesEqualTo(1));
    }

}