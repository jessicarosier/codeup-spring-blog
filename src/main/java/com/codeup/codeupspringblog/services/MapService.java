package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.Map;
import com.codeup.codeupspringblog.repositories.MapRepository;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    private MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public Map saveMap(Map map) {
        return mapRepository.save(map);
    }



}
