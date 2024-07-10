package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/main"})
    public String main() {
        return "main";
    }

    @GetMapping("string-redirect")
    public String stringRedirect() {

        // redirect: 접두사를 붙이면 forward가 아닌 redirect를 한다.
        System.out.println("리다이렉트 호출됨");

        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr) {

        /*
        * 리다이렉트 시 flash 영역에 담아서 redirect할 수 있다.
        * 자동으로 모델에 추가되기 때문에 requestScope에서 꺼내서 사용할 수 있다.
        *
        * 주의
        * 세션에 임시로 값을 담고 소멸하는 방식이기 때문에
        * session에 동일한 키 값이 존재하면 안된다.
         */

        rttr.addFlashAttribute("flashMessage1","리다이렉트 attr 사용하여 redirect....");
        return "redirect:/";
    }
}
