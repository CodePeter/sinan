package com.sinan.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class CustomClientHandler2 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CustomMsg) {
            System.out.println("2: "+((CustomMsg) msg).getBody());
        }
//        ctx.fireChannelRead(msg);
//        ctx.writeAndFlush(msg);
    }

}
