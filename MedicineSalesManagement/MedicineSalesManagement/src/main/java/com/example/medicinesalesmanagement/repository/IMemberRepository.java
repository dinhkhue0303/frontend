package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMemberRepository extends JpaRepository<Member,Integer> {
    List<Member> findMemberByNameContaining(String name);
    @Query(value = "select * from member where type_member_id like :type_member_id",nativeQuery = true)
    List<Member> findMemberByTypeMember(@Param("type_member_id")Integer id);
}
