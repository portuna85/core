package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 빈_이름으로_조회() throws Exception {

        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // when
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        // then

    }

    @Test
    void 이름없이_타입으로_조회() throws Exception {
        // given
        MemberService memberService = ac.getBean(MemberService.class);

        // when
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        // then

    }

    @Test
    void 구체_타입으로_조회() throws Exception {
        // given
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);

        // when
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        // then

    }

    @Test
    void 빈_이름으로_조회2() throws Exception {
        // given

        // when
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("XXX", MemberService.class));

        // then

    }

}
