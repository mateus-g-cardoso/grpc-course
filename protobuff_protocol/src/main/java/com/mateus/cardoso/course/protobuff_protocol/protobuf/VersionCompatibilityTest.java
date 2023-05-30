package com.mateus.cardoso.course.protobuff_protocol.protobuf;

import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {
        var pathV1 = Paths.get("tv-v1");
        var pathV2 = Paths.get("tv-v2 ");

//        var television = Television.newBuilder()
//            .setBrand("sony")
//            .setModel(1016)
//            .setType(Type.OLED)
//            .build();
//        Files.write(pathV2, television.toByteArray());

        //
        var bytes = Files.readAllBytes(pathV1);
        System.out.println(
            Television.parseFrom(bytes)
                          );
    }
}
