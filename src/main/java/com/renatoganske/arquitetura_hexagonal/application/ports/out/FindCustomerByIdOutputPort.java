package com.renatoganske.arquitetura_hexagonal.application.ports.out;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
