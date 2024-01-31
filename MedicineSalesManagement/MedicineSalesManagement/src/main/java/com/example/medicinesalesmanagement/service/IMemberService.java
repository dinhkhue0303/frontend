package com.example.medicinesalesmanagement.service;

import com.example.medicinesalesmanagement.model.Member;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface IMemberService {
    List<Member> findMemberByNameContaining(String name);
    List<Member> findAll();
    void save(Member member);
    Member findById(Integer id);
    void delete(Integer id);
    List<Member> findMemberByTypeMember(Integer id);
}
