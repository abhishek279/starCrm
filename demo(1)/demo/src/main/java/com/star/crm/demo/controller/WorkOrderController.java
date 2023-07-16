package com.star.crm.demo.controller;

import com.star.crm.demo.repository.WorkOrderRepository;
import com.star.crm.demo.entity.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/workorders")
public class WorkOrderController {

    @Autowired
    private WorkOrderRepository workOrderRepository;

    @PostMapping("/workOrderNo")
    public void createWorkOrder(@RequestBody WorkOrder workOrder) {
        // Generate random work order number
        workOrder.setWorkOrderNo(generateWorkOrderNumber());

        // Calculate total price
        double totalPrice = workOrder.getAmount();

        // Calculate total balance including sales tax
        double balance = totalPrice + (totalPrice * 0.0113);
        workOrder.setBalance(balance);

        // Save the work order to the database
        workOrderRepository.save(workOrder);
    }
    @GetMapping("/customerName/{customerName}")
    public List<WorkOrder> getWorkOrdersByCustomerName(@PathVariable String customerName) {
        return workOrderRepository.findByCustomerName(customerName);
    }

    @GetMapping("/customerEmail/{customerEmail}")
    public List<WorkOrder> getWorkOrdersByCustomerEmail(@PathVariable String customerEmail) {
        return workOrderRepository.findByCustomerEmail(customerEmail);
    }

    @GetMapping("/billingAddress/{billingAddress}")
    public List<WorkOrder> getWorkOrdersByBillingAddress(@PathVariable String billingAddress) {
        return workOrderRepository.findByBillingAddress(billingAddress);
    }
//    @GetMapping("/workOrderNo/{workOrderNo}")
//    public List<WorkOrder> getWorkOrdersByWorkOrderNo(@PathVariable String workOrderNo) {
//        return workOrderRepository.findByWorkOrderNo(workOrderNo);
//    }
    @GetMapping("/findallWorkOrder")
    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }
    private int generateWorkOrderNumber() {
        // Generate a random number between 1000 and 9999
        return new Random().nextInt(9000) + 1000;
    }
}

