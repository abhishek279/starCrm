package com.star.crm.demo.repository;

import com.star.crm.demo.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    // Add any additional methods as needed
   List<WorkOrder> findByCustomerName(String customerName);

    List<WorkOrder> findByCustomerEmail(String customerEmail);
   List<WorkOrder> findByBillingAddress(String billingAddress);
//   List<WorkOrder> findByWorkOrderNo(String workOrderNo);
}
