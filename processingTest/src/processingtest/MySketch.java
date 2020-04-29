
package processingtest;

import processing.core.*;

public class MySketch extends PApplet {
    
    @Override
    public void settings(){
        size(240, 400);
    }
    
    @Override
    public void setup(){
        background(0);
    }
    
    @Override
    public void draw(){
        rect(mouseX, mouseY, 20, 20);
    }
}
