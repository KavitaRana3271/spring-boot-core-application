/**
 * 
 */
package com.nttdata.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 319866
 *
 */
@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String hello() {
		return "Hello World from Kavita!";
	}
}
