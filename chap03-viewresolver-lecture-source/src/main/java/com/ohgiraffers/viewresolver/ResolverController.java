package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 변환");

        /*
        * 문자열로 뷰 이름을 반환한다는 것은 반환 후
        * ThymeleafViewResolver에게 resources/templates/를 prefix로 지정하고
        * .html을 suffix로 하여
        * resources/templates/result.html 파일로 응답뷰로 설정하라는 의미
         */


        return "result";

    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mv){

        /*
        * ModelAndView
        * - 모델과 뷰를 합친 개념
        * - 핸들러 어뎁터가 핸들러 메소드를 호출하고 반환받은 문자열을 ModelAndView로 만들어
        *   DispatcherServlet에 반환한다.
        *   이때 문자열을 반환해도 되고, ModelAndView 객체를 만들어서 반환할 수도 있다.
        *
         */

        // 속성값 담기
        mv.addObject("forwardMessage","ModelAndView를 이용한 모델과 뷰 전환");

        // 뷰 이름 담기
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){

        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirectAttr(ModelAndView mv, RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage2","ModelAndView를 이용한 redirect attr");

        mv.setViewName("redirect:/");

        return mv;
    }


}
