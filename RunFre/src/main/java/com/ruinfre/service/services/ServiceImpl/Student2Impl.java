package com.ruinfre.service.services.ServiceImpl;

import com.ruinfre.service.api.v1.mapper.StudentMapper;
import com.ruinfre.service.domain.Student;
import com.ruinfre.service.domain.Uplata;
import com.ruinfre.service.repositories.StudentRepository;
import com.ruinfre.service.services.StudentService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student2Impl implements StudentService2 {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public Student2Impl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Integer avgSumaUplata(Long id) {
        int sum = 0;
        Optional<Student> student = studentRepository.findById(id);
        List<Uplata> uplata = student.get().getUplateStudenta();
        for(int i=0;i < uplata.size(); i++){
            sum += uplata.indexOf(i);
        }
        return sum;
    }
}
