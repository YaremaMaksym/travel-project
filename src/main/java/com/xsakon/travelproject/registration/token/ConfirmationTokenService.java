package com.xsakon.travelproject.registration.token;

import com.xsakon.travelproject.customer.CustomerService;
import com.xsakon.travelproject.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final CustomerService customerService;


    public Optional<ConfirmationToken> getToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token) {
        confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

    public String generateAndSaveTokenForCustomer(RegistrationRequest request) {
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                customerService.getCustomerByEmail(request.email())
        );

        confirmationTokenRepository.save(confirmationToken);

        return token;
    }
}
