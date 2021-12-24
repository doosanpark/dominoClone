package unic.domino.pizza.clone.server.security.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import unic.domino.pizza.clone.server.security.service.MemberService;
import unic.domino.pizza.clone.server.security.vo.MemberVO;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String homeView() {
        return "pages/home";
    }

    @RequestMapping(value = "/checkaccnt")
    public @ResponseBody Boolean checkAccnt(@RequestParam HashMap<String, Object> paramMap, ModelMap model, 
    		HttpServletRequest request, HttpServletResponse response ) throws Exception{
    	
    	System.out.println("paramMap ::::: " + paramMap);
    	System.out.println("model ::::: " + model);
		Boolean isLogined = memberService.loadUserByUsername((String)paramMap.get("accnt"), (String)paramMap.get("pass"));
		System.out.println("isLogined ::::: " + isLogined);
		
//    	if(userDetails == null) {
//    	} else {
//    	}
    	
    	return isLogined;
    }
    
    @GetMapping("/login")
    public String loginView() {
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