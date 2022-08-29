package hello.core.singleton;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class StatefulServiceTest {

    @Test
    void statefulServiceSinglton() throws Exception {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // when
        statefulService1.order("userA", 100000);
        statefulService2.order("userB", 200000);

        // then
        int price = statefulService1.getPrice();
        log.info("price = {}", price);

        assertThat(statefulService1.getPrice()).isEqualTo(200000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
