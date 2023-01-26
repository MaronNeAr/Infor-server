package com.example.yin.controller;

import com.example.yin.config.common.SuccessMessage;
import com.example.yin.domain.Dialog;
import com.example.yin.domain.DialogAndNpc;
import com.example.yin.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DialogController {
    @Autowired
    DialogService dialogService;

    @GetMapping("/dialog/{tag}")
    public Object getDialog(@PathVariable("tag") String tag) {
        return new SuccessMessage<List<Dialog>>(null, dialogService.getDialogByTag(tag)).getMessage();
    }

    @GetMapping("/dialog&npc/{tag}")
    public Object getDialogAndNpc(@PathVariable("tag") String tag) {
        return new SuccessMessage<List<DialogAndNpc>>(null, dialogService.getDialogAndNpcByTag(tag)).getMessage();
    }
}
