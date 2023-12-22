package com.training.project.Traingproject.serviceimpl;

import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.project.Traingproject.Dao.CustomerRepository;
import com.training.project.Traingproject.Entity.Customer;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void uploadDocument(Long customerId, MultipartFile document) throws BusinessException {
        try {
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new BusinessException("Customer not found with ID: " + customerId));


            Document savedDocument = saveDocumentDetails(customer, document);

            saveDocumentFile(savedDocument, document);

        } catch (Exception e) {
            throw new BusinessException("Error occurred while uploading document", e);
        }
    }


    private Document saveDocumentDetails(Customer customer, MultipartFile document) {
		return null;
    }

    private void saveDocumentFile(Document document, MultipartFile file) {
    }
}

