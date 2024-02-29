package myproject.demo.model.service;

import myproject.demo.model.Gender;
import myproject.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Student getStudent(long id);
    void deleteStudent(Student student);
    Student saveStudent(Student student);
    List<Student> getAllStudentDesc();
    Optional<Gender> getByGender(Long id);

    List<Gender> getAllGender();
    Gender addGender(Gender gender);
    Gender saveGender(Gender gender);
    Gender getGender(Long id);
    Gender findGenderById(long id);
}
