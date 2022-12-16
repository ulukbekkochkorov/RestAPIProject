package com.peaksoft.restapipractice.service.impl;

import com.peaksoft.restapipractice.converter.group.GroupRequestConverter;
import com.peaksoft.restapipractice.converter.group.GroupResponseConverter;
import com.peaksoft.restapipractice.dto.group.GroupRequest;
import com.peaksoft.restapipractice.dto.group.GroupResponse;
import com.peaksoft.restapipractice.entity.Course;
import com.peaksoft.restapipractice.entity.Group;
import com.peaksoft.restapipractice.repository.CourseRepository;
import com.peaksoft.restapipractice.repository.GroupRepository;
import com.peaksoft.restapipractice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final GroupRequestConverter groupRequestConverter;
    private final GroupResponseConverter groupResponseConverter;



    @Override
    public List<GroupResponse> getAllListGroups() {
        return groupResponseConverter.view(groupRepository.findAll());
    }

    @Override
    public List<GroupResponse> getAllGroups(Long courseId) {
        return groupResponseConverter.view(courseRepository.getReferenceById(courseId).getGroups());    }


    @Override
    public GroupResponse addGroup(Long courseId, GroupRequest groupRequest) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRequestConverter.createGroup(groupRequest);
        course.addGroup(group);
        group.addCourse(course);
        groupRepository.save(group);
        return groupResponseConverter.viewGroup(group);

    }

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group =  groupRepository.findById(id).get();
        return groupResponseConverter.viewGroup(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group =  groupRepository.findById(id).get();
        groupRequestConverter.updateGroup(group,groupRequest);
        groupRepository.save(group);
        return groupResponseConverter.viewGroup(group);

    }

    @Override
    public GroupResponse deleteGroup(Long id) {
        Group group =  groupRepository.findById(id).get();

        for (Course c: group.getCourses()) {
            c.getGroups().remove(group);
        }
        group.setCourses(null);
        groupRepository.delete(group);
        return groupResponseConverter.viewGroup(group);
    }



    @Override
    public void assignGroup(Long courseId, Long groupId) throws IOException {
        Group group = groupRepository.findById(groupId).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getGroups() != null) {
            for (Group g : course.getGroups()) {
                if (g.getId() == courseId) {
                    throw new IOException("This group already exists!");
                }
            }
        }
        group.addCourse(course);
        course.addGroup(group);
        courseRepository.save(course);
        groupRepository.save(group);
    }
}
