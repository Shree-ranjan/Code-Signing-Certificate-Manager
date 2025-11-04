package com.qcecuring.platform.certificate.dto.response;

import java.time.Instant;
import java.time.LocalDate;

public record CertificateResponseDTO(
    String id,
    String certificateName,
    String issuerName,
    LocalDate validFrom,
    LocalDate validTo,
    String status,
    Instant createdAt
) {}