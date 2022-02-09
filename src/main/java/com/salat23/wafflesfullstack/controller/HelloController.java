package com.salat23.wafflesfullstack.controller;

import com.salat23.wafflesfullstack.entity.EpisodeEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/api/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("email"));
    }

    @GetMapping("/api/hello")
    public EpisodeEntity hello() {
        EpisodeEntity episode = new EpisodeEntity();
        episode.setTitle("Hello world!");
        return episode;
    }

}
