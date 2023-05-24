package com.mateus.cardoso.course.grpccourse.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mateus.cardoso.course.grpccourse.grpc.lib.Person;
import com.mateus.cardoso.course.grpccourse.json.JPerson;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {
        // JSON
        var person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        var mapper = new ObjectMapper();

        Runnable runnableJson = () -> {
            try {
                var bytes = mapper.writeValueAsBytes(person);
                var person1 = mapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // Protobuf
        var sam = Person.newBuilder()
            .setName("sam")
            .setAge(10)
            .build();

        Runnable runnableProtobuf = () -> {
            try {
                var bytes = sam.toByteArray();
                var sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(runnableProtobuf, "PROTO");
            runPerformanceTest(runnableJson, "JSON");
            System.out.println("-----------");
        }
    }

    private static void runPerformanceTest(final Runnable runnable, final String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
