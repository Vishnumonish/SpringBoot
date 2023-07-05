package com.umkc.student.repository;

import com.umkc.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> getAllById(Long id);
}
