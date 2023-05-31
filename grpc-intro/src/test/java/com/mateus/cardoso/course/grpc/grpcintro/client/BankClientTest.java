package com.mateus.cardoso.course.grpc.grpcintro.client;

import com.mateus.cardoso.course.grpc.grpcintro.lib.grpc.BalanceCheckRequest;
import com.mateus.cardoso.course.grpc.grpcintro.lib.grpc.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    void setter() {
        var channel = ManagedChannelBuilder
            .forAddress("localhost", 6565)
            .usePlaintext()
            .build();
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @Test
    void balanceTest() {
        var balanceCheckRequest = BalanceCheckRequest
            .newBuilder()
            .setAccountNumber(7)
            .build();

        var balance = blockingStub.getBalance(balanceCheckRequest);

        System.out.println(
            "Received: " + balance.getAmount()
                          );
    }
}
