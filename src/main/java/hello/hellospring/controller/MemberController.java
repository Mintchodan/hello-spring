package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    // 생성자에 Autowired해놓으면 MemberService를 스프링컨테이너에 있는것과 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
