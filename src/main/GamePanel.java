package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import buildings.SuperStructure;
import entity.Entity;
import entity.Player;
import tile.TileManager;
import tile_interactive.InteractiveTile;

public class GamePanel extends JPanel implements Runnable{
	
	//screen settings
	final int originalTileSize = 16; //16x16pixeltile
	final int scale = 3;
	
	
	//tile size below
	public final int tileSize = originalTileSize * scale; //48 x 48 just rescaled
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 960 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	// WORLD SETTINGS
	public final int maxWorldCol = 60;
	public final int maxWorldRow = 60;
	public final int maxMap = 20; //max map
	public int currentMap = 0;
	//public final int worldWidth = tileSize * maxWorldCol;
	//public final int worldHeight = tileSize * maxWorldRow;
	
	//FOR FULL SCREEN
	int screenWidthfull = screenWidth;
	int screenHeightfull = screenHeight;
	BufferedImage tempScreen;
	Graphics2D g2;
	
	public boolean fullScreenOn = false;

	
	
	//FPS
	
	int FPS = 60;
	
	//system
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	public Sound se = new Sound();
	
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Config config = new Config(this);
	Thread gameThread;
	//entity object
	public Player player = new Player(this, keyH);
	public Entity obj[][] = new Entity[maxMap][20]; 
	public Entity npc[][] = new Entity[maxMap][10];
	public Entity monster[][] = new Entity[maxMap][20];
	public InteractiveTile iTile[][] = new InteractiveTile[maxMap][50];
	public Entity projectile[][] = new Entity[maxMap][20];
//	public ArrayList<Entity> projectileList = new ArrayList<>();
	public ArrayList<Entity> particleList = new ArrayList<>();
	ArrayList<Entity> entityList = new ArrayList<>();
	

	//structure can delete its a test
	public buildingSetter bSetter = new buildingSetter(this);
	public SuperStructure stu[] = new SuperStructure[10];
	//GAME STATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;
	public final int characterState = 4;
	public final int optionsState = 5;
	public final int gameOverState = 6;
	public final int transitionState = 7;
	public final int tradeState = 8;
	
	//counters
	public int mutterCount = 0;
	public int skinCount = 0;
	public int fishCount = 0;
	public int FGspeakCount = 0;
	//GamePanel below
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
		
	

	public void setupGame() {
		//testing buildings
		bSetter.setStructure();
		//can delete above structure method
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		aSetter.setInteractiveTile();
		//playMusic(6);
		//stopMusic(); //toggle music on and off
		gameState = titleState;
		
		tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D)tempScreen.getGraphics();
		
