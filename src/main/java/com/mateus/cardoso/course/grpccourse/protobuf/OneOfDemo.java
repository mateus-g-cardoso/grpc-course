package com.mateus.cardoso.course.grpccourse.protobuf;

import com.mateus.cardoso.course.grpccourse.grpc.lib.Credentials;
import com.mateus.cardoso.course.grpccourse.grpc.lib.EmailCredentials;
import com.mateus.cardoso.course.grpccourse.grpc.lib.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        final var emailCredentials = EmailCredentials.newBuilder()
            .setEmail("tst@tst.tst")
            .setPassword("adminadmin")
            .build();
        final var phoneCredentials = PhoneOTP.newBuilder()
            .setNumber(123123123)
            .setCode(4455)
            .build();

        final var credentials = Credentials.newBuilder()
            .setEmailMode(emailCredentials)
            .setPhoneMode(phoneCredentials)
            .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE -> System.out.println(credentials.getEmailMode());
            case PHONEMODE -> System.out.println(credentials.getPhoneMode());
        }
    }
}
