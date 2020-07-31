package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {

    List<NewDto> findAll();

    List<NewDto> findAll(Pageable pageable);

    NewDto save(NewDto newDto);

    void delete(long[] ids);

    int totalItem();
}
