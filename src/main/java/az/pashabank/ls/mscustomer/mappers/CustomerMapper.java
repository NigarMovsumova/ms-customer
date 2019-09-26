package az.pashabank.ls.mscustomer.mappers;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {


    public CustomerDto mapEntityToDto(CustomerEntity customerEntity) {
        return CustomerDto.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .surname(customerEntity.getSurname())
                .build();
    }

    public CustomerEntity mapDtoToEntity(CustomerRequest customerDto) {
        return CustomerEntity.builder()
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .build();
    }

    public List<CustomerDto> mapEntityListToDtoList(List<CustomerEntity> customerEntityList) {
        return customerEntityList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<CustomerEntity> mapDtoListToEntityList(List<CustomerRequest> customerDtoList) {
        return customerDtoList.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }
}
