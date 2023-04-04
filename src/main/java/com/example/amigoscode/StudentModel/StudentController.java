package com.example.amigoscode.StudentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
//        this.studentService = new StudentService(); -- Devemos evitar coisas desse tipo e usar a injeção de dependecia. Por que?
    }

    @GetMapping
    public List<StudentModel> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentModel studentModel) throws IllegalAccessException {
        studentService.addNewStudent(studentModel);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
