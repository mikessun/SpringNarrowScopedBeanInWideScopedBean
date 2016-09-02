package mike.demo.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringBootNarrowScopedInWideScopedBeanDemoApplication {
    public static final String DEFAULT_NAME = "DEFAULT_NAME";

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(SpringBootNarrowScopedInWideScopedBeanDemoApplication.class, args);
        /*TimerService bean = context.getBean(TimerService.class);

        bean.showMessage(DEFAULT_NAME);
        Thread.sleep(1000);

        log.info("info...");
        log.debug("debug...");

        bean = context.getBean(TimerService.class);
        bean.showMessage(DEFAULT_NAME);*/
    }
}


