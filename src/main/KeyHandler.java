package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, helpPressed, mutePressed, shotKeyPressed;
	//DEBUG
	boolean DebugText = false;
	int value = 1;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			titleState(code);
		}
		
		
		//playstate
		else if(gp.gameState == gp.playState) {
			playState(code);
		}
		
		//PAUSE STATE
		else if (gp.gameState == gp.pauseState) {
			pauseState(code);
				
		}
		
	//DIALOGUESTATE
			else if (gp.gameState == gp.dialogueState) {
				dialogueState(code);
			
		}
		//character state
			else if(gp.gameState == gp.characterState) {
				characterState(code); 
			}
		
		//option state
			else if(gp.gameState == gp.optionsState) {
				optionsState(code); 
			}
		//GAME OVER STATE
			else if(gp.gameState == gp.gameOverState) {
				gameOverState(code); 
			}
		//TRADE STATE
			else if(gp.gameState == gp.tradeState) {
				tradeState(code); 
			}
		
	}
	public void titleState(int code) {
		

			
			if (gp.ui.nftskinState ==0 ) {
				
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 2;
			  }
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				
				if(gp.ui.commandNum == 0) {
					gp.ui.nftskinState = 1 ;
				//	gp.playMusic(5);
				}
					
				if(gp.ui.commandNum == 2) {
					System.exit(0);
					}
				}
			}
			else if (gp.ui.nftskinState == 1) {
				if(code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
						if(gp.ui.commandNum < 0) {
							gp.ui.commandNum = 3;
				}
				
			}
				
				if(code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 3) {
						gp.ui.commandNum = 0;
				}
			
			}
				
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						System.out.println("funguy#1 charcteristics (small loop)");
						gp.gameState = gp.playState;
						gp.playMusic(6);
						
					
				}
						
					if(gp.ui.commandNum == 1) {
						System.out.println("funguy#2 charcteristics (longer loop)");
						gp.gameState = gp.playState;
						gp.playMusic(6);
						gp.skinCount ++;
				}
					if(gp.ui.commandNum == 2) {
						System.out.println("funguy#3 charcteristics (lofi loop)");
						gp.gameState = gp.playState;
						gp.playMusic(6);
					}
					
					if(gp.ui.commandNum == 3) {
						gp.ui.nftskinState = 0;
					}
						
				}
		  }
		}
			
	
	public void playState(int code) {
		if(code == KeyEvent.VK_W) {
			upPressed = true;
			
		
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		
			
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			
		}
	//	if(code == KeyEvent.VK_M) {
	//		gp.stopMusic();
	//		mutePressed = true;
			
			
	//	}
		if(code == KeyEvent.VK_L) {
			
			//test printing out one letter at a time and little sound effect
			
			
			
		}
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.characterState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if(code == KeyEvent.VK_SPACE) {
			enterPressed = true;
		}
		if(code == KeyEvent.VK_SHIFT) {
			shotKeyPressed = true;
		}
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.optionsState;
		}
		
		
		
		//DUBUG
		
		if(code == KeyEvent.VK_T) {
			if(DebugText == false) {
				DebugText = true;
				
			}
			else if(DebugText == true) {
				DebugText = false;
			}
			
		}
		else if(code == KeyEvent.VK_R) {
			
			gp.aSetter.setInteractiveTile();
			switch(gp.currentMap) {
			case 0: gp.tileM.loadMap("/maps/worldV2.txt", 0); break;
			case 1: gp.tileM.loadMap("/maps/interior01.txt", 1); break;

			}
			
			
	}
		}
	
	
	public void pauseState(int code) {
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.playState;
			
		}	
	}
	public void dialogueState(int code) {
		if(code == KeyEvent.VK_ENTER) {
			gp.gameState = gp.playState;
		}
	}
	public void  characterState(int code) {
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.playState;
		}

		if(code == KeyEvent.VK_ENTER) {
			gp.player.selectItem();
		}
	playerInventory(code);
		

}
	public void optionsState(int code) {
		
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0: maxCommandNum = 5; break;
		case 3: maxCommandNum = 1; break;
		}
		
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(15);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(15);
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0){
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(15);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0){
					gp.se.volumeScale--;
					gp.playSE(15);
				}  
			}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5){
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(15);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5){
					gp.se.volumeScale++;
					gp.playSE(15);
				}  
			}
			 
			
		}
			
	}
	public void gameOverState(int code) {
		
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
			gp.playSE(15);
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
			gp.playSE(15);
		}
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.retry();
			}
			else if(gp.ui.commandNum == 1) {
				gp.gameState = gp.titleState;
				gp.ui.nftskinState = 0;
				gp.restart();
			}
			
		}
		
	}

	public void tradeState(int code) {
		
		if(code == KeyEvent.VK_ENTER){
		    enterPressed=true;
		}
		if(gp.ui.subState == 0){
		    if(code == KeyEvent.VK_W){
		        gp.ui.commandNum--;
		        if(gp.ui.commandNum < 0) {
		        	gp.ui.commandNum = 2;
		        }
		        gp.playSE(15);
		    }
		    if(code == KeyEvent.VK_S){
		        gp.ui.commandNum++;
		        if(gp.ui.commandNum > 2) {
		        	gp.ui.commandNum = 0;
		        }
		        gp.playSE(15);
		    }
		}
		if(gp.ui.subState == 1) {
			npcInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.subState = 0;
			}
		}
		
		if(gp.ui.subState == 2) {
			playerInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.subState = 0;
			}
		}
		
		
		
	
	}
	public void playerInventory(int code) {
		if(code == KeyEvent.VK_W) {
			if(gp.ui.playerSlotRow != 0) {
			gp.ui.playerSlotRow--;
			gp.playSE(15);
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.playerSlotCol != 0) {
			gp.ui.playerSlotCol--;
			gp.playSE(15);
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.playerSlotRow != 3) {
			gp.ui.playerSlotRow++;
			gp.playSE(15);
		}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.playerSlotCol != 4) {
			gp.ui.playerSlotCol++;
			gp.playSE(15);
		}
	 }
	}
	public void npcInventory(int code) {
		if(code == KeyEvent.VK_W) {
			if(gp.ui.npcSlotRow != 0) {
			gp.ui.npcSlotRow--;
			gp.playSE(15);
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.npcSlotCol != 0) {
			gp.ui.npcSlotCol--;
			gp.playSE(15);
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.npcSlotRow != 3) {
			gp.ui.npcSlotRow++;
			gp.playSE(15);
		}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.npcSlotCol != 4) {
			gp.ui.npcSlotCol++;
			gp.playSE(15);
		}
	 }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		
			
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
			
		}
		if(code == KeyEvent.VK_SHIFT) {
			shotKeyPressed = false;
		}
		
		
	}

}
