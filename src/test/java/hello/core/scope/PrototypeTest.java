package hello.core.scope;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class PrototypeTest {

    @Test
    void prototypeBeanFind() throws Exception {

        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        log.info("find prototypeBean1 = {}");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        log.info("find prototypeBean1 = {}");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        log.info("prototypeBean1 = {}", prototypeBean1);
        log.info("prototypeBean2 = {}", prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
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
