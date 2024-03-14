package com.phuochuan.SearchOnFileApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FileInformation {
    private String name;
    private Long size;
    @JsonProperty("absolute_path")
    private String absolutePath;

}
