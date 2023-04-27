package com.example.yin.service;

import com.example.yin.dao.BillMapper;
import com.example.yin.pojo.Bill;
import com.example.yin.pojo.vo.CardDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;

    private Set<String> typeSet = new HashSet<String>(){{add("bankcard");add("other");}};

    public List<Bill> getBill(String account) {
        return billMapper.selectBillByAccount(account);
    }

    public Bill getBill(String account, String type) {
        return billMapper.selectBillByAccountAndType(account, type);
    }

    public boolean updateBill(Bill bill) {
        return billMapper.insertBill(bill) > 0;
//        String account = bill.getAccount();
//        String type = bill.getType();
//        if (typeSet.contains(type) || billMapper.selectBillByAccountAndType(account, type) == null) return billMapper.insertBill(bill) > 0;
//        else return billMapper.updateCard(bill) > 0;
    }

    public boolean updateTagsAndNoteByBid (Integer id, String tags, String note) {
        return billMapper.updateTagsAndNoteByBid(id, tags, note) > 0;
    }
}
