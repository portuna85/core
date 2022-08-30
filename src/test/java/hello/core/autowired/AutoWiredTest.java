package hello.core.autowired;

import hello.core.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Slf4j
public class AutoWiredTest {

    @Test
    void AutoWiredOption() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            log.info("noBean1 = {}", noBean1);
        }
    }

    @Autowired(required = false)
    public void setNoBean2(@Nullable Member noBean2) {
        log.info("noBean2 = {}", noBean2);
    }

    @Autowired
    public void setNoBean3(Optional<Member> noBean3) {
        log.info("noBean3 = {}", noBean3);
    }
}
