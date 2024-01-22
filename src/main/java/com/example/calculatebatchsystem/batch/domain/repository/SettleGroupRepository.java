package com.example.calculatebatchsystem.batch.domain.repository;

import com.example.calculatebatchsystem.batch.domain.SettleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SettleGroupRepository extends JpaRepository<SettleGroup,Long>{

    @Query(
            value = """
                    SELECT new SettleGroup(detail.customerId, detail.serviceId, sum(detail.count), sum(detail.fee))
                    FROM SettleDetail detail
                    WHERE detail.targetDate BETWEEN :start and :end
                    AND detail.customerId = :customerId
                    GROUP BY detail.customerId, detail.serviceId
                    """)
    List<SettleGroup> findGroupByCustomerIdAndServiceId(LocalDate start, LocalDate end, Long customerId);
}
