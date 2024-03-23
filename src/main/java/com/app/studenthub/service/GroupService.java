package com.app.studenthub.service;

import com.app.studenthub.model.Group;
import com.app.studenthub.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

//    public List<Group> getAllGroupsByUser(Long userId) {
//        return groupRepository.findGroupsByUserId(userId);
//    }

    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Long id, Group groupDetails) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            Group existingGroup = optionalGroup.get();
            existingGroup.setName(groupDetails.getName());
            existingGroup.setBody(groupDetails.getBody());
            return groupRepository.save(existingGroup);
        } else {
            throw new RuntimeException("Group not found with id: " + id);
        }
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
