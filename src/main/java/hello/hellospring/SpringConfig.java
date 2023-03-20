package hello.hellospring;

// 스프링 빈 직접 등록

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepsitory;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepsitory();
    }
}
