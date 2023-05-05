package com.task.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "t_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String cover;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id")
    private List<Discuss> discussesList;

}
