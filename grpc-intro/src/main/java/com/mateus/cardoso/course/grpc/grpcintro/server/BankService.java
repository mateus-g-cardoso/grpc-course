package com.mateus.cardoso.course.grpc.grpcintro.server;

import com.mateus.cardoso.course.grpc.grpcintro.lib.grpc.Balance;
import com.mateus.cardoso.course.grpc.grpcintro.lib.grpc.BalanceCheckRequest;
import com.mateus.cardoso.course.grpc.grpcintro.lib.grpc.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getBalance(final BalanceCheckRequest request, final StreamObserver<Balance> responseObserver) {
        final var accountNumber = request.getAccountNumber();
        final var balance = Balance.newBuilder()
            .setAmount(accountNumber * 10)
            .build();

        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }

}
