package com.theplayer.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.converter.UserConverter;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.ERole;
import com.theplayer.entity.RoleEntity;
import com.theplayer.repository.AccountRepository;
import com.theplayer.repository.RoleRepository;
import com.theplayer.request.LoginRequest;
import com.theplayer.request.SignupRequest;
import com.theplayer.response.JwtResponse;
import com.theplayer.response.MessageResponse;
import com.theplayer.security.jwt.JwtUtils;
import com.theplayer.security.services.UserDetailsImpl;
import com.theplayer.service.impl.AccountService;
import com.theplayer.service.impl.UserService;

@CrossOrigin(origins = "http://localhost:8085/login", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private UserConverter userConverter;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		if(accountService.findOneByUsername(loginRequest.getUsername()).getActive()==true){
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, 
													userDetails.getId(), 
													userDetails.getUsername(), 
													roles));
		}else{
			return ResponseEntity.badRequest().body(new MessageResponse("Error: username bi cam"));
		}
		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		AccountEntity accountEntity = new AccountEntity(signUpRequest.getUsername(), 
							 encoder.encode(signUpRequest.getPassword()));
		accountEntity.setActive(true);

		Set<String> strRoles = signUpRequest.getRole();
		Set<RoleEntity> roles = new HashSet<>();

		if (strRoles == null) {
			RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					RoleEntity modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		accountEntity.setRoles(roles);
		accountRepository.save(accountEntity);
		Long idaccount = accountService.findIdAccountByUserName(signUpRequest.getUsername());
    	if(userService.findIdUserByIdAccount(idaccount) != null) {
    		signUpRequest.setId(userService.findIdUserByIdAccount(idaccount));
    	}
    	userService.save(userConverter.requestToEntity(signUpRequest));
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PostMapping(value="/active")
	@ResponseBody
    public String getChangeActive(@RequestParam (value="username") String username, @RequestParam(value="active")  Boolean active) {
    	try {
    		AccountEntity accountEntity = accountService.findOneByUsername(username);
        	accountEntity.setActive(active);
        	accountService.save(accountEntity);
        	return "User successfully updated!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error updating the user: " + e.toString();
		}
    }
}
