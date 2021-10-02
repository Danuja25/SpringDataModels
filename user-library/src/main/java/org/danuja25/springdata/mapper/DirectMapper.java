package org.danuja25.springdata.mapper;

public interface DirectMapper<DTO,DAO> {

    DTO daoToDto(DAO object);
    DAO dtoToDao(DTO object);

}
