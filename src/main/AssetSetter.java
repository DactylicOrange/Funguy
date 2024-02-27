package main;


import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_Mana;
import object.OBJ_Mana_Potion;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Wood;
import object.OBJ_Speed_Potion;
import object.OBJ_coin;
import tile_interactive.IT_DoorClosed;
import tile_interactive.IT_WeakShroom;
import entity.NPC_Merchant1;
import entity.NPC_OldMan;
import entity.NPC_Pengu;
import entity.NPC_Trader;
import entity.NPC_evie;
import entity.NPC_fisherman;
import monster.MON_COMush;
import monster.MON_Ghost;
import monster.MON_Memer;
import monster.MON_OrangeSlime;
import monster.MON_PurpSlime;
import monster.MON_SPslime;
import monster.MON_error;
import monster.MON_eyeSlime;
import monster.MON_greySlime;


public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
public void setObject() {
	//MAP 0
	int mapNum = 0;
	int i = 0;
	gp.obj[mapNum][i] = new OBJ_Key(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 23;
	gp.obj[mapNum][i].worldY = gp.tileSize * 20;
	i++;
	gp.obj[mapNum][i] = new OBJ_coin(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 28;
	gp.obj[mapNum][i].worldY = gp.tileSize * 39;
	i++;
	gp.obj[mapNum][i] = new OBJ_coin(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 35;
	gp.obj[mapNum][i].worldY = gp.tileSize * 9;
	i++;
	gp.obj[mapNum][i] = new OBJ_coin(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 10;
	gp.obj[mapNum][i].worldY = gp.tileSize * 8;
	i++;
	gp.obj[mapNum][i] = new OBJ_Axe(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 33;
	gp.obj[mapNum][i].worldY = gp.tileSize * 21;
	i++;
	gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 35;
	gp.obj[mapNum][i].worldY = gp.tileSize * 21;
	i++;
	gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 37;
	gp.obj[mapNum][i].worldY = gp.tileSize * 42;
	i++;
	gp.obj[mapNum][i] = new OBJ_Speed_Potion(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 37;
	gp.obj[mapNum][i].worldY = gp.tileSize * 29;
	i++;
	gp.obj[mapNum][i] = new OBJ_Mana_Potion(gp);
	gp.obj[mapNum][i].worldX = gp.tileSize * 51;
	gp.obj[mapNum][i].worldY = gp.tileSize * 10;
	i++;
    gp.obj[mapNum][i] = new OBJ_Door(gp);
  	gp.obj[mapNum][i].worldX = gp.tileSize * 10;
    gp.obj[mapNum][i].worldY = gp.tileSize * 12;
	i++;
	
	
	//MAP 1
//	mapNum = 1;
//	i = 0;
//	gp.obj[mapNum][i] = new OBJ_coin(gp);
//	gp.obj[mapNum][i].worldX = gp.tileSize * 12;
//	gp.obj[mapNum][i].worldY = gp.tileSize * 10;
//	i++;
	
	
}

	public void setNPC() {
		int mapNum = 0;
		int i = 0;
		gp.npc[mapNum][i] = new NPC_fisherman (gp);
		gp.npc[mapNum][i].worldX = gp.tileSize *41;
		gp.npc[mapNum][i].worldY = gp.tileSize *29 - 14;
		i++;
		
		
		gp.npc[mapNum][i] = new NPC_OldMan (gp);
		gp.npc[mapNum][i].worldX = gp.tileSize *9;
		gp.npc[mapNum][i].worldY = gp.tileSize *10;
		i++;
		
//		gp.npc[mapNum][i] = new NPC_Pengu(gp);
//		gp.npc[mapNum][i].worldX = gp.tileSize *41;
//		gp.npc[mapNum][i].worldY = gp.tileSize *20;
//		i++;
		
		mapNum = 1;
		i = 0;
		
		gp.npc[mapNum][i] = new NPC_evie (gp);
		gp.npc[mapNum][i].worldX = gp.tileSize *10;
		gp.npc[mapNum][i].worldY = gp.tileSize *11;
		i++;
		
		mapNum = 2;
		i = 0;
		gp.npc[mapNum][9] = new NPC_Trader (gp);
		gp.npc[mapNum][9].worldX = gp.tileSize *12;
		gp.npc[mapNum][9].worldY = gp.tileSize *8 + 5;
		i++;
		
		gp.npc[mapNum][i] = new NPC_evie (gp);
		gp.npc[mapNum][i].worldX = gp.tileSize *25;
		gp.npc[mapNum][i].worldY = gp.tileSize *10;
		i++;

	
		
		

	}
	public void setMonster() {
		int mapNum = 0;
		
		int i = 0;
		
		gp.monster[mapNum][i]= new MON_greySlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *13;
		gp.monster[mapNum][i].worldY = gp.tileSize *34;
		
		i ++;
		gp.monster[mapNum][i]= new MON_greySlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *23;
		gp.monster[mapNum][i].worldY = gp.tileSize *37;
		i ++;
		
		//ORANGE slime below can get rid of if shown new way
		gp.monster[mapNum][i] = new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *22;
		gp.monster[mapNum][i].worldY = gp.tileSize *36;
		i ++;
		
		gp.monster[mapNum][i] = new MON_greySlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *12;
		gp.monster[mapNum][i].worldY = gp.tileSize *34;
		i ++;
		
		gp.monster[mapNum][i] = new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *37;
		gp.monster[mapNum][i].worldY = gp.tileSize *38;
		i ++;
		
		gp.monster[mapNum][i]= new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *24;
		gp.monster[mapNum][i].worldY = gp.tileSize *36;
		i ++;
		
		gp.monster[mapNum][i]= new MON_greySlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *25;
		gp.monster[mapNum][i].worldY = gp.tileSize *37;
		i ++;
		
		gp.monster[mapNum][i]= new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *25;
		gp.monster[mapNum][i].worldY = gp.tileSize *41;
		i ++;
		
		gp.monster[mapNum][i]= new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *37;
		gp.monster[mapNum][i].worldY = gp.tileSize *9;
		i ++;
		
		gp.monster[mapNum][i]= new MON_greySlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *37;
		gp.monster[mapNum][i].worldY = gp.tileSize *11;
		i ++;
		mapNum = 3;
		i = 0;
		gp.monster[mapNum][i]= new MON_Memer(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *20;
		gp.monster[mapNum][i].worldY = gp.tileSize *13;
		i ++;
		mapNum = 4;
		i = 0;
		gp.monster[mapNum][i]= new MON_error(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *20;
		gp.monster[mapNum][i].worldY = gp.tileSize *13;
		i ++;
		mapNum = 5;
		gp.monster[mapNum][i]= new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *37;
		gp.monster[mapNum][i].worldY = gp.tileSize *9;
		i ++;
		gp.monster[mapNum][i]= new MON_Ghost(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *9;
		gp.monster[mapNum][i].worldY = gp.tileSize *37;
		i ++;
		gp.monster[mapNum][i]= new MON_SPslime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *20;
		gp.monster[mapNum][i].worldY = gp.tileSize *40;
		i ++;
		gp.monster[mapNum][i]= new MON_SPslime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *23;
		gp.monster[mapNum][i].worldY = gp.tileSize *47;
		i ++;
		gp.monster[mapNum][i]= new MON_SPslime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize *10;
		gp.monster[mapNum][i].worldY = gp.tileSize *44;
		i ++;
//		gp.monster[mapNum][i]= new MON_COMush(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize *40;
//		gp.monster[mapNum][i].worldY = gp.tileSize *20;
//		i ++;
		
		
		


	}
	public void setInteractiveTile() {
		int mapNum = 0;
		int	i = 0;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 27, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 28, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 29, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 30 , 8);	
		i++;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 31, 8);	
		i++;
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 32, 8);
		i++; 
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 33, 8);
		i++; 
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 36, 30);
		i++; 
		gp.iTile[mapNum][i] = new IT_WeakShroom(gp, 17, 40);
		
	
		
		
		
	}
	
	
	
}
