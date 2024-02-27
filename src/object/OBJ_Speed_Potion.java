package object;


import entity.Entity;
import main.GamePanel;



public class OBJ_Speed_Potion extends Entity{
	public boolean potionOn = false;
	public int potionCounter = 0;

	GamePanel gp;
	
	public OBJ_Speed_Potion(GamePanel gp) {
		super(gp);
		this.gp = gp;
		value = 1;
		type = type_consumable;
		name = "Speed Potion";
		down1 = setup("/objects/speed_potion", gp.tileSize, gp.tileSize);
		description = "[Speed Potion]\nYou will Run faster";
		price = 30;
	}
	public void use(Entity entity) {
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You drink the " + name + "!\n"
				+ "You are now faster!";
		entity.speed += value;
		gp.playSE(2);
		potionOn = true;
		
		

		}
	public void update() {
		
			
	}
			
		
		
	}


	
	


//Time
