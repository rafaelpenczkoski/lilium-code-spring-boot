package com.lilium.springangular.api;

import com.lilium.springangular.dto.BaseDTO;
import com.lilium.springangular.dto.search.PagedResponse;
import com.lilium.springangular.dto.search.SearchRequest;
import com.lilium.springangular.entity.DistributedEntity;

public interface AbstractCRUDLApi<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    DTO save(DTO dto);

    DTO getById(Integer id);

    PagedResponse<DTO> list(SearchRequest request);

    Boolean delete(Integer id);

}
