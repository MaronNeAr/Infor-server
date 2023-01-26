package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.BankCard;
import com.example.yin.pojo.Card.BusinessLicense;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLicenseMapper {
    BusinessLicense selectBusinessLicenseByUid(@Param("uid")Integer uid);

    int updateBusinessLicense(BusinessLicense businessLicense);

    int insertBusinessLicense(BusinessLicense businessLicense);
}
