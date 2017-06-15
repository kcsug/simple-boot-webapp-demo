package org.bromley.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	private WebService service;
	
	public WebController(WebService service){
		this.service = service;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/libraries")
	public ModelAndView libraries(){
		ModelAndView mav = new ModelAndView("libraries");
		mav.addObject("libraries", service.getJavaScriptLibraries().getResults());
		return mav;
	}
	
	@GetMapping("/libraries/{name}")
	public ModelAndView library(@PathVariable String name){
		ModelAndView mav = new ModelAndView("library");
		mav.addObject("library", service.getJavaScriptLibrary(name));
		return mav;
	}

}
