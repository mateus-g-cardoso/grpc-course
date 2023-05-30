package com.mateus.cardoso.course.protobuff_protocol.protobuf;

import com.google.protobuf.Int32Value;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args){
        var sam1 = Person.newBuilder()
            .setName("sam")
            .setAge(Int32Value.newBuilder()
                .setValue(25)
                .build())
            .build();


        var path = Paths.get("sam.ser");
        try {
            Files.write(path, sam1.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        var bytes = Files.readAllBytes(path);
//        var newSam = Person.parseFrom(bytes);

//        System.out.println(
//            newSam
//                          );
    }
}
