package com.qcecuring.platform.certificate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;

@Document(collection = "certificates")
public class CertificateEntity {
    @Id
    private String id;
    private String certificateName;
    private String issuerName;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Instant createdAt;
    private String status;

    // Constructors
    public CertificateEntity() {
        this.status = "ACTIVE"; // Set default status to ACTIVE
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCertificateName() { return certificateName; }
    public void setCertificateName(String certificateName) { this.certificateName = certificateName; }
    
    public String getIssuerName() { return issuerName; }
    public void setIssuerName(String issuerName) { this.issuerName = issuerName; }
    
    public LocalDate getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDate validFrom) { this.validFrom = validFrom; }
    
    public LocalDate getValidTo() { return validTo; }
    public void setValidTo(LocalDate validTo) { this.validTo = validTo; }
    
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}