package com.ruinfre.service.api.v1.mapper;


import com.ruinfre.service.api.v1.model.StudentDTO;
import com.ruinfre.service.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper instance = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "firstName", target = "FName")
    @Mapping(source = "lastName", target = "LName")
    StudentDTO studenttoStudentDto(Student student);


    @Mapping(source = "FName", target = "firstName")
    @Mapping(source = "LName", target = "lastName")
    Student StudentDtoToStudent(StudentDTO studentDTO);


}