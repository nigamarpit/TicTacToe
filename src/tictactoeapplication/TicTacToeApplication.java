/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;
import java.util.Scanner;
/**
 *
 * @author arpit
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //getting input
        Scanner sc=new Scanner(System.in);
        boolean doYouWantToPlay=true;
        while(doYouWantToPlay){
            //Set tokens and AI
            System.out.println("Welcome to Tic Tac Toe!");
            System.out.println("Please pick character you want to be");
            char playerToken=sc.next().charAt(0);
            System.out.println("Enter a single character for your opponent");
            char opponentToken=sc.next().charAt(0);
            TicTacToe game=new TicTacToe(playerToken, opponentToken);
            AI ai=new AI();
            //Set up the game
            System.out.println();
            System.out.println("Now, Lets start the game.\n Enter a number and your character will be placed in its position\n. Number grow from 0 to 9, left to right.\n");
            TicTacToe.printIndexBoard();
            System.out.println();
            while(game.gameOver().equals("not over")){
                if(game.currentMarker==game.userMarker){
                    System.out.println("Its your turn! Enter a spot for character");
                    int spot=sc.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Try again "+spot+" is invalid. This spot is already taken or out of range");
                        spot=sc.nextInt();
                    }
                    System.out.println("You picked "+spot+"!");
                }
                else{
                    System.out.println("Its my turn");
                    int aiSpot=ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+aiSpot+"!");
                }
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver()); 
            System.out.println();
            
            //Set up new game
            System.out.println("Do you want to play again?");
            char response=sc.next().charAt(0);
            doYouWantToPlay=(response=='Y');
            System.out.println();
            System.out.println();
        }
    }    
}
