package com.app.studenthub.controller;

import com.app.studenthub.model.Member;
import com.app.studenthub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id)
                .map(member -> new ResponseEntity<>(member, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Member>> getAllMembersByUserId(@PathVariable Long userId) {
        List<Member> members = memberService.getMembersByUserId(userId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Member>> getAllMembersByGroupId(@PathVariable Long groupId) {
        List<Member> members = memberService.getMembersByGroupId(groupId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Example POST method for adding a new member to a group
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member createdMember = memberService.createMember(member);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    // Example PUT method for updating a member's details
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        try {
            Member updatedMember = memberService.updateMember(id, memberDetails);
            return new ResponseEntity<>(updatedMember, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Example DELETE method for removing a member
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable Long id) {
        try {
            memberService.deleteMember(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
