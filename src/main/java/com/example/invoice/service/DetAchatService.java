package com.example.invoice.service;

import com.example.invoice.model.DetAchat;

import java.util.List;

public interface DetAchatService {


    DetAchat updateDetAchat(DetAchat detAchat);

    void deleteDetAchat(Long id);

    DetAchat getDetAchat(Long id);

    List<DetAchat> getAllDetAchatByIdAchat(Long idAchat);


}
