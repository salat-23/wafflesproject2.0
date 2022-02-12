package com.salat23.spring.security.waffles.controllers;

import com.salat23.spring.security.waffles.models.series.Series;
import com.salat23.spring.security.waffles.models.series.SeriesTag;
import com.salat23.spring.security.waffles.models.series.Tag;
import com.salat23.spring.security.waffles.payload.request.AddTagsToSeriesRequest;
import com.salat23.spring.security.waffles.payload.request.SeriesUploadRequest;
import com.salat23.spring.security.waffles.payload.response.EpisodeSetResponse;
import com.salat23.spring.security.waffles.payload.response.SeriesResponse;
import com.salat23.spring.security.waffles.payload.response.TagResponse;
import com.salat23.spring.security.waffles.repository.SeriesRepository;
import com.salat23.spring.security.waffles.repository.SeriesTagRepository;
import com.salat23.spring.security.waffles.repository.TagsRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class SeriesController {

    private final SeriesRepository seriesRepository;
    private final SeriesTagRepository seriesTagRepository;
    private final TagsRepository tagsRepository;

    public SeriesController(SeriesRepository seriesRepository, SeriesTagRepository seriesTagRepository, TagsRepository tagsRepository) {
        this.seriesRepository = seriesRepository;
        this.seriesTagRepository = seriesTagRepository;
        this.tagsRepository = tagsRepository;
    }


    @GetMapping("/series/{title}")
    public SeriesResponse getSeries(@PathVariable String title) {
        Series series = seriesRepository.findSeriesByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Series %s was not found", title)));

        SeriesResponse response = new SeriesResponse();
        response.setTitle(series.getTitle());
        response.setDescription(series.getDescription());
        response.setCover(series.getCover().getUrl());
        response.setType(series.getType().getName());
        response.setEpisodeVariants(series.getEpisodeVariants().stream().map(ev -> {
            EpisodeSetResponse episodeSetResponse = new EpisodeSetResponse();
            episodeSetResponse.setName(ev.getName());
            episodeSetResponse.setEpisodes(ev.getEpisodes());

            return episodeSetResponse;
        }).collect(Collectors.toSet()));
        response.setDirector(series.getDirector().getName());
        response.setSource(series.getSource().getName());
        response.setStatus(series.getStatus().getName().toString());
        response.setAgeRestriction(series.getAgeRestriction().getMinAge());
        response.setStudio(series.getStudio().getName());
        response.setTags(series.getTags().stream().map(
                t -> t.getTag().getName()).collect(Collectors.toSet()));

        return response;
    }

    @PostMapping("/series/upload")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
    public SeriesResponse uploadSeries(@RequestBody SeriesUploadRequest request) {


        return null;
    }

    @PostMapping("/series/{title}/tags")
    public Set<TagResponse> addTagsToSeries(@RequestBody AddTagsToSeriesRequest request, @PathVariable String title) {

        Series series = seriesRepository.findSeriesByTitle(title)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("Series with title %s was not found", title)));
        request.getTagIds().forEach(tag -> {
            if (seriesTagRepository.existsBySeries_TitleAndTag_Id(series.getTitle(), tag))
                return;
            Optional<Tag> foundTag = tagsRepository.findById(tag);
            if (foundTag.isEmpty()) return;
            SeriesTag seriesTag = new SeriesTag();
            seriesTag.setSeries(series);
            seriesTag.setTag(foundTag.get());
            seriesTagRepository.save(seriesTag);
        });

        return seriesTagRepository.findSeriesTagsBySeries_Title(title)
                .stream().map(ts -> {
                    TagResponse tagResponse = new TagResponse();
                    tagResponse.setId(ts.getTag().getId());
                    tagResponse.setName(ts.getTag().getName());
                    return tagResponse;
                }).collect(Collectors.toSet());
    }


}
