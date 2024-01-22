package com.example.calculatebatchsystem.batch.domain.repository;

import com.example.calculatebatchsystem.batch.domain.Customer;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository {

    List<Customer> findAll(Pageable pageable);


    Customer findById(Long id);

    class Fake implements CustomerRepository {

        @Override
        public List<Customer> findAll(Pageable pageable) {
            if (pageable.getPageNumber() == 0) {
                return List.of(
                        new Customer(0L, "A사", "A@namver.com"),
                        new Customer(1L, "B사", "B@namver.com"),
                        new Customer(2L, "C사", "C@namver.com"),
                        new Customer(3L, "D사", "D@namver.com"),
                        new Customer(4L, "E사", "E@namver.com"),
                        new Customer(5L, "F사", "F@namver.com"),
                        new Customer(6L, "G사", "G@namver.com"),
                        new Customer(7L, "H사", "H@namver.com"),
                        new Customer(8L, "I사", "I@namver.com"),
                        new Customer(9L, "J사", "J@namver.com")
                );
            } else if (pageable.getPageNumber() == 1) {
                return List.of(
                        new Customer(10L, "0사", "0@namver.com"),
                        new Customer(11L, "1사", "1@namver.com"),
                        new Customer(12L, "2사", "2@namver.com"),
                        new Customer(13L, "3사", "3@namver.com"),
                        new Customer(14L, "4사", "4@namver.com"),
                        new Customer(15L, "5사", "5@namver.com"),
                        new Customer(16L, "6사", "6@namver.com"),
                        new Customer(17L, "7사", "7@namver.com"),
                        new Customer(18L, "8사", "8@namver.com"),
                        new Customer(19L, "9사", "9@namver.com")
                );
            } else {
                return Collections.emptyList();
            }
        }

        @Override
        public Customer findById(Long id) {
            return Stream.of(
                            new Customer(0L, "A사", "A@namver.com"),
                            new Customer(1L, "B사", "B@namver.com"),
                            new Customer(2L, "C사", "C@namver.com"),
                            new Customer(3L, "D사", "D@namver.com"),
                            new Customer(4L, "E사", "E@namver.com"),
                            new Customer(5L, "F사", "F@namver.com"),
                            new Customer(6L, "G사", "G@namver.com"),
                            new Customer(7L, "H사", "H@namver.com"),
                            new Customer(8L, "I사", "I@namver.com"),
                            new Customer(9L, "J사", "J@namver.com"),
                            new Customer(10L, "0사", "0@namver.com"),
                            new Customer(11L, "1사", "1@namver.com"),
                            new Customer(12L, "2사", "2@namver.com"),
                            new Customer(13L, "3사", "3@namver.com"),
                            new Customer(14L, "4사", "4@namver.com"),
                            new Customer(15L, "5사", "5@namver.com"),
                            new Customer(16L, "6사", "6@namver.com"),
                            new Customer(17L, "7사", "7@namver.com"),
                            new Customer(18L, "8사", "8@namver.com"),
                            new Customer(19L, "9사", "9@namver.com")
                    ).filter(it -> it.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
