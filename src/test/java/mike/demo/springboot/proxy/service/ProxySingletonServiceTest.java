package mike.demo.springboot.proxy.service;

import mike.demo.springboot.SpringBootNarrowScopedInWideScopedBeanDemoApplication;
import mike.demo.springboot.common.model.RequestParamWrapper;
import mike.demo.springboot.common.service.abstraction.SingletonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ProxySingletonServiceTest {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    private SingletonService singletonService;

    @Before
    public void before() {
        this.context.register(SpringBootNarrowScopedInWideScopedBeanDemoApplication.class);
        this.context.refresh();
        singletonService = (SingletonService) this.context.getBean(ProxySingletonService.class);
    }

    @Test
    public void testProcess() throws Exception {
        int process = 0;
        long currentNumber = 0;
        for (int i = 0; i < 10; i++) {
            RequestParamWrapper requestParamWrapper = new RequestParamWrapper("mike", 33 + i);
            process += singletonService.process(requestParamWrapper);

            // below indicating the random value created with a validator is not identical -> different beans
            assertThat(currentNumber, not(equalTo(singletonService.getRandomNumber())));
            currentNumber = singletonService.getRandomNumber();
        }

        assertThat(process, comparesEqualTo(5));
    }
}