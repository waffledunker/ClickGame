/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 *
 * @author alpalpalapalallapala
 */

public class GameClientHandler extends ChannelInboundMessageHandlerAdapter<String> {

    @Override
    public void messageReceived(ChannelHandlerContext arg0, String arg1) throws Exception{  
        
        System.out.println(arg1);  // incoming message print to screen
    }
    
}
