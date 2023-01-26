package com.example.yin.dao.CardMappers;

import com.example.yin.pojo.Card.RegisterBooklet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterBookletMapper {
    RegisterBooklet selectRegisterBookletByUid(@Param("uid")Integer uid);

    int updateRegisterBooklet(RegisterBooklet registerBooklet);

    int insertRegisterBooklet(RegisterBooklet registerBooklet);
}
