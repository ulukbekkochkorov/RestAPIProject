package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.group.GroupRequest;
import com.peaksoft.restapipractice.dto.group.GroupResponse;
import com.peaksoft.restapipractice.entity.Group;

import java.io.IOException;
import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllListGroups();

    List<GroupResponse> getAllGroups(Long courseId);


    GroupResponse addGroup(Long courseId, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse deleteGroup(Long id);
    void assignGroup(Long courseId, Long groupId) throws IOException;
}
