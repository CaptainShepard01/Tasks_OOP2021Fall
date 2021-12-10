package Task7.client;

import Task7.flower.Flower;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger log = Logger.getLogger(Client.class.getName());
    private SocketChannel socketChannel;
    private ByteBuffer buffer;

    public Client(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
        this.buffer = ByteBuffer.allocate(256);
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public static void main(String[] args) {
        Flower flower = new Flower("Troyanda", 25, "USA");
        try {
            new Client(SocketChannel.open(new InetSocketAddress("localhost", 4546))).run(flower);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    public void run(Flower flower) throws IOException {
        sendFlower(flower);
        respondToClient();
    }

    public void sendFlower(Flower flower) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(flower);
        objectOutputStream.flush();
        buffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        socketChannel.write(buffer);
    }

    public void respondToClient() throws IOException {
        ByteBuffer inputBuffer = ByteBuffer.allocate(256);
        socketChannel.read(inputBuffer);
        log.info("Server response: ");
        String response = new String(inputBuffer.array()).trim();
        log.info(response);
        buffer.clear();
    }
}