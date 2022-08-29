package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextExtendsFIndTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void 부모타입조회시_중복오류발생() throws Exception {

        // given

        // when
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));

        // then

    }

    @Test
    void 부모타입조회시_빈이름지정() throws Exception {

        // given
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);

        // when


        // then

    }

    @Test
    void 특정_하위타입으로조회() throws Exception {

        // given
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);

        // when


        // then

    }

    @Test
    void 부모타입으로_모두조회() throws Exception {
        // given
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        // when
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " values = " + beansOfType.get(key));
        }


        // then

    }

    @Test
    void 부모타입으로_모두_조회() throws Exception {
        // given
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        // when
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " values = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();

        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }
}
