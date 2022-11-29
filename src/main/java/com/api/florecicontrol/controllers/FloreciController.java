package com.api.florecicontrol.controllers;

import com.api.florecicontrol.Dto.FloreciDto;
import com.api.florecicontrol.models.FloreciModel;
import com.api.florecicontrol.services.FloreciService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/floreci")
public class FloreciController {
    final FloreciService floreciService;

    public FloreciController(FloreciService floreciService) {
        this.floreciService = floreciService;
    }
    @PostMapping
    public ResponseEntity<Object> saveFloreci(@RequestBody @Valid FloreciDto floreciDto){
        if(floreciService.existsByNomeDaPlanta(floreciDto.getNomeDaPlanta())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: planta já cadastrada no sistema");}

        FloreciModel floreciModel = new FloreciModel();
        BeanUtils.copyProperties(floreciDto, floreciModel);
        floreciModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC+3")));
        return ResponseEntity.status(HttpStatus.CREATED).body(floreciService.save(floreciModel));
    }

    @GetMapping
    public ResponseEntity<Page<FloreciModel>> getAllFloreci(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(floreciService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFloreci(@PathVariable(value = "id") UUID id){
        Optional<FloreciModel> floreciModelOptional = floreciService.findById(id);
        if (!floreciModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no sistema não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(floreciModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFloreci(@PathVariable(value = "id") UUID id){
        Optional<FloreciModel> floreciModelOptional = floreciService.findById(id);
        if (!floreciModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no sistema não encontrado");
        }
        floreciService.delete(floreciModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFloreci(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid FloreciDto floreciDto){
        Optional<FloreciModel> floreciModelOptional = floreciService.findById(id);
        if (!floreciModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no sistema não encontrado");
        }
        FloreciModel floreciModel = new FloreciModel();
        BeanUtils.copyProperties(floreciDto, floreciModel);
        floreciModel.setId(floreciModelOptional.get().getId());
        floreciModel.setRegistrationDate(floreciModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(floreciService.save(floreciModel));
    }






}
