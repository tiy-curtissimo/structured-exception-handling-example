package com.theironyard.seattle.seh.controllers;

import java.util.EmptyStackException;
import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ExceptionHandlingExampleController {

	private Stack<String> happyMessages;
	
	public ExceptionHandlingExampleController() {
		happyMessages = new Stack<String>();
		happyMessages.push("You're not dead.");
		happyMessages.push("The eclipse didn't blind you.");
		happyMessages.push("At least you have opposable thumbs.");
		happyMessages.push("Potato!");
	}
	
	@GetMapping("")
	public String showDefaultPage() {
		return "default";
	}
	
	@PostMapping("")
	public ModelAndView showHappyMessage() /*throws MyDogIsRabidException*/ {
		ModelAndView mv = new ModelAndView("default");
		
		try {
			String message = happyMessages.pop();
			mv.addObject("message", message);
		} catch(EmptyStackException ese) {
			mv.addObject("message", "you have no more happy messages. all is dire.");
		} catch (Exception e) { // THIS IS BAD AND DUMB
			// Only catch exceptions that you should handle
			// Let your application fail for exceptional reasons
			mv.addObject("message", "WTF?!?!?");
		} finally {
			mv.addObject("always", "I am always watching you.");
		}
		
//		throw new MyDogIsRabidException("Fido");
		
		return mv;
	}

}



















