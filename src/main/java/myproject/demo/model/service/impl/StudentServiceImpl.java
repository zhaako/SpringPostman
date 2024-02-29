package myproject.demo.model.service.impl;

import myproject.demo.model.Gender;
import myproject.demo.model.Student;
import myproject.demo.model.repo.GenderRepo;
import myproject.demo.model.repo.StudentRepository;
import myproject.demo.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GenderRepo genderRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudentDesc() {
        return studentRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Gender> getByGender(Long id) {
        return genderRepo.findById(id);
    }

    @Override
    public List<Gender> getAllGender() {
        return genderRepo.findAll();
    }

    @Override
    public Gender addGender(Gender gender) {
        return genderRepo.save(gender);
    }

    @Override
    public Gender saveGender(Gender gender) {
        return genderRepo.save(gender);
    }

    @Override
    public Gender getGender(Long id) {
        if (id != null) {
            return genderRepo.getOne(id);
        } else {
            return null;
        }
    }

    @Override
    public Gender findGenderById(long id) {
        return genderRepo.findById(id);
    }

}
