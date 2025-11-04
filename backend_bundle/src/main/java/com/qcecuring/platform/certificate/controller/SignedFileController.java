package com.qcecuring.platform.certificate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.qcecuring.platform.certificate.service.SignedFileService;
import com.qcecuring.platform.certificate.model.SignedFileEntity;
import java.util.List;

@RestController
@RequestMapping("/api/signed-files")
public class SignedFileController {
    private final SignedFileService signedFileService;
    
    // Constructor for dependency injection
    public SignedFileController(SignedFileService signedFileService) {
        this.signedFileService = signedFileService;
    }

    @PostMapping("/sign")
    public ResponseEntity<SignedFileEntity> signFile(@RequestParam String fileName, @RequestParam String certificateId) {
        SignedFileEntity signedFile = signedFileService.signFile(fileName, certificateId);
        return ResponseEntity.status(HttpStatus.CREATED).body(signedFile);
    }

    @GetMapping
    public ResponseEntity<List<SignedFileEntity>> listAllSignedFiles() {
        List<SignedFileEntity> signedFiles = signedFileService.getAllSignedFiles();
        return ResponseEntity.ok(signedFiles);
    }
}