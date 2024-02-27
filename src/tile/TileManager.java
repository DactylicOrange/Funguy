package tile;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;


public class TileManager  {
	
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][][];
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[200]; //controls the number of tiles allowed (can be changed if want more)
		mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		//PICK MAP
		loadMap("/maps/worldV2.txt", 0);
		loadMap("/maps/mushouse.txt",1);
		loadMap("/maps/interior01.txt",2);
		loadMap("/maps/dun.txt",3);
		loadMap("/maps/Err.txt",4);
		loadMap("/maps/SpookyForrest.txt",5);
		loadMap("/maps/SHinterior.txt",6);
	}
	
	public void getTileImage() {
		
		setup(0, "mush00", false); 
		setup(1, "wallTLC01", true);
		setup(2, "wallTLC", true);
		setup(3, "wallTRC", true);
		setup(4, "wallTIS", true);
		setup(5, "wallBIS", true);
		setup(6, "topIW", true);
		setup(7, "bottomIW", true);
		setup(8, "sideLIW", true);
		setup(9, "sideRIW", true);
		
		//grass
		setup(10, "mush00", false);
		setup(11, "mush01", false);
		
		//water
		setup(12, "water00", true);
		setup(13, "water01", true);
		setup(14, "water02", true);
		setup(15, "water03", true);
		setup(16, "water04", true);
		setup(17, "water05", true);
		setup(18, "water06", true);
		setup(19, "water07", true);
		setup(20, "water08", true);
		setup(21, "water09", true);
		setup(22, "water10", true);
		setup(23, "water11", true);
		setup(24, "water12", true);
		setup(25, "water13", true);
		
		//road
		setup(26, "road00", false);
		setup(27, "road01", false);
		setup(28, "road02", false);
		setup(29, "road03", false);
		setup(30, "road04", false);
		setup(31, "road05", false);
		setup(32, "road06", false);
		setup(33, "road07", false);
		setup(34, "road08", false);
		setup(35, "road09", false);
		setup(36, "road10", false);
		setup(37, "road11", false);
		setup(38, "road12", false);
		
		//earth
		setup(39, "earth", false);
		
		//wall
		setup(40, "wall", true);
		
		//mushroomstrees
		setup(41, "mushroomdet", true);
		setup(42, "mushroomdet3", true);
		setup(43, "mushroomdet2", true);
		
		
		//telepad
		setup(44, "DarkSpace", false);
		
		//damagepit
		setup(45, "damagepit", false);
		
		setup(46, "dock00", false);
		setup(47, "dockwater", false);
		setup(48, "bridge_1", true);
		setup(49, "bridge_2", true);
		setup(50, "bridge3", true);
		setup(51, "bridgeonside", true);
		
		//housetiles
		setup(52, "h1t", true);
		setup(53, "h2f", false);
		setup(54, "h3t", true); //false
		setup(55, "h4t", false);
		setup(56, "h5f", false);
		setup(57, "h6t", true);
		setup(58, "h7t", true);
		setup(59, "h8t", true);
		setup(60, "h9t", true);
		setup(61, "h10t", true);
		setup(62, "h11t", true);
		setup(63, "h12t", true);
		setup(64, "h13t", true);
		setup(65, "h14t", true);
		setup(66, "h15t", true);
		setup(67, "h16t", true);
		setup(68, "h17t", true);
		setup(69, "h18t", true);
		setup(70, "h19t", true);
		setup(71, "h20t", true);
		setup(72, "h21t", true);
		setup(73, "h22t", true);
		setup(74, "h23t", true);
		setup(75, "h24t", true);
		setup(76, "h25t", true);
		
		setup(77, "mushroomdet4", true);
		setup(78, "mushroom4", true);
		setup(79, "mushroom5", true);
		
		//house paths
		setup(80, "downpath", false);
		setup(81, "bottomrightcornerpath", false);
		setup(82, "leftpath", false);
		setup(83, "topleftcornerpath", false);
		
		//green mushrrom clump
		setup(84, "mf00", true);
		setup(85, "mf01", true);
		setup(86, "mf02", true);
		setup(87, "mf03", true);
		setup(88, "mf04", true);
		setup(89, "mf05", true);
		setup(90, "mf06", true);
		setup(91, "mf07", true);
		setup(92, "mf08", true);
		
		//purp mushroom clump
		setup(93, "mfp00", true);
		setup(94, "mfp01", true);
		setup(95, "mfp02", true);
		setup(96, "mfp03", true);
		setup(97, "floor01", false);
		setup(98, "table02", true);
		setup(99, "picWall", true);
		setup(100, "picWallb", true);
		setup(101, "botshelf", true);
		setup(102, "topshelf", true);
		setup(103, "botshelf2", true);
		setup(104, "topshelf2", true);
		setup(105, "bedB", true);
		setup(106, "bedT", true);
		setup(107, "window", true);
		setup(108, "drawercomputer", true);
		
		
		setup(110, "DarkSpace", false);
		setup(111, "wallTIS", false);
		setup(112, "sideLIW", true);
		setup(113, "sideRIW", true);
		setup(114, "topIW", true);
		setup(115, "bottomIW", true);
		setup(116, "StoneBrickWall", true);
		setup(117, "bedB01", true);
		setup(118, "bedT01", true);
		setup(119, "wallBLC", true);
		setup(120, "Lantern", true);
		
		setup(121, "0codeblock", false);
		setup(122, "ERblock", true);
		setup(123, "1codeblock", false);
		setup(124, "spookymushroom", true);
		setup(125, "SFBLC", true);
		setup(126, "SFBRC", true);
		setup(127, "SFTLC", true);
		setup(128, "SFTRC", true);
		setup(129, "Spookymush01", false);
		setup(130, "HSFP", false);
		setup(131, "VSFP", false);
		setup(132, "TurnLSFP", false);
		setup(133, "TurnRSFP", false);
		//134-138
		setup(139, "Spookymush", false);
		setup(140, "spookymushroom01", true);
		setup(141, "SMT1", true);
		setup(142, "SMT2", true);
		setup(143, "SMT3", true);
		setup(144, "SMT4", true);
		setup(145, "SMT6", true);
		setup(146, "SMT7", true);
		setup(147, "mossyRock", true);
		
		//148,149,150
		setup(151, "SPH1", true);
		setup(152, "SPH2", false);
		setup(153, "SPH3", true);
		setup(154, "SPH4", true);
		setup(155, "SPH5", true);
		setup(156, "SPH6", true);
		setup(157, "SPH7", true);
		setup(158, "SPH8", true);
		setup(159, "SPH9", true);
		
		
		//spooky numbers for outlining wall
		setup(160, "wallTLC01", true);
		setup(161, "wallTLC", true);
		setup(162, "wallTRC", true);
		setup(163, "wallTIS", true);
		setup(164, "DarkWallB", true);
		setup(165, "topIW", true);
		setup(166, "bottomIW", true);
		setup(167, "sideLIW", true);
		setup(168, "sideRIW", true);
		
		//Spooky interior tiles
		setup(169, "DarkFloor", false);
		setup(170, "cobwebWLC", true);
		setup(171, "DarkDrawer", true);
		setup(172, "SpookyShelfB1", true);
		setup(173, "SpookyShelfT1", true);
		
		
		
		//180 Spooky water tiles
		setup(180, "SPwater00", true);
		setup(181, "SPwater01", true);
		setup(182, "SPwater02", true);
		setup(183, "SPwater03", true);
		setup(184, "SPwater04", true);
		//accidentally didnt even make a 5
//		setup(185, "SPwater05", true);
		setup(186, "SPwater06", true);
		setup(187, "SPwater07", true);
		setup(188, "SPwater08", true);
		setup(189, "SPwater09", true);
		setup(190, "SPwater10", true);
		setup(191, "SPwater11", true);
		setup(192, "SPwater12", true);
		setup(193, "SPwater13", true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String filePath, int map) {
		
		//filePath is the string for whatever map wanna load
		
		try {
		InputStream is = getClass().getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		int col = 0;
		int row = 0;
		
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			String line = br.readLine();
			
			while(col < gp.maxWorldCol) {
				
				String numbers[] = line.split(" ");
				
				int num = Integer.parseInt(numbers[col]);
				
				mapTileNum[map][col][row] = num;
				col++;
			}
			if(col == gp.maxWorldCol) {
				col = 0;
				row ++;
			}
		}
		br.close();
		
		}catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics g2)	{
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX; 
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			//map data stored in array above
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			
			}
			
		}
	}
		
	

}
