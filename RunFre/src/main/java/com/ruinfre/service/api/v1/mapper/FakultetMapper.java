package com.ruinfre.service.api.v1.mapper;


import com.ruinfre.service.api.v1.model.FakultetDTO;
import com.ruinfre.service.domain.Fakultet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FakultetMapper {

    FakultetMapper instance = Mappers.getMapper(FakultetMapper.class);

    FakultetDTO fakultettoFakultetDto(Fakultet fakultet);
    

}