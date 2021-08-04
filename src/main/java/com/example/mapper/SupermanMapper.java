package com.example.mapper;

import com.example.entity.Superman;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SupermanMapper {

    List<Superman> select(Superman superman);


    List<Superman> selectAll();
}
