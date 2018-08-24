package netty.mahjong.lw.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

public class TestAHandler {
    public TestAHandler() {

    }

    public void back(ChannelHandlerContext ctx, String message) {
        String m = "a方案" + message;
        try {
            ctx.writeAndFlush(getSendByteBuf(m));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private ByteBuf getSendByteBuf(String message)
            throws UnsupportedEncodingException {

        byte[] req = message.getBytes("UTF-8");
        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(req);

        return pingMessage;
    }
}
