package com.lilium.springangular.controller;

import com.lilium.springangular.api.AbstractCRUDLApi;
import com.lilium.springangular.dto.BaseDTO;
import com.lilium.springangular.entity.DistributedEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractCRUDLController<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    private final AbstractCRUDLApi<ENTITY, DTO> api;

    public AbstractCRUDLController(AbstractCRUDLApi<ENTITY, DTO> api) {
        this.api = api;
    }

    @PostMapping
    public DTO save(@RequestBody DTO dto) {
        return api.save(dto);
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable Integer id) {
        return api.getById(id);
    }

    @GetMapping("/list")
    public List<DTO> list() {
        return api.list();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return api.delete(id);
    }

}