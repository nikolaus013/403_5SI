package com.ruinfre.service.services.ServiceImpl;

import com.ruinfre.service.api.v1.mapper.StudentMapper;
import com.ruinfre.service.domain.Ocena;
import com.ruinfre.service.domain.Student;
import com.ruinfre.service.repositories.StudentRepository;
import com.ruinfre.service.services.StudentService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student1Impl implements StudentService1 {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public Student1Impl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public Double calcAvgGrade(Long id) {
        int sum = 0;
        int br = 0;
        Optional<Student> student = studentRepository.findById(id);
        List<Ocena> ocena = student.get().getOceneStudenta();

        for(int i=0;i < ocena.size(); i++){

            //  sum = ocena.get(ocena.indexOf(i)) + sum;
            sum += ocena.indexOf(i);
            br++;
        }
        Double  rez= Double.valueOf(sum/br);
        return rez;

    }
}
