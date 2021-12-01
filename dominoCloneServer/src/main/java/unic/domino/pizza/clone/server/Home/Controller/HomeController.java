package unic.domino.pizza.clone.server.Home.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String helloWorldHome() {
		
		return "/index";	//  /templates/Hello.html
	}
}
