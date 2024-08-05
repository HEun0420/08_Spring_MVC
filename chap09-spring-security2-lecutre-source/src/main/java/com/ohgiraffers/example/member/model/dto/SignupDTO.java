package com.ohgiraffers.example.member.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SignupDTO {

    private String memberId;
    private String password;
    private String name;
    private String role;

}
