package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDto;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewConverter newConverter;


    @Override
    public List<NewDto> findAll() {
        List<NewDto> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity entity: entities) {
            NewDto newDto = newConverter.toDto(entity);
            results.add(newDto);
        }
        return results;
    }

    @Override
    public List<NewDto> findAll(Pageable pageable) {
        List<NewDto> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity entity: entities) {
            NewDto newDto = newConverter.toDto(entity);
            results.add(newDto);
        }
        return results;
    }

    @Override
    public NewDto save(NewDto newDto) {
        NewEntity newEntity = new NewEntity();
        if(newDto.getId() != null) {
            NewEntity oldNew = newRepository.findOne(newDto.getId());
            newEntity = newConverter.toEntity(newDto, oldNew);
        }
        else {
            newEntity = newConverter.toEntity(newDto);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDto.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDto(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (Long item:ids) {
            newRepository.delete(item);
        }
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }
}
