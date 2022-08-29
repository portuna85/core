package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class SingletonTest {
    @Test
    void 스프링없는순수한DI컨테이너() throws Exception {
        // given
        AppConfig appConfig = new AppConfig();

        // when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // then
        log.info("memberService1 = {}", memberService1);
        log.info("memberService2 = {}", memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void 싱글톤_패턴_적용() throws Exception {
        // given
        SingletonService service1 = SingletonService.getInstance();
        SingletonService service2 = SingletonService.getInstance();

        // when
        log.info("service1 = {}" , service1);
        log.info("service2 = {}" , service2);

        // then
        assertThat(service1).isSameAs(service2);
    }

    @Test
    void 스프링_컨테이너와_싱글톤() throws Exception {
        // given
        // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        // when
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        // then
        log.info("memberService1 = {}", memberService1);
        log.info("memberService2 = {}", memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
