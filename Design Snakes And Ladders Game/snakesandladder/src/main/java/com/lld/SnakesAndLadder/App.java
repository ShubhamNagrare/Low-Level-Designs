package com.lld.SnakesAndLadder;

import java.util.Scanner;

import com.lld.SnakesAndLadder.Models.Game;
import com.lld.SnakesAndLadder.Models.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "LET START SNAKES AND LADDER GAME !!" );
        System.out.println();
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Board Size");
        int boardSize = sc.nextInt();
        
        System.out.println("Enter No. of Players");
        int noOfPlayers = sc.nextInt();
        
        System.out.println("Enter No. of SNakes");
        int noOfSnakes = sc.nextInt();
        
        System.out.println("Enter No. od Ladders");
        int noOfLadders = sc.nextInt();
        
        sc.nextLine();
        System.out.println("Select Players Now");
        Game game = new Game(noOfSnakes, noOfLadders, boardSize);
        System.out.println();
        System.out.println("Select Players Now");
        for(int i=0; i<noOfPlayers; i++) {
        	
        	System.out.println("Enter Player Name");
            String pName = sc.nextLine();
            
        	Player player = new Player(pName);
        	game.addPlayers(player);
        }
        
        game.playGame();
          
    }
}
