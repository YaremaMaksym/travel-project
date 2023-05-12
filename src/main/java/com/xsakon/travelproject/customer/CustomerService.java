package com.xsakon.travelproject.customer;

import com.xsakon.travelproject.exception.DuplicateResourceException;
import com.xsakon.travelproject.exception.ResourceNotFoundException;
import com.xsakon.travelproject.registration.RegistrationRequest;
import com.xsakon.travelproject.registration.token.ConfirmationToken;
import com.xsakon.travelproject.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with email %s not found".formatted(email)
                ));
    }

    public String signUpCustomer(RegistrationRequest request) {
        if (customerRepository.existsByEmail(request.email())){
            throw new DuplicateResourceException(
                    "email %s already taken".formatted(request.email())
            );
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.password());

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(encodedPassword)
                .build();

        customerRepository.save(customer);

        return generateNewTokenForCustomer(customer);
    }

    public String generateNewTokenForCustomer(Customer customer) {

        ConfirmationToken confirmationToken = confirmationTokenService.createTokenForCustomer(customer);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return confirmationToken.getToken();
    }

    public int enableCustomer(String email) {
        return customerRepository.enableAppUser(email);
    }
}
