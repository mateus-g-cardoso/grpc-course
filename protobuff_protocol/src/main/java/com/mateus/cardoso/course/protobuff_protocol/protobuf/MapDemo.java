package com.mateus.cardoso.course.protobuff_protocol.protobuf;

import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.BodyStyle;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Car;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Dealer;

import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        var accord = Car.newBuilder()
            .setMake("Honda")
            .setModel("Accord")
            .setBodyStyle(BodyStyle.COUPE)
            .setYear(2020)
            .build();
        var civic = Car.newBuilder()
            .setMake("Honda")
            .setModel("Civic")
            .setBodyStyle(BodyStyle.SEDAN)
            .setYear(2005)
            .build();
        var cars = Map.of(
            2005, civic,
            2020, accord
              );

        var dealer = Dealer.newBuilder()
//            .putModel(2005, civic)
//            .putModel(2020, accord)
            .putAllModel(cars)
            .build();

        System.out.println(
            dealer.getModelOrThrow(2020).getBodyStyle()
                          );
    }
}
