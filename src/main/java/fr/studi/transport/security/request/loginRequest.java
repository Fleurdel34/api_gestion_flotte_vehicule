package fr.studi.transport.security.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class loginRequest {

    @NotBlank
    @Email
    private String username;

    @NotBlank
    private String password;
}
