/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel arg0) throws Exception {
      
      ChannelPipeline pipeline = arg0.pipeline();
      
      pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
      pipeline.addLast("decoder", new StringDecoder());
      pipeline.addLast("encoder", new StringEncoder());
      
      pipeline.addLast("handler", new GameServerHandler());
  }
    
}
