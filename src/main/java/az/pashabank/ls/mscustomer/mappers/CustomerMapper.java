package az.pashabank.ls.mscustomer.mappers;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Named("mapCustomerDtoToEntity")
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
    })
    public abstract CustomerEntity mapDtoToEntity(CustomerRequest customerRequest);


    @Named("mapCustomerEntityToDto")
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "surname", source = "surname"),
            @Mapping(target = "accountDtoSet", source = "accountEntitySet", qualifiedByName = "mapAccountEntitySetToDtoSet")
    })
    public abstract CustomerDto mapEntityToDto(CustomerEntity customerEntity);

    @Named("mapCustomerEntityListToDtoList")
    public abstract List<CustomerDto> mapEntityListToDtoList(List<CustomerEntity> customerEntityList);

    @Named("mapCustomerRequestListToEntityList")
    public abstract List<CustomerEntity> mapDtoListToEntityList(List<CustomerRequest> customerDtoList);
}
