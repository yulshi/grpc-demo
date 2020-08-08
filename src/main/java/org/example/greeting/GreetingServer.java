package org.example.greeting;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @author yulshi
 * @create 2020/01/30 13:58
 */
public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(6666).addService(new GreetingService()).build();
        server.start();
        server.awaitTermination();
    }

    public static final class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            HelloResponse helloResponse = HelloResponse.newBuilder().setReply("Aloha " + request.getName()).build();
            responseObserver.onNext(helloResponse);
            responseObserver.onCompleted();
        }
    }

}
