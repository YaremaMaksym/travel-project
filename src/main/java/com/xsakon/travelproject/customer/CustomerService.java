package com.xsakon.travelproject.customer;

import com.xsakon.travelproject.exception.DuplicateResourceException;
import com.xsakon.travelproject.exception.ResourceNotFoundException;
import com.xsakon.travelproject.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerDAO customerDAO;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return getCustomerByEmail(email);
    }

    public Customer getCustomerByEmail(String email){
        return customerDAO.selectCustomerByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with email %s not found".formatted(email)
                ));
    }

    public void signUpCustomer(RegistrationRequest request) {
        if (customerDAO.existsCustomerWithEmail(request.email())){
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

        customerDAO.insertCustomer(customer);
    }

    public int enableCustomer(String email) {
        return customerDAO.enableCustomerWithEmail(email);
    }
}
