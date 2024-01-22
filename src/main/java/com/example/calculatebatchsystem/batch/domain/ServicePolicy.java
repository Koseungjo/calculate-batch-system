package com.example.calculatebatchsystem.batch.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ServicePolicy {
    A(1L, "/rhtmdwh/service/a", 10),
    B(2L, "/rhtmdwh/service/b", 10),
    C(3L, "/rhtmdwh/service/c", 10),
    D(4L, "/rhtmdwh/service/d", 15),
    E(5L, "/rhtmdwh/service/e", 15),
    F(6L, "/rhtmdwh/service/f", 10),
    G(7L, "/rhtmdwh/service/g", 10),
    H(8L, "/rhtmdwh/service/h", 10),
    I(9L, "/rhtmdwh/service/i", 10),
    J(10L, "/rhtmdwh/service/j", 10),
    K(11L, "/rhtmdwh/service/k", 10),
    L(12L, "/rhtmdwh/service/l", 10),
    M(13L, "/rhtmdwh/service/m", 10),
    N(14L, "/rhtmdwh/service/n", 10),
    O(15L, "/rhtmdwh/service/o", 10),
    P(16L, "/rhtmdwh/service/p", 10),
    Q(17L, "/rhtmdwh/service/q", 10),
    R(18L, "/rhtmdwh/service/r", 10),
    S(19L, "/rhtmdwh/service/s", 10),
    T(20L, "/rhtmdwh/service/t", 10),
    U(21L, "/rhtmdwh/service/u", 10),
    V(22L, "/rhtmdwh/service/v", 10),
    W(23L, "/rhtmdwh/service/w", 19),
    X(24L, "/rhtmdwh/service/x", 19),
    Y(25L, "/rhtmdwh/service/y", 19),
    Z(26L, "/rhtmdwh/service/z", 19)
    ;
    private final Long id;
    private final String url;
    private final Integer fee;

    ServicePolicy(Long id, String url, Integer fee) {
        this.id = id;
        this.url = url;
        this.fee = fee;
    }

    public static ServicePolicy findByUrl(String url) {
        return Arrays.stream(values())
                .filter(it -> it.url.equals(url))
                .findFirst()
                .orElseThrow();
    }

    public static ServicePolicy findById(Long id){
        return Arrays.stream(values())
                .filter(it -> it.id.equals(id))
                .findFirst()
                .orElseThrow();
    }
}
