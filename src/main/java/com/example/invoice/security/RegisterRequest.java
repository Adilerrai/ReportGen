package com.example.invoice.security;

import com.example.invoice.annotation.StrongPassword;
import com.example.invoice.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {

    @NotBlank(message = "firstname is required")
    private String firstname;
    @NotBlank(message = "lastname is required")
    private String lastname;
    @NotBlank(message = "email is required")
    @Email(message = "email format is not valid")
    private String email;
    @NotBlank(message = "password is required")
    @StrongPassword
    private String password;
    @NotNull
    private Role role;


    public @NotBlank(message = "firstname is required") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "firstname is required") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "email is required") @Email(message = "email format is not valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is required") @Email(message = "email format is not valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "lastname is required") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "lastname is required") String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank(message = "password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password is required") String password) {
        this.password = password;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Role role;

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public RegisterRequest build() {
            RegisterRequest request = new RegisterRequest();
            request.firstname = this.firstname;
            request.lastname = this.lastname;
            request.email = this.email;
            request.password = this.password;
            request.role = this.role;
            return request;
        }
    }
}
