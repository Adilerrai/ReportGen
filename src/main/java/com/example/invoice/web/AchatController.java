package com.example.invoice.web;

import com.example.invoice.dto.AchatDTO;
import com.example.invoice.model.Achat;
import com.example.invoice.model.AchatCriteria;
import com.example.invoice.service.AchatService;
import com.example.invoice.service.impl.AchatServiceImpl;
import com.example.invoice.service.mapper.AchatMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/achat")
public class AchatController {

    private final AchatService achatService;
    private final AchatMapper achatMapper;

    public AchatController(AchatServiceImpl achatServiceImpl, AchatMapper achatMapper) {
        this.achatService = achatServiceImpl;
        this.achatMapper = achatMapper;
    }

    @PostMapping("/nouvelle-achat")
    public ResponseEntity<AchatDTO> createAchat(@RequestBody AchatDTO achatDTO) {
        Achat achat = achatMapper.dtoToEntity(achatDTO);
        Achat achat1 = achatService.creatAchat(achat);
        return ResponseEntity.ok(achatMapper.entityToDto(achat1));
    }

    @PostMapping("/modifier-achat")
    public ResponseEntity<AchatDTO> updateAchat(@RequestBody AchatDTO achatDTO) {
        Achat achat = achatMapper.dtoToEntity(achatDTO);
        Achat achat1 = achatService.updateAchat(achat);
        return ResponseEntity.ok(achatMapper.entityToDto(achat1));
    }

    @DeleteMapping("/supprimer-achat/{id}")
    public ResponseEntity<Void> deleteAchat(@PathVariable Long id) {
        achatService.deleteAchat(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-achat/{id}")
    public ResponseEntity<AchatDTO> getAchat(@PathVariable Long id) {
        Achat achat = achatService.getAchatById(id);
        return ResponseEntity.ok(achatMapper.entityToDto(achat));
    }

    @PostMapping("/get-all-achats-paginated")
    public ResponseEntity<Page<AchatDTO>> getAllAchatsPaginated(@RequestBody AchatCriteria achatCriteria, Pageable pageable) {
        Page<Achat> achats = achatService.getAllAchatsPaginated(achatCriteria, pageable)    ;
        return ResponseEntity.ok(achats.map(achatMapper::entityToDto));
    }


}
