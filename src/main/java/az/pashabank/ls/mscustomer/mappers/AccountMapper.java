package az.pashabank.ls.mscustomer.mappers;

import az.pashabank.ls.mscustomer.dao.entity.AccountEntity;
import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Named("mapAccountRequestToEntity")
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "balance", source = "balance"),
            @Mapping(target = "currency", source = "currency"),
    })
    public abstract AccountEntity mapDtoToEntity(AccountRequest accountRequest);

    @Named("mapAccountEntityToDto")
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "customerDto",
                    source = "customer",
                    qualifiedByName = "mapCustomerEntityToDto")
    })
    public abstract AccountDto mapEntityToDto(AccountEntity accountEntity);

    @Named("mapAccountEntityListToDtoList")
    public abstract List<AccountDto> mapEntityListToDtoList(List<AccountEntity> accountDtoList);

    @Named("mapAccountEntitySetToDtoSet")
    public abstract Set<AccountDto> mapEntitySetToDtoSet(Set<AccountEntity> accountEntityList);

    @Named("mapAccountDtoListToEntityList")
    public abstract List<AccountEntity> mapDtoListToEntityList(List<AccountRequest> accountRequestList);
}
