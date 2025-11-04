package com.qcecuring.platform.certificate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.qcecuring.platform.certificate.service.CertificateService;
import com.qcecuring.platform.certificate.dto.mapper.CertificateMapper;
import com.qcecuring.platform.certificate.dto.request.CertificateRequestDTO;
import com.qcecuring.platform.certificate.dto.response.CertificateResponseDTO;
import com.qcecuring.platform.certificate.model.CertificateEntity;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
    private final CertificateService service;
    private final CertificateMapper mapper;
    
    // Constructor for dependency injection
    public CertificateController(CertificateService service, CertificateMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CertificateResponseDTO> issue(@Valid @RequestBody CertificateRequestDTO dto) {
        CertificateEntity entity = mapper.toEntity(dto);
        CertificateEntity issued = service.issueCertificate(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(issued));
    }

    @GetMapping
    public ResponseEntity<List<CertificateResponseDTO>> listAll() {
        List<CertificateEntity> certificates = service.getAllCertificates();
        List<CertificateResponseDTO> response = certificates.stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}