package eu.ensup.gestionscolairespringboot.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import eu.ensup.gestionscolairespringboot.dao.UserRepository;
import eu.ensup.gestionscolairespringboot.domaine.User;
import eu.ensup.gestionscolairespringboot.service.RegistrationForm;

@Controller
//@RequestMapping("/register")
public class RegistrationController {

	private UserRepository userRepo;
	  private PasswordEncoder passwordEncoder;

	  public RegistrationController(
	    UserRepository userRepo, PasswordEncoder passwordEncoder) {
	    this.userRepo = userRepo;
	    this.passwordEncoder = passwordEncoder;
	  }
	  
	  @GetMapping("/register")
	  public String registerForm() {
	    return "registration";
	  }
	  
	  @PostMapping("/registerOK")
	  public String processRegistration(RegistrationForm form) {
		System.out.println("methode post dans /register");
		User user = userRepo.save(form.toUser(passwordEncoder));
		System.out.println(user.getUsername());
	    return "redirect:/getFormLogin";
	  }
	
}
