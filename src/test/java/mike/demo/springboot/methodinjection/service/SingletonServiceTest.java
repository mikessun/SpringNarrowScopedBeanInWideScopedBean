package mike.demo.springboot.methodinjection.service;

import mike.demo.springboot.SpringBootNarrowScopedInWideScopedBeanDemoApplication;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.SingletonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SingletonServiceTest {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    private SingletonService singletonService;

    @Before
    public void before() {
        this.context.register(SpringBootNarrowScopedInWideScopedBeanDemoApplication.class);
        this.context.refresh();
        singletonService = (SingletonService) this.context.getBean("method.injection.single.service");
    }

    @Test
    public void testProcess() throws Exception {
        RequestParamWrapper requestParamWrapper = new RequestParamWrapper("mike", 33);
        int process = singletonService.process(requestParamWrapper);

        assertThat(process, comparesEqualTo(1));
    }

}