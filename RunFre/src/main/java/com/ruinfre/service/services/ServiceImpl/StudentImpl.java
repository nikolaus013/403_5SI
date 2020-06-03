package com.ruinfre.service.services.ServiceImpl;

import com.ruinfre.service.api.v1.mapper.StudentMapper;
import com.ruinfre.service.api.v1.model.StudentDTO;
import com.ruinfre.service.domain.Ocena;
import com.ruinfre.service.domain.Student;
import com.ruinfre.service.domain.Uplata;
import com.ruinfre.service.repositories.StudentRepository;
import com.ruinfre.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Autowired
    public StudentImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::studenttoStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student inRepository = studentRepository.getOne(id);

        if (inRepository == null)
            return null;

        StudentDTO toReturn = studentMapper.studenttoStudentDto(inRepository);
        return toReturn;
    }


    @Override
    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        return saveAndReturnDTO(studentMapper.StudentDtoToStudent(studentDTO));
    }

    @Override
    public Boolean deleteStudent(Long id) {
        Optional<Student> toDelete = studentRepository.findById(id);


        if(!toDelete.isPresent())
            return false;

        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public StudentDTO saveStudent(Long id, StudentDTO studentDTO)
    {
        Student studentToSave = studentMapper.StudentDtoToStudent(studentDTO);
        studentToSave.setId(id);
        return saveAndReturnDTO(studentToSave);
    }



    private StudentDTO saveAndReturnDTO(Student student){

        studentRepository.save(student);
        StudentDTO toReturn = studentMapper.studenttoStudentDto(student);
        return toReturn;

    }
}
