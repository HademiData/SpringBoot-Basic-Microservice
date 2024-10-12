package com.Hademi.school;


import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullSchoolResponse {

    private String name;
    private String email;
    List<Student> students;
}
