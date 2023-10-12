package com.search;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Search {

	@RequestMapping("/home")
	public String home() {
		int t = (42/0);
		return "home";
	}
	
	@RequestMapping("search")
	public RedirectView findQuery(@RequestParam("query") String find) {
		
		RedirectView view = new RedirectView();
		if(find.isBlank()) {
			view.setUrl("home");
			return view;
		}
		view.setUrl("https://www.google.com/search?q="+find);
		return view;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandle() {
		return "error";
	}
	
}
