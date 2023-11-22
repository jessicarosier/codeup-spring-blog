package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Map;
import com.codeup.codeupspringblog.services.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

    private MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }


    @PostMapping("/save")
    public Map saveMap(@ModelAttribute Map map) {
        return mapService.saveMap(map);
    }
}
