package com.example.warehouse_be.network;

import com.example.warehouse_be.entity.Board;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Utility class for sending UDP packets.
 */
public class UDPClient {

    /**
     * Sends a UDP packet.
     *
     * @param boardConfig The board configuration containing IP and port.
     * @param data        The byte array data to send.
     * @throws Exception if sending fails.
     */
    public static void send(Board boardConfig, byte[] data) throws Exception {
        // Log the packet content for debugging
        System.out.println("Sending UDP packet to " + boardConfig.getIp() + ":" + boardConfig.getPort());
        System.out.println("Packet HEX: " + bytesToHex(data));

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(boardConfig.getIp());
            DatagramPacket packet = new DatagramPacket(data, data.length, address, boardConfig.getPort());
            socket.send(packet);
        }
    }

    // Helper method to convert byte array to hex string for logging
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}
