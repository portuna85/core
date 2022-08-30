package hello.core.scope;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class SingletonTest {

    @Test
    void 싱글톤_빈_범위() throws Exception {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);

        log.info("singletonBean1 = {}", bean1);
        log.info("singletonBean2 = {}", bean2);

        // when
        assertThat(bean1).isSameAs(bean2);
        ac.close();
        // then

    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            log.info("SingletonBean.init");

        }

        @PreDestroy
        public void destroy() {
            log.info("SingletonBean.destroy");
        }
    }
}
