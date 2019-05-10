/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameClient {
    
    public static void main(String [] args) throws InterruptedException, IOException{
        new GameClient("localhost", 1234).run();
    }
    
    
    private final String host;
    private final int port;
    
    //constructor
    public GameClient(String host, int port){
        this.host = host;
        this.port = port;
    }
    
    public void run() throws InterruptedException, IOException{
        EventLoopGroup group = new NioEventLoopGroup();
        
        try{
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new GameClientInitializer());
            
            Channel channel = bootstrap.connect(host,port).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            while(true){
                channel.write(in.readLine() + "\r\n" );  // send message to all clients
            }
        }
        finally {
            group.shutdownGracefully();
        }
    }
    
}
