package com.example.yin.dao;

import com.example.yin.domain.Dialog;
import com.example.yin.domain.DialogAndNpc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialogMapper {
    List<Dialog> getDialogByTag(@Param("tag") String tag);

    List<DialogAndNpc> getDialogAndNpcByTag(@Param("tag") String tag);
}
