package com.sinan.server;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ByteProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class CustomClient {

    private static final Logger logger = LoggerFactory.getLogger(CustomClient.class);

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;
    private static final int LENGTH_FIELD_LENGTH = 4;
    private static final int LENGTH_FIELD_OFFSET = 2;
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8080"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new CustomDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,false));
//                            ch.pipeline().addLast(new CustomEncoder());
                            ch.pipeline().addLast(new CustomClientHandler());
//                            ch.pipeline().addLast(new CustomClientHandler1());
//                            ch.pipeline().addLast(new CustomClientHandler2());
                        }
                    });

            ChannelFuture future = b.connect(HOST, PORT).sync();
//            CustomMsg msg = new CustomMsg((byte)0xAB, (byte)0xCD, "Hello Netty Server ,I am a common client".length(), "Hello Netty Server ,I am a common client");
//            ByteBuf out = Unpooled.buffer();
//            String body = msg.getBody();
//            byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
//            out.writeByte(msg.getType());
//            out.writeByte(msg.getFlag());
//            out.writeInt(bodyBytes.length);
//            out.writeBytes(bodyBytes);
//            future.channel().writeAndFlush(msg);
            logger.info("first{}", "in first");
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
