package com.salat23.wafflesfullstack.controller;

import com.salat23.wafflesfullstack.model.Episode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Episode hello() {
        Episode episode = new Episode();
        episode.setTitle("Hello world!");
        return episode;
    }

}
