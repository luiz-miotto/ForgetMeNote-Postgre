package dnd.mlogger.web;

import dnd.mlogger.Role;
import dnd.mlogger.User;
import dnd.mlogger.repositories.RoleRepo;
import dnd.mlogger.repositories.RoleRepository;
import dnd.mlogger.repositories.UserRepository;
import dnd.mlogger.security.ERole;
import dnd.mlogger.security.RegistrationForm;
import dnd.mlogger.security.payload.MessageResponse;
import dnd.mlogger.security.payload.SignupRequest;
import dnd.mlogger.security.services.Post;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/registration")
public class SignUpController {

    private Post post;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private AuthController authController;

    public SignUpController(){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.post = new Post();
    }
    @GetMapping
    public String registerForm(){
        return "registration";
    }


    @ModelAttribute
    public RegistrationForm registrationForm(){
        return new RegistrationForm();
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        post.signUp(form);
        System.out.println("Testing that this worked");
        return "redirect:/personlist";

    }
    /*
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


     */
}
