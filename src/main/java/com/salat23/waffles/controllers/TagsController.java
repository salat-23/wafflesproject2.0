package com.salat23.waffles.controllers;

import com.salat23.waffles.models.series.Tag;
import com.salat23.waffles.payload.response.TagResponse;
import com.salat23.waffles.repository.SeriesTagRepository;
import com.salat23.waffles.repository.TagsRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class TagsController {

    private final SeriesTagRepository seriesTagRepository;
    private final TagsRepository tagsRepository;

    public TagsController(SeriesTagRepository tagsRepository, TagsRepository tagsRepository1) {
        this.seriesTagRepository = tagsRepository;
        this.tagsRepository = tagsRepository1;
    }

    @GetMapping("/tags")
    public Set<Tag> getTags() {
        return new HashSet<>(tagsRepository.findAll());
    }

    @GetMapping("/tags/{title}")
    public Set<TagResponse> getTagsBySeriesTitle(@PathVariable String title) {
        return seriesTagRepository.findSeriesTagsBySeries_Title(title)
                .stream().map(ts -> {
                    TagResponse tagResponse = new TagResponse();
                    tagResponse.setId(ts.getTag().getId());
                    tagResponse.setName(ts.getTag().getName());
                    return tagResponse;
                }).collect(Collectors.toSet());
    }

    @PostMapping("/tags/{name}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
    public Tag addTag(@PathVariable String name) {
        tagsRepository.findByName(name).ifPresent(s -> {
            throw new EntityExistsException("Tag is already exits");
        });
        Tag tag = new Tag();
        tag.setName(name);
        tagsRepository.save(tag);
        return tag;
    }



}
