package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.model.Member;
import com.example.medicinesalesmanagement.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    IMemberService iMemberService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Member>> findAll(@RequestParam String name){
        List<Member> memberList = iMemberService.findMemberByNameContaining(name);
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Member>> findAll(){
        List<Member> memberList = iMemberService.findAll();
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Member> create(@RequestBody Member member){
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iMemberService.save(member);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> detail(@PathVariable Integer id){
        Member member = iMemberService.findById(id);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Integer id,@RequestBody Member member){
        Member member1 = iMemberService.findById(id);
        if(member1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iMemberService.save(member);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Member> delete(@PathVariable Integer id){
        Member member = iMemberService.findById(id);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iMemberService.delete(id);
        return new ResponseEntity<>(member,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/listByTypeMember/{id}")
    public ResponseEntity<List<Member>> findMemberByTypeMember(@PathVariable Integer id){
        List<Member> memberList = iMemberService.findMemberByTypeMember(id);
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
}
