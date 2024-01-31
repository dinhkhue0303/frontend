package com.example.medicinesalesmanagement.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_member;
    private String name;
    private String numberPhone;
    @ManyToOne
    @JoinColumn(name = "type_member_id", referencedColumnName = "type_member_id")
    private TypeMember typeMember;

    public Member() {
    }

    public Member(Integer id_member, String name, String numberPhone, TypeMember typeMember) {
        this.id_member = id_member;
        this.name = name;
        this.numberPhone = numberPhone;
        this.typeMember = typeMember;
    }

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public TypeMember getTypeMember() {
        return typeMember;
    }

    public void setTypeMember(TypeMember typeMember) {
        this.typeMember = typeMember;
    }
}
