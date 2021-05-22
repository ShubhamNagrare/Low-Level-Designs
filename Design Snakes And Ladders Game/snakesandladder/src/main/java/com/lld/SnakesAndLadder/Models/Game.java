package com.lld.SnakesAndLadder.Models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Game {
	
	private int noOfSnakes;
	private int noOfLadders;
	
	private Queue<Player> players;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	
	private Board board;
	private Dice dice;
	
	public Game(int noOfSnakes, int noOfLadders, int boardSize) {
		this.noOfSnakes = noOfSnakes;
		this.noOfLadders = noOfLadders;
		
		players = new ArrayDeque<Player>();
		snakes = new ArrayList<Snake>(noOfSnakes);
		ladders = new ArrayList<Ladder>(noOfLadders);
		
		board = new Board(boardSize);
		dice = new Dice(1,6,2);
		
		initBoard();
	}
	
	private void initBoard() {
		
		Set<String> sl = new HashSet<String>();
		Random rand = new Random();
		
		for(int i=0; i<noOfSnakes; i++) {
			while(true) {
				
				int snakeStart = rand.nextInt(board.getSize()) + 1;			
				int snakeEnd = rand.nextInt(board.getSize()) + 1;			
				if(snakeEnd >= snakeStart) 
					continue;
				
				String startEndPair = String.valueOf(snakeStart) + snakeEnd;				
				if(!sl.contains(startEndPair)) {					
					Snake snake = new Snake(snakeStart, snakeEnd);
					snakes.add(snake);
					sl.add(startEndPair);
					break;
				}				
			}
		}
		
		for(int i=0; i<noOfLadders; i++) {
			while(true) {
				
				int ladderStart = rand.nextInt(board.getSize()) + 1;
				int ladderEnd = rand.nextInt(board.getSize()) + 1;
				
				if(ladderEnd  <= ladderStart)
					continue;
				
				String ladderStartEnd = String.valueOf(ladderStart) + ladderEnd;				
				if(!sl.contains(ladderStartEnd)) {
					Ladder ladder = new Ladder(ladderStart, ladderEnd);
					ladders.add(ladder);
					sl.add(ladderStartEnd);
					break;
				}
				
			}
		}	
	}
	
	public void addPlayers(Player player) {
		players.add(player);
	}
	
	
	private int getNewPosition(int pos) {
		
		for(Snake snake : snakes ) {
			if(pos == snake.getHead()) {
				System.out.println("Snake Bit");
				return snake.getTail();
			}
		}
		
		for(Ladder ladder : ladders) {
			if(ladder.getTail() == pos) {
				System.out.println("Ladder Climbed");
				return ladder.getHead();
			}
		}
		return pos;
	}
	
	public void playGame() {
		
		while(true) {
			
			Player player = players.poll();
			int newPosition = player.getPosition() + dice.roll();
			
			if(newPosition > board.getEnd()) {
				player.setPosition(player.getPosition());
				players.offer(player);
			}
			else {
				
				player.setPosition(getNewPosition(newPosition));
				
				if(player.getPosition() == board.getEnd()) {
					player.setWon(true);
					System.out.println();
					System.out.println("Player " + player.getName() + " WON !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + player.getPosition());
					System.out.println();
				}
				else {
					System.out.println();
					System.out.println("Player " + player.getName() + " stepping to " + newPosition );
					System.out.println();
					players.offer(player);
				}			
			}
		if(players.size() < 2) {
			break;
		}
	  }
	}

}
