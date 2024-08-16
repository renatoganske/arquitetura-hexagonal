package com.renatoganske.arquitetura_hexagonal.application.core.usecases;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;
import com.renatoganske.arquitetura_hexagonal.application.ports.in.InsertCustomerInputPort;
import com.renatoganske.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.renatoganske.arquitetura_hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAdressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAdressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
