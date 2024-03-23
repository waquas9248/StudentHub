package com.app.studenthub.controller;

import com.app.studenthub.model.Group;
import com.app.studenthub.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Group>> getAllGroupsByUser(@PathVariable Long userId) {
//        List<Group> groups = groupService.getAllGroupsByUser(userId);
//        return new ResponseEntity<>(groups, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id)
                .map(group -> new ResponseEntity<>(group, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group groupDetails) {
        try {
            Group updatedGroup = groupService.updateGroup(id, groupDetails);
            return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGroup(@PathVariable Long id) {
        try {
            groupService.deleteGroup(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
