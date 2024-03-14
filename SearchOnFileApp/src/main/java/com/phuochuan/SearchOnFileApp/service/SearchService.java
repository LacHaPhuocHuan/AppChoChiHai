package com.phuochuan.SearchOnFileApp.service;

import com.phuochuan.SearchOnFileApp.dto.FileInformation;
import com.phuochuan.SearchOnFileApp.dto.FindRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;

@Service
@Slf4j
public class SearchService {
    public FileInformation find(FindRequest request) {
        File folder = new File(request.getFolderPath());
        File[] scvFile = folder.listFiles();
        Integer fileTotal =scvFile.length;
        Integer index= findById(scvFile, fileTotal, 0, request.getId());
        File file= scvFile[index];
        FileInformation fileInformation=FileInformation.builder()
                .name(file.getName())
                .absolutePath(file.getAbsolutePath())
                .size(file.getFreeSpace())
                .build();
        return fileInformation;
    }

    private Integer findById(File[] scvFile, Integer fileTotal, int index, String id) {
        if(index==fileTotal) throw new RuntimeException("Không tìm thấy chị hai nghe.");
        File file = scvFile[index];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            try {
                String line = reader.readLine();
                while (line != null) {
                    line = reader.readLine();
                    log.info(line);
                    if(line==null) break;
                    if(line.contains(id)) return index;
                }
            } catch (IOException ex) {
                log.error(ex.getLocalizedMessage());

            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    log.error(ex.getLocalizedMessage());
                }
            }
        }catch (FileNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
        }

            return findById(scvFile, fileTotal, index+1, id);
    }


}
