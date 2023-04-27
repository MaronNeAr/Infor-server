package com.example.yin.dao;

import com.example.yin.pojo.Bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    List<Bill> selectBillByAccount(@Param("account")String account);

    Bill selectBillByAccountAndType(@Param("account")String account, @Param("type")String type);

    int insertBill(Bill bill);

    int updateCard(Bill bill);

    int updateTagsAndNoteByBid(@Param("id") Integer id, @Param("tags") String tags, @Param("note") String note);
}
