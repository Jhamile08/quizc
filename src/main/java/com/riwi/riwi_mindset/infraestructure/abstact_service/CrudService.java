package com.riwi.riwi_mindset.infraestructure.abstact_service;

import org.springframework.data.domain.Page;

import com.riwi.riwi_mindset.utils.enums.SortType;

/**
 * RQ = Request
 * RS = Response
 * ID = Tipo de dato de la llave primaria de la entidad
 */
public interface CrudService <RQ,RS,ID> {
    public RS create(RQ request);

    public RS get(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);

    public Page<RS> getAll(int page, int size, SortType sortType);
}