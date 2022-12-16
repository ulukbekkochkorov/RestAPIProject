package com.peaksoft.restapipractice.service.impl;

import com.peaksoft.restapipractice.converter.student.StudentRequestConverter;
import com.peaksoft.restapipractice.converter.student.StudentResponseConverter;
import com.peaksoft.restapipractice.dto.student.StudentRequest;
import com.peaksoft.restapipractice.dto.student.StudentResponse;
import com.peaksoft.restapipractice.entity.Course;
import com.peaksoft.restapipractice.entity.Group;
import com.peaksoft.restapipractice.entity.Student;
import com.peaksoft.restapipractice.repository.GroupRepository;
import com.peaksoft.restapipractice.repository.StudentRepository;
import com.peaksoft.restapipractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private  final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;

    @Override
    public List<StudentResponse> getStudentList() {

        return studentResponseConverter.view(studentRepository.findAll());
    }

    @Override
    public List<StudentResponse> getAllStudents(Long groupId) {
        return studentResponseConverter.view(studentRepository.findAllStudentByGroupId(groupId));
    }

    @Override
    public StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException {
        List<Student> students = studentRepository.findAll();
        Student student = studentRequestConverter.createStudent(studentRequest);
        for (Student i : students) {
            if (i.getEmail().equals(student.getEmail())) {
                throw new IOException("Student with this email is already exists!");
            }
        }
        Group group = groupRepository.getById(id);
        group.addStudent(student);
        student.setGroup(group);

        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentResponseConverter.viewStudent(studentRepository.getById(id));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long id) {
        Student student1 = studentRepository.getById(id);
        studentRequestConverter.updateStudent(student1, studentRequest);
        studentRepository.save(student1);
        return studentResponseConverter.viewStudent(student1);

    }

    @Override
    public StudentResponse deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        for (Course c:student.getGroup().getCourses()) {
            c.getCompany().minusStudent();
        }
        studentRepository.delete(student);
        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public void assignStudent(Long groupId, Long studentId) throws IOException {
    Student student = studentRepository.getById(studentId);
    Group group = groupRepository.getById(groupId);
    if (group.getStudents()!=null){
        for (Student g: group.getStudents()) {
            if (g.getId() == studentId){
                throw new IOException("This student is already exists!");
            }
        }
    }
    student.getGroup().getStudents().remove(student);
    group.assignStudent(student);
    student.setGroup(group);
    studentRepository.save(student);
    groupRepository.save(group);
    }
}
