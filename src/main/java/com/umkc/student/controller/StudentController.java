package com.umkc.student.controller;

import com.umkc.student.model.Student;
import com.umkc.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("API")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(@RequestParam(required = false) Long id) {
        List<Student> students = new ArrayList<Student>();
        studentRepo.findAll().forEach(students::add);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("students/id")
    public Optional<Student> getStudentsById(@RequestParam(required = false) Long id) {
        List<Student> students = new ArrayList<Student>();
        return studentRepo.findById(id);
    }

    @PostMapping("/newStudent")
    public void postStudents(@RequestBody Student student) {
        studentRepo.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> studentRec = studentRepo.findById(id);

        if (studentRec.isPresent()) {
            Student _student = studentRec.get();
            _student.setStudentName(student.getStudentName());
            _student.setId(student.getId());
            return new ResponseEntity<>(studentRepo.save(_student), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
@DeleteMapping("students/remove/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepo.deleteById(id);
    }
}
