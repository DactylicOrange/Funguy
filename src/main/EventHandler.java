package main;

import java.awt.Rectangle;

import entity.Entity;

public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][][];
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if(row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
		
		
	}
	
	public void checkEvent() {
		//check if player is more than a tile away from last event to see if same event applicable again
		
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance,  yDistance);
		if(distance > gp.tileSize) {  //if player a tile away the event can happen again
			canTouchEvent = true;
		}
		if(canTouchEvent == true) {
		if(hit(0,27,16,"right") == true) {damagePit(gp.dialogueState);}
		else if(hit(0,23,12,"up")== true) {healingPool(gp.dialogueState);}
		else if(hit(0,51,5,"up") == true) {EnterStructure(2,12,11);gp.playMusic(27);}
		else if(hit(2,12,12,"down") == true) {EnterStructure(0,51,5);gp.playMusic(6);}
		else if(hit(2,12,10,"up") == true) {speak(gp.npc[2][9]);}
		else if(hit(0, 9, 9, "any") == true) {EnterStructure(5,8,8);gp.playMusic(29);}
		
		else if(hit(3,6,6,"any") == true) {EnterStructure(0,20,20);gp.playMusic(6);}
		
		else if(hit(5, 44, 17, "up") == true) {EnterStructure(6,26,17);gp.playMusic(29);}
		//goto 44,26 below(to the island)
	//	if(hit(0,10,33, "any") ==true) {teleport(10,33,gp.dialogueState);}
		//teleport home below to 22,23 from 44,26 (off the island)
	//	if(hit(0,44,26, "any") == true) {teleportHome(44,26,gp.dialogueState);}
	
		
		}
	}
	
	public boolean hit(int map, int col, int row, String reqDirection) {
		boolean hit = false;
		
		if(map == gp.currentMap) {
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
		eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
		
		if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
			if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
				hit = true;
				
				previousEventX = gp.player.worldX;
				previousEventY = gp.player.worldY;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
		eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
		}
		
		return hit;
	}
	public void teleport(int col, int row, int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "TELEPORT!"; 
		gp.player.worldX = gp.tileSize * 44;
		gp.player.worldY = gp.tileSize * 24;
		gp.playSE(3);
		
		
	}
	public void teleportHome(int col, int row, int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "TELEPORT!"; 
		gp.player.worldX = gp.tileSize * 23 ;
		gp.player.worldY = gp.tileSize * 21;
		gp.playSE(3);
	}
	//teleport to the center of map (use the hit function in check event to test)
	public void EnterStructure(int map, int col, int row) {
		gp.stopMusic();
		gp.gameState = gp.transitionState;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		
		
//		gp.currentMap = map;
//		gp.player.worldX = gp.tileSize * col;
//		gp.player.worldY = gp.tileSize * row;
//		previousEventX = gp.player.worldX;
//		previousEventY = gp.player.worldY;
		canTouchEvent = false;
		gp.playSE(20);
		

	
		

	}	
	public void damagePit(int gameState) {
		
		gp.gameState = gameState;
		gp.ui.currentDialogue = "YOU FALL IN PIT!";
		gp.playSE(9);
		gp.player.life -= 1;
	//	eventRect[col][row].eventDone = true;
		canTouchEvent = false;
		//now whenever walk away from pit can take damage again
				
	}
	public void healingPool(int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			
			gp.gameState = gameState;
			gp.player.attackCancelled = true;
			gp.playSE(2);
			gp.ui.currentDialogue = "Drinking water recovered lives!";
			gp.player.mana = gp.player.maxMana;
			gp.player.life = gp.player.maxLife;
			gp.aSetter.setMonster();
		}
	}
	public void speak(Entity entity) {
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gp.dialogueState;
			gp.player.attackCancelled = true;
			entity.speak();
			
		}
	}

 }
