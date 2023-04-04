package com.example.amigoscode.StudentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) throws IllegalAccessException {
        Optional<StudentModel> studentOptional = studentRepository.findStudentModelByEmail(studentModel.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalAccessException("email taken");
        }
        studentRepository.save(studentModel);

    }

    public void deleteStudent(Long studentId) {
        Optional<StudentModel> exists = studentRepository.findById(studentId);
        if (exists.isPresent()) {
            studentRepository.deleteById(studentId);
        } else
            throw new IllegalStateException("student with id " + studentId + " does not exists");

    }
}
