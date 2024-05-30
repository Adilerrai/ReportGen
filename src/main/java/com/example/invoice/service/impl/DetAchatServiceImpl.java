package com.example.invoice.service.impl;

import com.example.invoice.model.DetAchat;
import com.example.invoice.repository.DetAchatRepository;
import com.example.invoice.service.DetAchatService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetAchatServiceImpl implements DetAchatService {


    private DetAchatRepository detAchatRepository;


    public DetAchatServiceImpl(DetAchatRepository detAchatRepository) {
        this.detAchatRepository = detAchatRepository;
    }


    @Override
    public DetAchat updateDetAchat(DetAchat detAchat) {
        return detAchatRepository.save(detAchat);
    }

    @Override
    public void deleteDetAchat(Long id) {

        detAchatRepository.deleteById(id);

    }

    @Override
    public DetAchat getDetAchat(Long id) {
        return detAchatRepository.findById(id).orElseThrow(() -> new RuntimeException("DetAchat non trouvé"));
    }

    @Override
    public List<DetAchat> getAllDetAchatByIdAchat(Long idAchat) {
        return detAchatRepository.findAllByAchatId(idAchat);
    }
}
