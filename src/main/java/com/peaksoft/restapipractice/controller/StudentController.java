package com.peaksoft.restapipractice.controller;

import com.peaksoft.restapipractice.dto.student.StudentRequest;
import com.peaksoft.restapipractice.dto.student.StudentResponse;
import com.peaksoft.restapipractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentResponse> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/getAllByGroupId/{id}")
    public List<StudentResponse> getAllStudents(@PathVariable Long groupId) {
        return studentService.getAllStudents(groupId);
    }

    @PostMapping("/save/{id}")
    public StudentResponse saveStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.addStudent(id, studentRequest);

    }

    @GetMapping("/findById/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return studentService.getStudentById(id);

    }

    @DeleteMapping("/deleteById/{id}")
    public StudentResponse deleteById(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable Long id) throws IOException {
        return studentService.updateStudent(studentRequest, id);
    }
    @PostMapping("/assignStudent/{studentId}/{groupId}")
    public void assignStudent(@PathVariable("studentId") Long studentId, @PathVariable("groupId")Long groupId) throws  IOException {
        studentService.assignStudent(groupId, studentId);
    }
}
