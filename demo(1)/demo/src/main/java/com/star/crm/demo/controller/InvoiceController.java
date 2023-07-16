package com.star.crm.demo.controller;

import com.star.crm.demo.entity.Invoice;
import com.star.crm.demo.entity.WorkOrder;
import com.star.crm.demo.repository.InvoiceRepository;
import com.star.crm.demo.repository.WorkOrderRepository;
import com.star.crm.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
   private InvoiceService invoiceService;
    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;


    @PostMapping("/convertToInvoice/{workOrderId}")
    public void convertToInvoice(@PathVariable Long workOrderId) throws Exception {
        // Retrieve the work order by its ID
        invoiceService.convertToInvoice(workOrderId);
    }

    @GetMapping("/customerName/{customerName}")
    public List<Invoice> getInvoicesByCustomerName(@PathVariable String customerName) {
        return invoiceService.getInvoicesByCustomerName(customerName);
    }

    @GetMapping("/customerEmail/{customerEmail}")
    public List<Invoice> getInvoicesByCustomerEmail(@PathVariable String customerEmail) {
        return invoiceService.getInvoicesByCustomerEmail(customerEmail);
    }

    // Implement additional methods to retrieve invoices by other variables if needed
}

