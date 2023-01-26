package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.BankCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardMapper {
    BankCard selectBankCardByUid(@Param("uid") Integer uid);

    int updateBankCard(BankCard bankCard);

    int insertBankCard(BankCard bankCard);
}