		if(fullScreenOn == true) {
			//setfullScreen();
			//Can do the fullscreen video for this as of now it just does
			//an undecorated JFRAME when click FULLSCREEN ON
		}
	}
	public void retry() {
		player.setDefaultPositions();
		player.restoreLifeAndMana();
		aSetter.setNPC();
		aSetter.setMonster();
		playMusic(6);
		
	}
	public void restart() {
		
		player.setDefaultValues();
		player.setItems();
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		aSetter.setInteractiveTile();
		
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
/// DELTA METHOD
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();

				delta --;
				drawCount++;
			}
			if(timer >= 1000000000) {
				//System.out.println("FPS:"+ drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
				
	}
	
	// in java the movement is inverse
	public void update() {
		
		if(gameState == playState) {
			//PLAYER update method is updating player coordinates
			player.update();
			//NPC
			for(int i = 0; i < npc[1].length; i ++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].update();			
					}
				
			}
			for(int i = 0; i < monster[1].length; i++) {
				if(monster[currentMap][i] != null) {
					if(monster[currentMap][i].alive == true && monster[currentMap][i].dying==false) {
						monster[currentMap][i].update();
					}
					if(monster[currentMap][i].alive == false) {
						if(monster[currentMap][i].name == "Ghost") {playSE(23);} //can del
						else if(monster[currentMap][i].name == "Gray Slime") {playSE(25);} //can del
						monster[currentMap][i].checkDrop();
						monster[currentMap][i] = null;
						
						
						
						
					}
					
				}
			}
			for(int i = 0; i < projectile[1].length; i++) {
				if(projectile[currentMap][i] != null) {
					if(projectile[currentMap][i].alive == true) {
						projectile[currentMap][i].update();
					}
					if(projectile[currentMap][i].alive == false) {
						projectile[currentMap][i] = null;
					}
					
				}
			}
			for(int i = 0; i < particleList.size(); i++) {
				if(particleList.get(i) != null) {
					if(particleList.get(i).alive == true) {
						particleList.get(i).update();
					}
					if(particleList.get(i).alive == false) {
						particleList.remove(i);
					}
					
				}
			}
			for(int i = 0; i < iTile[1].length; i++) {
				if(iTile[currentMap][i] != null) {
					iTile[currentMap][i].update();
				}
			}
			
		} 
		if(gameState == pauseState) {
			
		}
		
		
		
	}

	public void paintComponent(Graphics g)  {
	
		super.paintComponent(g);
//		
		Graphics2D g2 = (Graphics2D)g;

	
	// DEBUG
	long drawStart= 0;
	if(keyH.DebugText == true) {
	drawStart = System.nanoTime();
	
	}

	
	//title screen
	
	if(gameState == titleState) {
		ui.draw(g2);
	}
	else {
		//tile
		
		tileM.draw(g2);
		
		//interactive tile
		
		for(int i = 0; i < iTile[1].length; i ++) {
			if(iTile[currentMap][i] != null) {
				iTile[currentMap][i].draw(g2);
			}
		}
		
		
		entityList.add(player);
		
		for(int i = 0; i < npc[1].length; i ++) {
			if(npc[currentMap][i] != null){
				entityList.add(npc[currentMap][i]);
			}
		}
		for(int i = 0; i < obj[1].length; i ++) {
			if(obj[currentMap][i] != null) {
				entityList.add(obj[currentMap][i]);
				
			}
		}
		for(int i = 0; i < monster[1].length; i ++) {
			if(monster[currentMap][i] != null) {
				entityList.add(monster[currentMap][i]);
			}
		}
		for(int i = 0; i < projectile[1].length; i ++) {
			if(projectile[currentMap][i] != null) {
				entityList.add(projectile[currentMap][i]);
			}
		}
		for(int i = 0; i < particleList.size(); i ++) {
			if(particleList.get(i) != null) {
				entityList.add(particleList.get(i));
			}
		}
		// Sort
		
		Collections.sort(entityList, new Comparator<Entity>() {

			@Override
			public int compare(Entity e1, Entity e2) {
				int result = Integer.compare(e1.worldY, e2.worldY);
				
				return result;
			}
			
			});
		//DRAW ENTITIES
		for(int i = 0; i < entityList.size(); i++) {
			entityList.get(i).draw(g2);
			
		}
		//empty entity list
			entityList.clear();
		
		
		//UI
		ui.draw(g2);
	}
		
	
	//DEBUG
	if(keyH.DebugText == true) {
		
	long drawEnd = System.nanoTime();
	long passed = drawEnd - drawStart;
	g2.setFont(new Font("Arial", Font.PLAIN, 20));
	g2.setColor(Color.white);
	int x = 10;
	int y = 400;
	int lineHeight = 20;
	
	g2.drawString("WorldX " + player.worldX, x, y); y+= lineHeight;
	g2.drawString("WorldY " + player.worldY, x, y); y+= lineHeight;
	
	g2.drawString("COL " + (player.worldX + player.solidArea.x)/tileSize, x, y); y+= lineHeight;
	g2.drawString("ROW " + (player.worldY + player.solidArea.y)/tileSize, x, y); y+= lineHeight;
	g2.drawString("SPEED " + (player.speed), x, y); y+= lineHeight;

	g2.drawString("draw time: " + passed, x,y);
	
	
	}
	
	g2.dispose();
}

//public void drawToScreen() {
//	
//	Graphics g2 = getGraphics();
//	g2.drawImage(tempScreen, 0, 0, screenWidthfull, screenHeightfull, null);
//	g2.dispose();
//}

	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	public void stopMusic() {
		music.stop();
	}
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
