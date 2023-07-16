package com.star.crm.demo.service;

import com.star.crm.demo.entity.Invoice;
import com.star.crm.demo.entity.WorkOrder;
import com.star.crm.demo.repository.InvoiceRepository;
import com.star.crm.demo.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class InvoiceService {
    @Autowired
private WorkOrderRepository workOrderRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;


    public void convertToInvoice(Long workOrderId) throws Exception {
        // Retrieve the work order by its ID
        Optional<WorkOrder> optionalWorkOrder = workOrderRepository.findById(workOrderId);
        if (optionalWorkOrder.isPresent()) {
            WorkOrder workOrder = optionalWorkOrder.get();

            Invoice invoice=new Invoice();

            invoice.setWorkOrderNo(workOrder.getWorkOrderNo());
            invoice.setCustomerName(workOrder.getCustomerName());
            invoice.setCustomerEmail(workOrder.getCustomerEmail());
            invoice.setBillingAddress(workOrder.getBillingAddress());
            invoice.setInvoiceDate(LocalDate.now());
            invoice.setSiteAddress(workOrder.getSiteAddress());
            invoice.setProductDescription(workOrder.getProductDescription());
            invoice.setQuantity(workOrder.getQuantity());
            invoice.setPrice(workOrder.getAmount());
            invoice.setBalance(workOrder.getBalance());


            // Save the updated work order as an workorder to the database
            invoiceRepository.save(invoice);

//            // Delete the work order
//            workOrderRepository.deleteById(workOrderId);
        } else {
            // Handle the case when the work order with the given ID is not found
            throw new Exception("Work order not found");
        }
    }


    public List<Invoice> getInvoicesByCustomerName(String customerName) {
        return invoiceRepository.findByCustomerName(customerName);
    }


    public List<Invoice> getInvoicesByCustomerEmail(String customerEmail) {
        return invoiceRepository.findByCustomerEmail(customerEmail);
    }


}
