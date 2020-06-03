package com.ruinfre.service.controllers;

import com.ruinfre.service.api.v1.model.StudentDTO;
import com.ruinfre.service.domain.Mail;
import com.ruinfre.service.services.MailService;
import com.ruinfre.service.services.StudentService;
import com.ruinfre.service.services.StudentService1;
import com.ruinfre.service.services.StudentService2;
import com.ruinfre.service.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(Constants.STUDENT_BASE_URL)
public class StudentController {

    private final StudentService studentService;
    private final StudentService1 studentService1;
    private final StudentService2 studentService2;
    private final MailService mailService;

    @Autowired
    public StudentController(StudentService studentService, StudentService1 studentService1, StudentService2 studentService2, MailService mailService) {
        this.studentService = studentService;
        this.studentService1 = studentService1;
        this.studentService2 = studentService2;
        this.mailService = mailService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> getAll() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);

    }



    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<StudentDTO> getOneById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
    public ResponseEntity<Boolean> deleteOneById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.createNewStudent(studentDTO), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "save/{id}")
    public ResponseEntity<StudentDTO> saveStudent (@PathVariable Long id, @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.saveStudent(id, studentDTO), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "sum/{id}")
    public ResponseEntity<Integer> avgSumaUplata(@PathVariable Long id){
        return new ResponseEntity<>(studentService2.avgSumaUplata(id), HttpStatus.OK);
    }
    @RequestMapping(method = {RequestMethod.GET}, value = "avg/{id}")
    public ResponseEntity<Double> calcAvgGrade(@PathVariable Long id){
        return new ResponseEntity<>(studentService1.calcAvgGrade(id),HttpStatus.OK);
    }


    @RequestMapping("/sendEmail")
    public  String  sendMail(@PathVariable Mail mail)
    {
        mailService.sendEmail(mail);
        return "Poslat mejl";

    }



}
