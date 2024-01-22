package com.example.calculatebatchsystem.batch.generator;

import com.example.calculatebatchsystem.batch.domain.ApiOrder;
import com.example.calculatebatchsystem.batch.domain.ServicePolicy;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

@Component
public class ApiOrderGenerateProcessor implements ItemProcessor<Boolean, ApiOrder> {

    private final List<Long> customerIdList = LongStream.range(0,20).boxed().toList();
    private final List<ServicePolicy> servicePolicyList = Arrays.stream(ServicePolicy.values()).toList();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Override
    public ApiOrder process(Boolean item) throws Exception {

        final Long randomCustomerId = customerIdList.get(random.nextInt(customerIdList.size()));
        final ServicePolicy randomServicePolicy = servicePolicyList.get(random.nextInt(servicePolicyList.size()));
        final ApiOrder.State randomState = random.nextInt(5) % 5 == 1 ? ApiOrder.State.FAIL : ApiOrder.State.SUCCESS;


        return new ApiOrder(
                UUID.randomUUID().toString(),
                randomCustomerId,
                randomServicePolicy.getUrl(),
                randomState,
                LocalDateTime.now().format(dateTimeFormatter)

        );
    }
}
