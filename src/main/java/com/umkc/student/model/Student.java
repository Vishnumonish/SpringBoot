package com.umkc.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    private long id;
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", id=" + id +
                '}';
    }




}
