package com.app.studenthub.service;

import com.app.studenthub.model.Member;
import com.app.studenthub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getMembersByUserId(Long id) {
        return memberRepository.findAllByUser_Id(id);
    }

    public List<Member> getMembersByGroupId(Long id) {
        return memberRepository.findAllByGroup_Id(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member memberDetails) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            Member existingMember = optionalMember.get();
            existingMember.setUser(memberDetails.getUser());
            existingMember.setGroup(memberDetails.getGroup());
            return memberRepository.save(existingMember);
        } else {
            throw new RuntimeException("Member not found with id: " + id);
        }
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
