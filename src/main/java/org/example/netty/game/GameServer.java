/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameServer {
    
    public static void main (String[] args) throws InterruptedException{
         new MainScreen();
        
        new GameServer(1234).run();
    }
    
    private final int port;
    
    public GameServer(int port){
        this.port = port;
    }

    
    
    public void run() throws InterruptedException{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try{
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new GameServerInitializer());
            
            bootstrap.bind(port).sync().channel().closeFuture().sync();
            
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
