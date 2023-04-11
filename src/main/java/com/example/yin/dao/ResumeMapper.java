package com.example.yin.dao;

import com.example.yin.pojo.Resume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeMapper {
    Resume selectResumeByAccount(@Param("account") String account);

    int updateResume(Resume resume);

    int insertResume(Resume resume);
}
