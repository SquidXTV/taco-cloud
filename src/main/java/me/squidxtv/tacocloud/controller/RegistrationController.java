package me.squidxtv.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import me.squidxtv.tacocloud.data.UserRepository;
import me.squidxtv.tacocloud.model.RegistrationForm;
import me.squidxtv.tacocloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String view() {
        return "registration";
    }

    @ModelAttribute
    public RegistrationForm registrationForm() {
        return new RegistrationForm();
    }

    @PostMapping
    public String processRegistration(@Valid RegistrationForm registrationForm, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }

        User save = userRepository.save(registrationForm.toUser(passwordEncoder));
        log.info(save.toString());

        return "redirect:/login";
    }

}
