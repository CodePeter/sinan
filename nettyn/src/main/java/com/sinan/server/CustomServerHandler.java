package com.sinan.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class CustomServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server Side: ");
        if (msg instanceof ByteBuf) {
//            Byte b1 = ((ByteBuf) msg).re
//            System.out.println(new String(b1));
            ByteBuf buf = ((ByteBuf)msg);
            int length = buf.readInt();
//            ByteBuf buf = ((ByteBuf)msg).readBytes(11);
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println(body);
        }
//        ByteBuf buf1 = (ByteBuf) ctx.read();
//        ByteBuf buf2 = (ByteBuf) ctx.read();
//        ByteBuf buf3 = (ByteBuf) ctx.read();
//        System.out.println(buf1.toString(CharsetUtil.UTF_8));
//        System.out.println(buf2.toString(CharsetUtil.UTF_8));
//        System.out.println(buf3.toString(CharsetUtil.UTF_8));
//        if(msg instanceof CustomMsg) {
//            CustomMsg customMsg = (CustomMsg)msg;
//            System.out.println("Client->Server:"+ctx.channel().remoteAddress()+" send "+customMsg.getBody());
//            customMsg.setBody("response messgae");
//            ctx.channel().writeAndFlush(customMsg);
//        }

//        ByteBuf in = (ByteBuf) msg;
//        System.out.println("Server: " + in.toString(CharsetUtil.UTF_8));
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
    }

}
