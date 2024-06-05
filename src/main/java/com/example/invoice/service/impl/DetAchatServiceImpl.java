package com.example.invoice.service.impl;

import com.example.invoice.model.DetAchat;
import com.example.invoice.repository.DetAchatRepository;
import com.example.invoice.service.DetAchatService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetAchatServiceImpl implements DetAchatService {


    private DetAchatRepository DetAchatRepository;


    public DetAchatServiceImpl(DetAchatRepository DetAchatRepository) {
        this.DetAchatRepository = DetAchatRepository;
    }


    @Override
    public DetAchat updateDetAchat(DetAchat DetAchat) {
        return DetAchatRepository.save(DetAchat);
    }

    @Override
    public void deleteDetAchat(Long id) {

        DetAchatRepository.deleteById(id);

    }

    @Override
    public DetAchat getDetAchat(Long id) {
        return DetAchatRepository.findById(id).orElseThrow(() -> new RuntimeException("DetAchat non trouvé"));
    }

    @Override
    public List<DetAchat> getAllDetAchatByIdEnteteAchat(Long idEnteteAchat) {
        return DetAchatRepository.findAllByEnteteAchatId(idEnteteAchat);
    }
}
