package com.example.calculatebatchsystem.batch.group;

import com.example.calculatebatchsystem.batch.domain.Customer;
import com.example.calculatebatchsystem.batch.domain.SettleGroup;
import com.example.calculatebatchsystem.batch.domain.repository.SettleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SettleGroupProcessor implements ItemProcessor<Customer, List<SettleGroup>>, StepExecutionListener {

    private StepExecution stepExecution;
    private final SettleGroupRepository settleGroupRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    @Override
    public List<SettleGroup> process(Customer item) throws Exception {
        final String targetDate = stepExecution.getJobParameters().getString("targetDate");
        final LocalDate end = LocalDate.parse(targetDate, dateTimeFormatter);
        return settleGroupRepository.findGroupByCustomerIdAndServiceId(
                end.minusDays(6),
                end,
                item.getId()
        );
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
}
