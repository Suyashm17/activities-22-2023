package com.training.project.Traingproject.Services;

import org.springframework.web.multipart.MultipartFile;

import com.training.project.Traingproject.Excepton.BusinessException;

public interface DocumentService {
    void uploadDocument(Long customerId, MultipartFile document) throws BusinessException;
}

