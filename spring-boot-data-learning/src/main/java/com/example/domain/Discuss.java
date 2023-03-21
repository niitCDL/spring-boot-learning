package com.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "t_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discuss {
    /**
     * 制定主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")
    private Integer AId;

}
