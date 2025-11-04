package com.qcecuring.platform.certificate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.qcecuring.platform.certificate.model.CertificateEntity;
import java.util.Optional;

public interface CertificateRepository extends MongoRepository<CertificateEntity, String> {
    boolean existsByCertificateName(String certificateName);
    Optional<CertificateEntity> findById(String id);
}