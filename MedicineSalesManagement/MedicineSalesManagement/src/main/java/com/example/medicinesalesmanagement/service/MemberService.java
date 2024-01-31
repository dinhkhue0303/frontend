package com.example.medicinesalesmanagement.service;

import com.example.medicinesalesmanagement.model.Member;
import com.example.medicinesalesmanagement.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService implements IMemberService{
    @Autowired
    IMemberRepository iMemberRepository;
    @Override
    public List<Member> findMemberByNameContaining(String name) {
        return iMemberRepository.findMemberByNameContaining(name);
    }

    @Override
    public List<Member> findAll() {
        return iMemberRepository.findAll();
    }

    @Override
    public void save(Member member) {
        iMemberRepository.save(member);
    }

    @Override
    public Member findById(Integer id) {
        return iMemberRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iMemberRepository.deleteById(id);
    }

    @Override
    public List<Member> findMemberByTypeMember(Integer id) {
        return iMemberRepository.findMemberByTypeMember(id);
    }
}
