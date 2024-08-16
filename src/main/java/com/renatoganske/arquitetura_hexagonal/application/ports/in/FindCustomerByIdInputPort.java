package com.renatoganske.arquitetura_hexagonal.application.ports.in;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
