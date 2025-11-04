package com.qcecuring.platform.certificate.dto.mapper;

import com.qcecuring.platform.certificate.model.CertificateEntity;
import com.qcecuring.platform.certificate.dto.request.CertificateRequestDTO;
import com.qcecuring.platform.certificate.dto.response.CertificateResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CertificateMapper {
    public CertificateEntity toEntity(CertificateRequestDTO dto) {
        CertificateEntity entity = new CertificateEntity();
        entity.setCertificateName(dto.certificateName());
        entity.setIssuerName(dto.issuerName());
        entity.setValidFrom(dto.validFrom());
        entity.setValidTo(dto.validTo());
        return entity;
    }
    
    public CertificateResponseDTO toResponse(CertificateEntity entity) {
        return new CertificateResponseDTO(
            entity.getId(),
            entity.getCertificateName(),
            entity.getIssuerName(),
            entity.getValidFrom(),
            entity.getValidTo(),
            entity.getStatus(),
            entity.getCreatedAt()
        );
    }
}