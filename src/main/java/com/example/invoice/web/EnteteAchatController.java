package com.example.invoice.web;

import com.example.invoice.dto.EnteteAchatDTO;
import com.example.invoice.fileGeneration.ReportService;
import com.example.invoice.model.EnteteAchat;
import com.example.invoice.model.EnteteAchatCriteria;
import com.example.invoice.service.EnteteAchatService;
import com.example.invoice.service.impl.EnteteAchatServiceImpl;
import com.example.invoice.service.mapper.EnteteAchatMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/EnteteAchat")
public class EnteteAchatController {

    private final EnteteAchatService EnteteAchatService;
    private final EnteteAchatMapper EnteteAchatMapper;

    private final ReportService rapportService;

    public EnteteAchatController(EnteteAchatServiceImpl EnteteAchatServiceImpl, EnteteAchatMapper EnteteAchatMapper, ReportService rapportService) {
        this.EnteteAchatService = EnteteAchatServiceImpl;
        this.EnteteAchatMapper = EnteteAchatMapper;
        this.rapportService = rapportService;
    }

    @PostMapping("/nouvelle-EnteteAchat")
    public ResponseEntity<EnteteAchatDTO> createEnteteAchat(@RequestBody EnteteAchatDTO EnteteAchatDTO) {
        EnteteAchat EnteteAchat = EnteteAchatMapper.dtoToEntity(EnteteAchatDTO);
        EnteteAchat EnteteAchat1 = EnteteAchatService.creatEnteteAchat(EnteteAchat);
        return ResponseEntity.ok(EnteteAchatMapper.entityToDto(EnteteAchat1));
    }

    @PostMapping("/modifier-EnteteAchat")
    public ResponseEntity<EnteteAchatDTO> updateEnteteAchat(@RequestBody EnteteAchatDTO EnteteAchatDTO) {
        EnteteAchat EnteteAchat = EnteteAchatMapper.dtoToEntity(EnteteAchatDTO);
        EnteteAchat EnteteAchat1 = EnteteAchatService.updateEnteteAchat(EnteteAchat);
        return ResponseEntity.ok(EnteteAchatMapper.entityToDto(EnteteAchat1));
    }

    @DeleteMapping("/supprimer-EnteteAchat/{id}")
    public ResponseEntity<Void> deleteEnteteAchat(@PathVariable Long id) {
        EnteteAchatService.deleteEnteteAchat(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-EnteteAchat/{id}")
    public ResponseEntity<EnteteAchatDTO> getEnteteAchat(@PathVariable Long id) {
        EnteteAchat EnteteAchat = EnteteAchatService.getEnteteAchatById(id);
        return ResponseEntity.ok(EnteteAchatMapper.entityToDto(EnteteAchat));
    }

    @PostMapping("/get-all-EnteteAchats-paginated")
    public ResponseEntity<Page<EnteteAchatDTO>> getAllEnteteAchatsPaginated(@RequestBody EnteteAchatCriteria EnteteAchatCriteria, Pageable pageable) {
        System.out.println("criteria after making changes on enum : " + EnteteAchatCriteria.getStatusEnteteAchat());
        System.out.println("criteria after making changes on fou : " + EnteteAchatCriteria.getFournisseurId());
        Page<EnteteAchat> EnteteAchats = EnteteAchatService.getAllEnteteAchatsPaginated(EnteteAchatCriteria, pageable)    ;
        return ResponseEntity.ok(EnteteAchats.map(EnteteAchatMapper::entityToDto));
    }

    @GetMapping("/rapport-EnteteAchat/{id}")
    public ResponseEntity<String> generateEnteteAchatReport(@PathVariable Long id) {
        return ResponseEntity.ok(rapportService.generateEnteteAchat(id));
    }

    @PostMapping("/valide-EnteteAchat/{id}")
    public ResponseEntity<EnteteAchatDTO> valideEnteteAchat(@PathVariable Long id) {
        EnteteAchat EnteteAchat = EnteteAchatService.valideEnteteAchat(id);
        return ResponseEntity.ok(EnteteAchatMapper.entityToDto(EnteteAchat));
    }



}
