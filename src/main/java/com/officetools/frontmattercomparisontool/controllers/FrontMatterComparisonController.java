package com.officetools.frontmattercomparisontool.controllers;
import com.officetools.frontmattercomparisontool.services.FrontMatterComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FrontMatterComparisonController {
    @Autowired
    FrontMatterComparisonService frontMatterComparisonService;
    @PostMapping("/comparator")
    public ResponseEntity<List<String>> processPDF(
            @RequestPart("oldRevisionFile") MultipartFile pdfFile1,
            @RequestPart("currentRevisionFile") MultipartFile pdfFile2) {
        try {
            Optional<List<String>> oldFile = frontMatterComparisonService.readPDF(pdfFile1);
            Optional<List<String>> newFile = frontMatterComparisonService.readPDF(pdfFile2);
            if(oldFile.isEmpty() || newFile.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Optional<ArrayList<String>> output
                    = frontMatterComparisonService.getRevisionChangesInToc(oldFile, newFile);
            if(output.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(output.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }
}
