package me.squidxtv.tacocloud.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

public class RegistrationForm {

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String username = "";

    @NotNull
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String password = "";

    @NotNull
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String confirm = "";

    @NotNull
    @NotBlank(message = "Phone number must not be blank.")
    private String phone = "";

    @NotNull
    @Valid
    private DeliveryAddress address;

    @AssertTrue(message = "Passwords don't match.")
    public boolean isPasswordMatch() {
        return password.equals(confirm);
    }

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password), phone, address);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DeliveryAddress getAddress() {
        return address;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationForm that = (RegistrationForm) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(confirm, that.confirm) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(username);
        result = 31 * result + Objects.hashCode(password);
        result = 31 * result + Objects.hashCode(confirm);
        result = 31 * result + Objects.hashCode(phone);
        result = 31 * result + Objects.hashCode(address);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

}
