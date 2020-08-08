package org.example.greeting;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author yulshi
 * @create 2020/01/30 14:03
 */
public class GreetingClient {

    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forTarget("localhost:6666").usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub = GreetingServiceGrpc.newBlockingStub(channel);
        HelloResponse response = blockingStub.sayHello(HelloRequest.newBuilder().setName("Jimmyyyy").build());
        System.out.println(response.getReply());
    }
}
