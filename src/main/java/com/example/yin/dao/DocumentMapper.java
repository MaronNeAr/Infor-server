package com.example.yin.dao;

import com.example.yin.pojo.Doc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMapper {
    List<Doc> selectFilesByAccount(@Param("account") String account);

    int insertFile(Doc document);
}
