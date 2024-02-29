package myproject.demo.controller;

import myproject.demo.model.Gender;
import myproject.demo.model.Student;
import myproject.demo.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping()
    public List<Student> getStudentDetails() {
        return studentService.getAllStudent();
    }

    @RequestMapping("/desc")
    public List<Student> getStudents(){
        return studentService.getAllStudentDesc();
    }

    @GetMapping("/g/{id}")
    public List<Student> getSomeStudent(@PathVariable(name ="id") long id){
        List<Student> students = studentService.getAllStudent();
        List<Student> s = new ArrayList<>();
        for(Student a : students){
            if(a.getGender().getId() == id){
                s.add(a);
            }
        }
        return s;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name ="id") long id) {
        for (Student student : studentService.getAllStudent()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name ="id") long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return "Error: Student with Id " + id + " not found";
        }
        studentService.deleteStudent(student);
        return "Student with Id " + id + " is deleted";
    }

    @PutMapping()
    public String updateStudent(@RequestBody Student studentDetails) {
        long id = studentDetails.getId();
        long genderId = studentDetails.getGender().getId();
        Gender g = studentService.getGender(genderId);
        Student student = studentService.getStudent(id);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAddress(studentDetails.getAddress());
            student.setDateOfBirth(studentDetails.getDateOfBirth());
            student.setGender(g);
            studentService.saveStudent(student);
        }
        else {
            return "Student with id " + student.getId() + " is not found.";
        }
        return  student.getId() + " updated successfully";
    }

    @PostMapping
    public String addStudent(@RequestBody Student studentRequest){
        Gender g = studentService.getGender(studentRequest.getGender().getId());
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAddress(studentRequest.getAddress());
        student.setGender(g);
        student.setDateOfBirth(studentRequest.getDateOfBirth());
        studentService.addStudent(student);
        return "Student added successfully " + student.getId();
    }
}