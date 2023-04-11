package com.example.yin.dao;

import com.example.yin.pojo.Card;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardMapper {
    List<Card> selectCardByAccount(@Param("account")String account);

    Card selectCardByAccountAndType(@Param("account")String account, @Param("type")String type);

    int insertCard(Card card);

    int updateCard(Card card);
}
