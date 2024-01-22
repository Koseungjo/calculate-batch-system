package com.example.calculatebatchsystem.batch.support;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

public interface EmailProvider {

    void send(String emailAddress, String title, String content);

    @Slf4j
    class Fake implements EmailProvider {

        @Override
        public void send(String emailAddress, String title, String content) {
            log.info("{} email 전송 완료 ! \n {} \n {}", emailAddress, title, content);
        }
    }
}
