package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "t_superman")
public class Superman {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String isParent;
    private Boolean open;
    private Integer pid;
    // 前端JS对象的children数组(对应List)里存的还是JS对象（对应Superman），所以是List<Superman>
//    @Transient
    private List<Superman> children = new ArrayList<>();
}