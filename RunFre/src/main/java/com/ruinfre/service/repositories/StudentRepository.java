package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Fakultet;
import com.ruinfre.service.domain.Smer;
import com.ruinfre.service.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findAllByFakultet(Fakultet fakultet);
  //  Student findByFirstNameAndAndLastName(String firstName,String lastName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
 //   Student findByName(String name);
    Student findByIndex(Integer brIndexa);
    Student findBySmerStudenta (Smer smer);
    Student findByUsername(String username);




}
