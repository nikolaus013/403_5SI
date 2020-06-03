package com.ruinfre.service.api.v1.mapper;


import com.ruinfre.service.api.v1.model.SmerDTO;
import com.ruinfre.service.domain.Smer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmerMapper {

    SmerMapper instance = Mappers.getMapper(SmerMapper.class);

    SmerDTO smertoSmerDto(Smer smer);

}