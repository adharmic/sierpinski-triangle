import java.awt.*;
import java.applet.*;
import java.util.Random;

/**
 * Program to create a Sierpinski triangle within a Sierpinski triangle, using the chaos game.
 * By Adithya Ajith
 * Current version: 11/30/15 - 7:19PM
 */

public class Sierpinski extends Applet {
    public void paint(Graphics g) {
        //Setting points for base triangle.
        int x1 = 10;
        int y1 = ((int)(Math.sqrt(3)) * 750) + 10;
        int x2 = 760;
        int y2 = 10;
        int x3 = 1510;
        int y3 = ((int)(Math.sqrt(3)) * 750) + 10;
        
        //Random class for point positioning. Also, Math.random() is bad.
        Random rand = new Random();
        
        //Drawing base triangle.
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x3, y3, x2, y2);
        
        //Random color for aesthetic appeal.
        g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
        
        //Declaring variables for the Sierpinski triangle (the points to be drawn).
        int currentX = midpointX(x1, x2);
        int currentY = midpointY(y1, y2);
        //Randomly selected point of the base triangle.
        int targetPoint;
        
        //One million points! For consistency (triangle comes out solid).
        for(int x = 1; x <= 10000000; x++) {
            targetPoint = rand.nextInt(3);
            if(targetPoint == 0) {
                currentX = midpointX(currentX,x1);
                currentY = midpointX(currentY,y1);
            }
            if(targetPoint == 1) {
                currentX = midpointX(currentX,x2);
                currentY = midpointX(currentY,y2);
            }
            if(targetPoint == 2) {
                currentX = midpointX(currentX,x3);
                currentY = midpointX(currentY,y3);
            }
            
            g.drawLine(currentX,currentY,currentX,currentY);
        }
        
        
        //Same as previous, just with a different base triangle.
        x1 = 385;
        y1 = (int)(y1/2)+ 5;
        x2 = 1135;
        y2 = y1;
        x3 = 760;
        y3 = ((int)(Math.sqrt(3)) * 750) + 10;
        
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x3, y3, x2, y2);
        
        g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
        
        for(int x = 1; x <= 10000000; x++) {
            //g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
            targetPoint = rand.nextInt(3);
            if(targetPoint == 0) {
                currentX = midpointX(currentX,x1);
                currentY = midpointX(currentY,y1);
            }
            if(targetPoint == 1) {
                currentX = midpointX(currentX,x2);
                currentY = midpointX(currentY,y2);
            }
            if(targetPoint == 2) {
                currentX = midpointX(currentX,x3);
                currentY = midpointX(currentY,y3);
            }
            g.drawLine(currentX,currentY,currentX,currentY);
        }
    }
    
    public static int midpointX(int xa, int xb) {
        return (int)((xa + xb)/2);
    }
    public static int midpointY(int ya, int yb) {
        return (int)((ya+ yb)/2);
    }

}


