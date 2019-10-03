package az.pashabank.ls.mscustomer.mappers;

import az.pashabank.ls.mscustomer.dao.AccountRepository;
import az.pashabank.ls.mscustomer.dao.entity.AccountEntity;
import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AccountMapper {

    public static final AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    public abstract AccountEntity mapDtoToEntity(AccountRequest accountRequest);

    public abstract AccountDto mapEntityToDto(AccountEntity accountEntity);

    public abstract List<AccountDto> mapEntityListToDtoList(List<AccountEntity> accountDtoList);

    public abstract List<AccountEntity> mapDtoListToEntityList(List<AccountRequest> accountRequestList);
}
