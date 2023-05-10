package com.xsakon.travelproject.registration;

import com.xsakon.travelproject.customer.CustomerService;
import com.xsakon.travelproject.email.EmailSender;
import com.xsakon.travelproject.exception.EmailAlreadyConfirmedException;
import com.xsakon.travelproject.exception.RequestValidationException;
import com.xsakon.travelproject.exception.ResourceNotFoundException;
import com.xsakon.travelproject.exception.TokenExpiredException;
import com.xsakon.travelproject.registration.token.ConfirmationToken;
import com.xsakon.travelproject.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final CustomerService customerService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest request) {
        if(!emailValidator.test(request.email())){
            throw new RequestValidationException("email \"%s\" not valid".formatted(request.email()));
        }

        String token = customerService.signUpCustomer(request);
        String link = "http://localhost:8090/api/v1/registration/confirm?token=" + token;
        emailSender.send(request.email(), emailSender.buildEmail(request.firstName(), link));

        return token;
    }

    public void sendEmailAgain(RegistrationRequest request){
        String token = customerService.signUpCustomer(request);
        String link = "http://localhost:8090/api/v1/registration/confirm?token=" + token;
        emailSender.send(request.email(), emailSender.buildEmail(request.firstName(), link));
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new EmailAlreadyConfirmedException("email already confirmed");
        }

        LocalDateTime expiresAt = confirmationToken.getExpiresAt();
        if (expiresAt.isBefore(LocalDateTime.now())){
            throw new TokenExpiredException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        customerService.enableCustomer(confirmationToken.getCustomer().getEmail());

        return "confirmed";
    }

}
