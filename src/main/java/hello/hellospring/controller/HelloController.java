package hello.hellospring.controller;


import io.micrometer.observation.transport.Propagator;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody   // http의 바디부에 return의 data를 직접 넣겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체형식으로 전달시 Json형태로 알아서 변환 후 전달
    }
    static class Hello {
        private String name;

        // Getter and Setter 단축키 Alt + Insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
