package com.renatoganske.arquitetura_hexagonal.application.ports.out;

import com.renatoganske.arquitetura_hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
