package com.melio.task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("/Users/tamirmayblat/IdeaProjects/melio1/src/main/java/com/melio/task/payment_data.json")), StandardCharsets.UTF_8);

        final ObjectMapper objectMapper = new ObjectMapper();
        List<Transfer> list = objectMapper.readValue(json, new TypeReference<List<Transfer>>(){});
        System.out.println("Found " + list.size() + " transfers in file");

        List<TransferResult.TransferResultContent> contents = new ArrayList<>();
        AtomicReference<Double> total = new AtomicReference<>(0d);
        list.forEach(t-> {
            if(t.getBank() != null && t.getBank().equals("A")) {
                total.getAndSet(total.get() + t.getAmount());
                contents.add(TransferResult.TransferResultContent.ofBankA(t));
            } else {
                System.out.println("Got invalid bank " + t.getBank());
            }
        });
        TransferResult result = new TransferResult(total.get(), contents);
        System.out.println(objectMapper.writeValueAsString(result));
    }
}
