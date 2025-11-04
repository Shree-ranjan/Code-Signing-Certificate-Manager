package com.qcecuring.platform.certificate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.qcecuring.platform.certificate.model.SignedFileEntity;
import java.util.List;

public interface SignedFileRepository extends MongoRepository<SignedFileEntity, String> {
    List<SignedFileEntity> findAll();
}