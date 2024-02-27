package object;



import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	GamePanel gp;
	
	public OBJ_Key(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
	    
		type = type_key;
		name = "Key";
		down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\nIt can open a door...";
		price = 100;
		
	}
	public void use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if(objIndex != 999) {
			gp.ui.currentDialogue =  "You used the " + name + "and opened the door";
			gp.playSE(3);
			gp.obj[gp.currentMap][objIndex] = null;
			
			
		}
		else {
			gp.ui.currentDialogue = "WHAT ARE YOU DOING!!!";
		}
		}
}
   