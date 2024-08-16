package com.renatoganske.arquitetura_hexagonal.application.ports.in;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
