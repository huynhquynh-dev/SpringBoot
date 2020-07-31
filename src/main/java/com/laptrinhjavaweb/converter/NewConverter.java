package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.NewDto;
import com.laptrinhjavaweb.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewEntity toEntity(NewDto newDto){
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(newDto.getTitle());
        newEntity.setContent(newDto.getContent());
        newEntity.setShortDescription(newDto.getShortDescription());
        newEntity.setThumbnail(newDto.getThumbnail());
        return newEntity;
    }

    public NewEntity toEntity(NewDto newDto, NewEntity newEntity){
        newEntity.setTitle(newDto.getTitle());
        newEntity.setContent(newDto.getContent());
        newEntity.setShortDescription(newDto.getShortDescription());
        newEntity.setThumbnail(newDto.getThumbnail());
        return newEntity;
    }

    public NewDto toDto(NewEntity newEntity){
        NewDto newDto = new NewDto();
        if(newEntity.getId() != null) {
            newDto.setId(newEntity.getId());
        }
        newDto.setTitle(newEntity.getTitle());
        newDto.setContent(newEntity.getContent());
        newDto.setShortDescription(newEntity.getShortDescription());
        newDto.setThumbnail(newEntity.getThumbnail());
        newDto.setCategoryCode(newEntity.getCategory().getCode());
        newDto.setCreateBy(newEntity.getCreateBy());
        newDto.setCreateDate(newEntity.getCreateDate());
        newDto.setModifiedBy(newEntity.getModifiedBy());
        newDto.setModifiedDate(newEntity.getModifiedDate());
        return newDto;
    }
}
