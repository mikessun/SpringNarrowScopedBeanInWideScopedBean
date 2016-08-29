package mike.demo.springboot.methodinjection.service;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.methodinjection.SpringBootNarrowScopedInWideScopedBeanDemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@Slf4j
public class OperatingSystemServiceTest {
    private OperatingSystemService operatingSystemService;
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Before
    public void before() {
        this.context.register(SpringBootNarrowScopedInWideScopedBeanDemoApplication.class);
        this.context.refresh();
        operatingSystemService = this.context.getBean(OperatingSystemService.class);
    }

    @After
    public void closeContext() {
        this.context.close();
    }

    @Test
    public void testProcessOperatingSystemWin() throws Exception {
        log.info("INFO called");
        log.debug("DEBUG called");
        log.warn("WARN called");
        assertThat(operatingSystemService.processOperatingSystem(), not(containsString("x86")));
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testLoadedCustomLogbackConfig() throws Exception {
        SpringBootNarrowScopedInWideScopedBeanDemoApplication.main(new String[0]);
        this.outputCapture.expect(not(containsString(SpringBootNarrowScopedInWideScopedBeanDemoApplication.DEFAULT_NAME)));
    }
}