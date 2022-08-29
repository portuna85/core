package hello.core.beandefinition;

import hello.core.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    void 빈_설정_메타정보확인() throws Exception {

        // given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                log.info("beanDefinitionName = {},beanDefinition = {}", beanDefinitionName, beanDefinition);
            }
        }
    }
}
