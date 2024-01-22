package com.example.calculatebatchsystem.batch.detail;

import com.example.calculatebatchsystem.batch.domain.ApiOrder;
import com.example.calculatebatchsystem.batch.domain.ServicePolicy;
import org.springframework.batch.item.ItemProcessor;

public class PreSettleDetailProcessor implements ItemProcessor<ApiOrder, Key> {
    @Override
    public Key process(ApiOrder item) throws Exception {
        if (item.getState() == ApiOrder.State.FAIL)
            return null;

        final Long serviceId = ServicePolicy.findByUrl(item.getUrl()).getId();

        return new Key(item.getCustomerId(), serviceId);
    }
}
