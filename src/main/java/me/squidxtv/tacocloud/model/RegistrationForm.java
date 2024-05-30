package me.squidxtv.tacocloud.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String username;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String password = "";

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String confirm = "";

    // ToDo: proper validation
    @NotBlank(message = "Phone number must not be blank.")
    private String phone;

    @Valid
    private DeliveryAddress address;

    @AssertTrue(message = "Passwords don't match.")
    public boolean isPasswordMatch() {
        return password.equals(confirm);
    }

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password), phone, address);
    }
}
