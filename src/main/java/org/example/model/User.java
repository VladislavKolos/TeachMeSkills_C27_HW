package org.example.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class User {
    private int id;
    private String email;
    private String login;
}

