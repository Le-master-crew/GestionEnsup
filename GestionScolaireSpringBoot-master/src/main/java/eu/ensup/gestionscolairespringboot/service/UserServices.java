package eu.ensup.gestionscolairespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eu.ensup.gestionscolairespringboot.dao.UserRepository;
import eu.ensup.gestionscolairespringboot.domaine.User;

@Service
public class UserServices implements UserDetailsService {

	private UserRepository userRepo;

	@Autowired
	public UserServices(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");

	}

}
