package com.example.invoice.web;


import com.example.invoice.dto.DetVenteDTO;
import com.example.invoice.service.DetFactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detail-facts")
public class DetailFactController {

    private final  DetFactService detailFactService;

    public DetailFactController(DetFactService detailFactService) {
        this.detailFactService = detailFactService;
    }

    @PostMapping("/add")
    public ResponseEntity<DetVenteDTO> addDetailFact(@RequestBody DetVenteDTO detailFactDTO) {
        return ResponseEntity.ok(detailFactService.saveDetFact(detailFactDTO));
    }


    @GetMapping("/all")
    public ResponseEntity<List<DetVenteDTO>> getAllDetailFacts() {
        return ResponseEntity.ok(detailFactService.getAllDetFacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetVenteDTO> getDetailFactById(@PathVariable Long id) {
        return ResponseEntity.ok(detailFactService.getDetFactById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDetailFact(@PathVariable Long id) {
        detailFactService.deleteDetFact(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity<DetVenteDTO> updateDetailFact(@RequestBody DetVenteDTO detailFactDTO) {
        return ResponseEntity.ok(detailFactService.updateDetFact(detailFactDTO));
    }


}
