package com.qcecuring.platform.certificate.service;

import org.springframework.stereotype.Service;
import com.qcecuring.platform.certificate.repository.CertificateRepository;
import com.qcecuring.platform.certificate.model.CertificateEntity;
import java.time.Instant;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
    private final CertificateRepository repo;
    
    // Constructor for dependency injection
    public CertificateService(CertificateRepository repo) {
        this.repo = repo;
    }

    public CertificateEntity issueCertificate(CertificateEntity entity) {
        Objects.requireNonNull(entity, "entity required");

        // Validate that Valid To date is after Valid From date
        if (entity.getValidFrom() != null && entity.getValidTo() != null && 
            !entity.getValidTo().isAfter(entity.getValidFrom())) {
            throw new IllegalArgumentException("Valid To date must be after Valid From date");
        }
        
        // Check if certificate with same name already exists
        if (repo.existsByCertificateName(entity.getCertificateName())) {
            throw new IllegalStateException("Certificate already exists");
        }
       
        entity.setCreatedAt(Instant.now());
        entity.setStatus("ACTIVE"); // Ensure status is set to ACTIVE
        return repo.save(entity);
    }
    
    public List<CertificateEntity> getAllCertificates() {
        return repo.findAll();
    }
    
    public CertificateEntity getActiveCertificateById(String id) {
        Optional<CertificateEntity> certificate = repo.findById(id);
        if (certificate.isPresent() && "ACTIVE".equals(certificate.get().getStatus())) {
            return certificate.get();
        }
        return null;
    }
}