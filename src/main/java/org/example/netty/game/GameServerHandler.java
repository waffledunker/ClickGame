/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameServerHandler extends ChannelInboundMessageHandlerAdapter<String> {

    private static final ChannelGroup channels = new DefaultChannelGroup();
    
    @Override 
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
         System.out.println("Client : " + incoming.remoteAddress() + " has connected!" );
        for (Channel channel : channels){
            
            channel.write("[Server] : " + incoming.remoteAddress() + " has joined! \n");
        }
        channels.add(ctx.channel());
    }
    
    @Override
    public void handlerRemoved (ChannelHandlerContext ctx) throws Exception {
        
        Channel incoming = ctx.channel();
        for (Channel channel : channels){
            channel.write("[Server] : " + incoming.remoteAddress() + " has left! \n");
        }
        channels.remove(ctx.channel());
    }
    
    
    
    @Override
    public void messageReceived(ChannelHandlerContext arg0, String message) throws Exception{
        Channel incoming = arg0.channel();
        
        GameCommands gs = new GameCommands();
        gs.parseMessage(message);  // parse message coming from clients
        
        for (Channel channel : channels){  // server - client communication
            
                
            
                if(channel != incoming){
                
                        channel.write("[ " + incoming.remoteAddress() + "]:" + "["+ message +"]"+ "\n" );  // print message to client screen except sender's
                        System.out.println("[" + incoming.remoteAddress() + "]:" + "["+ message +"]"+ "\n" );
                }
                
            
            
        }
    }
    
}
