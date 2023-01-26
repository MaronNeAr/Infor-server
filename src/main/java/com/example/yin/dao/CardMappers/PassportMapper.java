package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.Passport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportMapper {
    Passport selectPassportByUid(@Param("uid")Integer uid);

    int updatePassport(Passport passport);

    int insertPassport(Passport passport);
}
