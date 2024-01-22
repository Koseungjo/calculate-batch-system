package com.example.calculatebatchsystem.batch.detail;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
class SettleDetailReader implements ItemReader<KeyAndCount>, StepExecutionListener {
    private Iterator<Map.Entry<Key, Long>> iterator;
    @Override
    public KeyAndCount read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (!iterator.hasNext())
            return null;

        Map.Entry<Key, Long> map = iterator.next();
        return new KeyAndCount(map.getKey(), map.getValue());
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        final JobExecution jobExecution = stepExecution.getJobExecution();
        final Map<Key, Long> snapshots = (ConcurrentHashMap<Key, Long>) jobExecution.getExecutionContext().get("snapShots");
        this.iterator = snapshots.entrySet().iterator();
    }
}
