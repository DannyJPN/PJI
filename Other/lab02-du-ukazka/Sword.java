/**
 * @author Ondřej Šlosárek
 */
public class Sword {
	private Rectangle rect1;
	private Ellipse eli;
    private Rectangle rect2;
    private Triangle tri;
    
    public Sword(){
    	rect1 = new Rectangle(115,90,20,125, MyColor.GRAY);
    	eli = new Ellipse(112,210,25,25);
        rect2 = new Rectangle(85,175,80,15,MyColor.BLUE);
        tri = new Triangle(115,70,20,20,MyColor.GRAY);
    }
    
    public Sword(int x, int y){
    	rect1 = new Rectangle(x+30,y+20,20,125, MyColor.GRAY);
    	eli = new Ellipse(x+27,y+140,25,25);
        rect2 = new Rectangle(x,y+105,80,15,MyColor.BLUE);
        tri = new Triangle(x+30,y,20,20,MyColor.GRAY);
    }
    
    public void moveRight(int x){
   	 	rect1.moveRight(x);
   	 	eli.moveRight(x);
   	 	rect2.moveRight(x);
   	 	tri.moveRight(x);
   	 	rect1.moveRight(0);
	 	eli.moveRight(0);
	 	rect2.moveRight(0);
	 	tri.moveRight(0);
    }
    
    public void moveDown(int y){
   	 	rect1.moveDown(y);
   	 	eli.moveDown(y);
   	 	rect2.moveDown(y);
   	 	tri.moveDown(y);
   	 	rect1.moveDown(0);
	 	eli.moveDown(0);
	 	rect2.moveDown(0);
	 	tri.moveDown(0);
    }
    
    public void setPosition(int x, int y){
    	this.rect1.setPosition(x+30,y+20);
    	this.eli.setPosition(x+27,y+140);
        this.rect2.setPosition(x,y+105);
        this.tri.setPosition(x+30,y);
   	 	rect1.moveDown(0);
	 	eli.moveDown(0);
	 	rect2.moveDown(0);
	 	tri.moveDown(0);
    }
    
    public int getX(){
   	 	return this.rect1.getX();
    }
    
    public int getY(){
   	 	return this.rect1.getY();
    }

}