package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.IdCardBack;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardBackMapper {
    IdCardBack selectIdCardBackByUid(@Param("uid")Integer uid);

    int updateIdCardBack(IdCardBack idCardBack);

    int insertIdCardBack(IdCardBack idCardBack);
}
