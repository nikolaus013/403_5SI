package com.ruinfre.service.services;

import com.ruinfre.service.api.v1.model.StudentDTO;
import com.ruinfre.service.domain.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO createNewStudent(StudentDTO studentDTO);
    Boolean deleteStudent(Long id);
    StudentDTO saveStudent(Long id,StudentDTO studentDTO);

}
