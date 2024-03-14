package com.phuochuan.SearchOnFileApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindRequest {
    private String id;
    @JsonProperty("folder_path")
    private String folderPath;


}
