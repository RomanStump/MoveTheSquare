package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0 ) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
		if(square.getX()+square.getWidth()==model.getWidth() || square.getX() == 0){
			model.setSquareDx(0);
		}
		if(square.getY()+square.getHeight()==model.getHeight() || square.getY() == 0) {
			model.setSquareDy(0);
		if(square.getX() + square.getWidth()+ model.getSquareDx() <= model.getWidth() 
		& square.getX() - square.getWidth()+ model.getSquareDx() >= 0){
			square.setX(square.getX() + model.getSquareDx());

		}else {
			square.setX(square.getX());
		}
		if(square.getY() + square.getHeight() +model.getSquareDy() <= model.getHeight()
		&square.getY() - square.getHeight() + model.getSquareDy() >=0) {
			square.setY(square.getY() + model.getSquareDy());
		}else {
			square.setY(square.getY());
		}
	}
}
}
