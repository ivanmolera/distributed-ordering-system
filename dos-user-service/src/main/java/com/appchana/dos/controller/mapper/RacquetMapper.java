package com.appchana.dos.controller.mapper;

import com.appchana.dos.dao.model.Racquet;
import com.appchana.dos.dto.RacquetDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class RacquetMapper {
    public static Racquet makeRacquet(RacquetDTO racquetDTO)
    {
        return new Racquet(racquetDTO.getMark(), racquetDTO.getModel());
    }

    public static RacquetDTO makeRacquetDTO(Racquet racquet)
    {
        RacquetDTO.RacquetDTOBuilder racquetDTOBuilder = RacquetDTO.newBuilder()
                .setRacquetId(racquet.getRacquetId())
                .setMark(racquet.getMark())
                .setModel(racquet.getModel())
                .setDescription(racquet.getDescription());

        return racquetDTOBuilder.createRacquetDTO();
    }


    public static List<RacquetDTO> makeRacquetDTOList(Collection<Racquet> racquets)
    {
        return racquets.stream()
                .map(RacquetMapper::makeRacquetDTO)
                .collect(Collectors.toList());
    }
}
