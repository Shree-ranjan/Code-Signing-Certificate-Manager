package com.qcecuring.platform.certificate.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record CertificateRequestDTO(
    String id,
    @NotBlank String certificateName,
    @NotBlank String issuerName,
    LocalDate validFrom,
    LocalDate validTo
) {}