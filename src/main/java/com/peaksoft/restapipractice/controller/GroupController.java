package com.peaksoft.restapipractice.controller;

import com.peaksoft.restapipractice.dto.group.GroupRequest;
import com.peaksoft.restapipractice.dto.group.GroupResponse;
import com.peaksoft.restapipractice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    @GetMapping("/getAll/{id}")
    public List<GroupResponse> getAllCourse(@PathVariable Long id){
        return groupService.getAllGroups(id);
    }

    @PostMapping("/save/{id}")
    public GroupResponse saveGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest)  {
        return groupService.addGroup(id, groupRequest);
    }

    @GetMapping("/findById/{id}")
    public GroupResponse findById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public GroupResponse deleteById(@PathVariable Long id){
        return groupService.deleteGroup(id);
    }

    @PutMapping("/update/{id}")
    public GroupResponse updateCourse(@RequestBody GroupRequest groupRequest, @PathVariable Long id)  {
        return groupService.updateGroup(id, groupRequest);
    }
}




