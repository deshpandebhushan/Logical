package com.logical.login.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class loginController {

	
@GetMapping("/getToken/{id}")
public void generateCToken(@PathVariable String id) throws IOException  {
	System.out.println("C Token Creation invoked"+ id);
	throw new IOException("File Not Found");
}
	
}
