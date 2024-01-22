package com.example.calculatebatchsystem.batch.support;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class DateFormatJobParametersValidator implements JobParametersValidator {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private final String[] names;

    public DateFormatJobParametersValidator(String[] names) {
        this.names = names;
    }

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        for (String name: names){
            validateFormat(parameters, name);
        }
    }

    private void validateFormat(JobParameters parameters, String name) throws JobParametersInvalidException {
        try {
            String tmpName = parameters.getString(name);
            LocalDate.parse(Objects.requireNonNull(tmpName), dateTimeFormatter);
        } catch (Exception e){
            throw new JobParametersInvalidException("yyyyMMdd 형식만을 지원합니다.");
        }
    }
}
