package com.sinan.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

public class CustomServerHandler2 extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }
}
