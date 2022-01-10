package unic.domino.pizza.clone.server.security.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOG = LogManager.getLogger(MemberController.class);
    
    @GetMapping("/")
    public String homeView() {
        return "pages/home";
    }
    
    @RequestMapping(value = "/checkaccnt")
    public @ResponseBody HashMap<String, Object> checkAccnt(@RequestParam HashMap<String, Object> paramMap, ModelMap model, 
    		HttpServletRequest request, HttpServletResponse response ) throws Exception{
    	LOG.debug("checkAccnt");							//Log.debug 표시 안됨
    	LOG.debug("paramMap : " + paramMap.toString());		//Log.debug 표시 안됨
    	HttpSession session = request.getSession();
    	HashMap<String, Object> user = memberService.loadUserByUsername((String)paramMap.get("accnt"), (String)paramMap.get("pass"));
    	
//    	session.setAttribute("accnt", user.getUsername());
//    	session.setAttribute("auth", user.getAuthorities());
//    	request.setAttribute("accnt", user.getUsername());
//    	request.setAttribute("auth", user.getAuthorities());
//    	if(userDetails == null) {
//    	} else {
//    	}
    	
    	return user;
    }
    
    @GetMapping("/login")
    public @ResponseBody String loginView(HttpServletRequest request, HttpServletResponse response) {
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