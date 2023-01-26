package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.IdCardBack;
import com.example.yin.pojo.Card.IdCardFront;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardFrontMapper {
    IdCardFront selectIdCardFrontByUid(@Param("uid")Integer uid);

    int updateIdCardFront(IdCardFront idCardFront);

    int insertIdCardFront(IdCardFront idCardFront);
}
