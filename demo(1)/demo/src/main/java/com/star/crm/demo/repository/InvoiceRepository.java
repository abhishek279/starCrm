package com.star.crm.demo.repository;

import com.star.crm.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomerName(String customerName);

    List<Invoice> findByCustomerEmail(String customerEmail);

    // Add any additional methods as needed
}