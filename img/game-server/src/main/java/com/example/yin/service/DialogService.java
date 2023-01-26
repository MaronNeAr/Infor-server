package com.example.yin.service;

import com.example.yin.dao.DialogMapper;
import com.example.yin.domain.Dialog;
import com.example.yin.domain.DialogAndNpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogService {
    @Autowired
    DialogMapper dialogMapper;

    public List<Dialog> getDialogByTag(String tag) {
        return dialogMapper.getDialogByTag(tag);
    }

    public List<DialogAndNpc> getDialogAndNpcByTag(String tag) {
        return dialogMapper.getDialogAndNpcByTag(tag);
    }
}
