package com.peaksoft.restapipractice.controller;

import com.peaksoft.restapipractice.dto.instructor.InstructorRequest;
import com.peaksoft.restapipractice.dto.instructor.InstructorResponse;
import com.peaksoft.restapipractice.service.InstructorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping ("/getAll")
    public List<InstructorResponse> listAllInstructors(){
        return instructorService.listAllInstructors();
    }
    @GetMapping("/getAllByCourseId/{courseId}")
    public List<InstructorResponse> getAllInstructors(@PathVariable Long courseId){
        return instructorService.getAllInstructors(courseId);
    }
    @PostMapping("/save/{id}")
    public InstructorResponse saveInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.addInstructor(id, instructorRequest);
    }
    @GetMapping("/findById/{id}")
    public InstructorResponse findById(@PathVariable Long id){
        return instructorService.getInstructorById(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public InstructorResponse deleteById(@PathVariable Long id){
       return instructorService.deleteInstructor(id);
    }
    @PutMapping("/update/{id}")
public InstructorResponse updateCourse(@RequestBody InstructorRequest instructorRequest,@PathVariable Long id) throws IOException {
        return instructorService.updateInstructor(instructorRequest, id);
    }
    @PostMapping("/assignInstructor/{instructorId}/{courseId}")
    public void assignInstructor(@PathVariable("instructorId")Long instructorId, @PathVariable("courseId") Long courseId) throws IOException{
        instructorService.assignInstructor(courseId, instructorId);
    }
}
