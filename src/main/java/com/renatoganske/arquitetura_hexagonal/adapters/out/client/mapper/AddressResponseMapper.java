package com.renatoganske.arquitetura_hexagonal.adapters.out.client.mapper;

import com.renatoganske.arquitetura_hexagonal.adapters.out.client.response.AddressResponse;
import com.renatoganske.arquitetura_hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
