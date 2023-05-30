package com.mateus.cardoso.course.protobuff_protocol.protobuf;

import com.google.protobuf.Int32Value;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Address;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Car;
import com.mateus.cardoso.course.protobuff_protocol.grpc.lib.Person;

import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        var address = Address.newBuilder()
            .setPostbox(123)
            .setStreet("main street")
            .setCity("Atlanta")
            .build();

        var accord = Car.newBuilder()
            .setMake("Honda")
            .setModel("Accord")
            .setYear(2020)
            .build();
        var civic = Car.newBuilder()
            .setMake("Honda")
            .setModel("Civic")
            .setYear(2005)
            .build();
        var cars = List.of(accord, civic);

        var sam = Person.newBuilder()
            .setName("sam")
            .setAge(Int32Value.newBuilder()
                .setValue(25)
                .build())
            .addAllCar(cars)
//            .addCar(accord)
//            .addCar(civic)
            .setAddress(address)
            .build();

        System.out.println(
            sam
                          );
    }

}
