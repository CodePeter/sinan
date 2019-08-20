package com.sinan.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ByteBufTest {
    public static void main(String[] args) {
//        ByteBuf unpooledBuf = Unpooled.buffer();
////        ByteBuf pooledBuf = new PooledByteBufAllocator();
////        unpooledBuf.writeInt(369);
//        unpooledBuf.writeByte(0xAB);
//        unpooledBuf.writeBytes("Hello".getBytes());
//        unpooledBuf.writeBytes("World".getBytes());
////        unpooledBuf.writeLong(963L);
//        unpooledBuf.writeByte(0xCD);
//
////        unpooledBuf.readByte();
//        System.out.println(new String(unpooledBuf.skipBytes(1).array(), Charset.forName("utf-8")));

        System.out.println(Integer.MAX_VALUE);
    }
}
