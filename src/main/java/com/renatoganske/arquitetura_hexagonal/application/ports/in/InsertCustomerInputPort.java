package com.renatoganske.arquitetura_hexagonal.application.ports.in;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);


}
