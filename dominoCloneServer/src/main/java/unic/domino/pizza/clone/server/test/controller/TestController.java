package unic.domino.pizza.clone.server.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import unic.domino.pizza.clone.server.test.service.TestService;
import unic.domino.pizza.clone.server.test.vo.TestVo;

@Controller
public class TestController{

	@Autowired 
	TestService testService; 

	@RequestMapping(value = "/test") 
	public ModelAndView test() throws Exception{ 
		ModelAndView mav = new ModelAndView("test"); 

		List<TestVo> testList = testService.selectTest(); 
		mav.addObject("list", testList); 
		
		System.out.println("testList.id :::::: " + testList.get(0).getId()+ 
				", testList.pass :::::: " + testList.get(0).getPass() + 
				", testList.id :::::: " + testList.get(1).getId()+ 
				", testList.pass :::::: " + testList.get(1).getPass());
		
		return mav; 
	}

}