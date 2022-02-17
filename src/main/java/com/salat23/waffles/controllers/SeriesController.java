package com.salat23.waffles.controllers;

import com.cloudinary.Cloudinary;
import com.salat23.waffles.models.ImageResource;
import com.salat23.waffles.models.series.Series;
import com.salat23.waffles.models.series.SeriesTag;
import com.salat23.waffles.models.series.Tag;
import com.salat23.waffles.payload.request.AddTagsToSeriesRequest;
import com.salat23.waffles.payload.request.SeriesUploadRequest;
import com.salat23.waffles.payload.response.EpisodeSetResponse;
import com.salat23.waffles.payload.response.SeriesResponse;
import com.salat23.waffles.payload.response.TagResponse;
import com.salat23.waffles.repository.SeriesRepository;
import com.salat23.waffles.repository.SeriesTagRepository;
import com.salat23.waffles.repository.TagsRepository;
import com.salat23.waffles.services.ImageUploadService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class SeriesController {

    private final SeriesRepository seriesRepository;
    private final SeriesTagRepository seriesTagRepository;
    private final TagsRepository tagsRepository;
    private final ImageUploadService imageUploadService;

    public SeriesController(SeriesRepository seriesRepository, SeriesTagRepository seriesTagRepository, TagsRepository tagsRepository, ImageUploadService imageUploadService) {
        this.seriesRepository = seriesRepository;
        this.seriesTagRepository = seriesTagRepository;
        this.tagsRepository = tagsRepository;
        this.imageUploadService = imageUploadService;
    }

    @GetMapping("/series/page/{page}")
    public Page<SeriesResponse> pageSeries(@PathVariable Integer page) {
        Pageable sortedByLatest = PageRequest.of(page, 4, Sort.by("firstCreated").descending());
        List<SeriesResponse> list = seriesRepository.findAll(sortedByLatest)
                .stream().map(this::seriesToSeriesResponse).collect(Collectors.toList());
        return new PageImpl<>(list, sortedByLatest, list.size());
    }

    @GetMapping("/series/title/{title}")
    public SeriesResponse getSeries(@PathVariable String title) {
        Series series = seriesRepository.findSeriesByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Series %s was not found", title)));

        return seriesToSeriesResponse(series);
    }

    @GetMapping("/series/id/{id}")
    public SeriesResponse getSeries(@PathVariable Long id) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Series with id %s was not found", id)));

        return seriesToSeriesResponse(series);
    }

    @PostMapping("/series/cover/{id}")
    public Map<String, String> uploadCover(@PathVariable Long id, @RequestBody MultipartFile cover) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Series with id %s were not found", id)));
        try {
            ImageResource imageResource = imageUploadService.uploadImage(cover);
            series = imageUploadService.changeSeriesCover(series, imageResource);
            seriesRepository.save(series);
            System.out.println(imageResource.getUrl());
            return Collections.singletonMap("url", imageResource.getUrl());
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    @PostMapping("/series/upload")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
    public SeriesResponse uploadSeries(@RequestBody SeriesUploadRequest request) {



        return null;
    }



    @PostMapping("/series/{title}/tags")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
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

    private SeriesResponse seriesToSeriesResponse(Series p) {
        SeriesResponse response = new SeriesResponse();
        response.setId(p.getId());
        response.setTitle(p.getTitle());
        response.setDescription(p.getDescription());
        response.setCover(p.getCover().getUrl());
        response.setType(p.getType().getName());
        response.setEpisodeVariants(p.getEpisodeVariants().stream().map(ev -> {
            EpisodeSetResponse episodeSetResponse = new EpisodeSetResponse();
            episodeSetResponse.setName(ev.getName());
            episodeSetResponse.setEpisodes(ev.getEpisodes());
            return episodeSetResponse;
        }).collect(Collectors.toSet()));
        response.setDirector(p.getDirector().getName());
        response.setSource(p.getSource().getName());
        response.setStatus(p.getStatus().getName().toString());
        response.setAgeRestriction(p.getAgeRestriction().getMinAge());
        response.setStudio(p.getStudio().getName());
        response.setTags(p.getTags().stream().map(
                t -> t.getTag().getName()).collect(Collectors.toSet()));
        return response;
    }

}
