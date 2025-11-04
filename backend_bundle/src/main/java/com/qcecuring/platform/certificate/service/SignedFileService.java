package com.qcecuring.platform.certificate.service;

import org.springframework.stereotype.Service;
import com.qcecuring.platform.certificate.repository.SignedFileRepository;
import com.qcecuring.platform.certificate.model.SignedFileEntity;
import com.qcecuring.platform.certificate.service.CertificateService;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
public class SignedFileService {
    private final SignedFileRepository signedFileRepository;
    private final CertificateService certificateService;
    
    // Constructor for dependency injection
    public SignedFileService(SignedFileRepository signedFileRepository, CertificateService certificateService) {
        this.signedFileRepository = signedFileRepository;
        this.certificateService = certificateService;
    }

    public SignedFileEntity signFile(String fileName, String certificateId) {
        Objects.requireNonNull(fileName, "File name is required");
        Objects.requireNonNull(certificateId, "Certificate ID is required");

        // Verify that the certificate exists and is active
        var certificate = certificateService.getActiveCertificateById(certificateId);
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate not found or not active");
        }

        // Create a new signed file record
        SignedFileEntity signedFile = new SignedFileEntity();
        signedFile.setFileName(fileName);
        signedFile.setCertificateId(certificateId);
        signedFile.setCertificateName(certificate.getCertificateName());
        signedFile.setSignedAt(Instant.now());
        signedFile.setStatus("SIGNED");

        return signedFileRepository.save(signedFile);
    }

    public List<SignedFileEntity> getAllSignedFiles() {
        return signedFileRepository.findAll();
    }
}