package com.phuochuan.SearchOnFileApp.rest;

import com.phuochuan.SearchOnFileApp.dto.FindRequest;
import com.phuochuan.SearchOnFileApp.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("")
    ResponseEntity<?> search(@RequestBody FindRequest request) throws FileNotFoundException {
        var file=searchService.find(request);
        return ResponseEntity.ok(file);
    }


}
