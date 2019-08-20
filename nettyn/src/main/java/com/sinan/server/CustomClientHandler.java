package com.sinan.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class CustomClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        CustomMsg customMsg = new CustomMsg((byte)0xAB, (byte)0xCD, "Hello,Netty".length(), "Hello,Netty");
//        ctx.writeAndFlush(customMsg);
//        ctx.fireChannelRead(customMsg);
//        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
//        ctx.writeAndFlush("Test Data");

        ctx.write(Unpooled.copyInt(11));
        ctx.write(Unpooled.copyInt(22));
        ctx.write(Unpooled.copiedBuffer("One", CharsetUtil.UTF_8));
        ctx.write(Unpooled.copiedBuffer("Two", CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("Three", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client Side:");
//        ByteBuf buf1 = (ByteBuf) ctx.read();
//        ByteBuf buf2 = (ByteBuf) ctx.read();
//        ByteBuf buf3 = (ByteBuf) ctx.read();
//        System.out.println(buf1.toString(CharsetUtil.UTF_8));
//        System.out.println(buf2.toString(CharsetUtil.UTF_8));
//        System.out.println(buf3.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
//        if (msg instanceof CustomMsg) {
//            System.out.println("response: "+((CustomMsg) msg).getBody());
//            ctx.writeAndFlush(msg);
//        }
//        ctx.fireChannelRead(msg);
//        if (msg instanceof ByteBuf) {
//            ByteBuf in = (ByteBuf)msg;
//            System.out.println("Client: "+ in.toString(CharsetUtil.UTF_8));
//            ctx.writeAndFlush(msg);
//        } else {
//            System.out.println("Wrong");
//        }
    }

}
