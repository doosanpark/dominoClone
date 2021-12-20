package unic.domino.pizza.clone.server.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unic.domino.pizza.clone.server.security.service.MemberService;
import unic.domino.pizza.clone.server.security.vo.MemberVO;

@Controller
@RequestMapping(value = "/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String homeView() {
    	System.out.println("homeView");
        return "pages/home";
    }

    @GetMapping("/login")
    public String loginView() {
    	System.out.println("login");
        return "pages/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberVO memberVO) {
        memberService.save(memberVO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "pages/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "pages/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "pages/denied";
    }
}