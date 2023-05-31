package com.mateus.cardoso.course.grpc.grpcintro.server;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        final var server = ServerBuilder.forPort(6565)
            .addService(new BankService())
            .build();

        server.start();
        System.out.println("Server Running");
        server.awaitTermination();
    }
}
