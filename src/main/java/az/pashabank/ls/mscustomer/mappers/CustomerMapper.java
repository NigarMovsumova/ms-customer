package az.pashabank.ls.mscustomer.mappers;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname")
    })
    public abstract CustomerEntity mapDtoToEntity(CustomerRequest customerRequest);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
    })
    public abstract CustomerDto mapEntityToDto(CustomerEntity customerEntity);

    public abstract List<CustomerDto> mapEntityListToDtoList(List<CustomerEntity> customerEntityList);

    public abstract List<CustomerEntity> mapDtoListToEntityList(List<CustomerRequest> customerDtoList);
}
