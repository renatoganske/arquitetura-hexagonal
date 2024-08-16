package com.renatoganske.arquitetura_hexagonal.application.ports.out;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
