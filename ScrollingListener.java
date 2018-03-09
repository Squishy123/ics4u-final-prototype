import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.*;
/**
 * Helper class that gets data about the scroll wheel
 * 
 * @author Christian Wang
 * @version 1.0
 */
public class ScrollingListener implements MouseWheelListener
{
    int amount = 0;
     
    public void mouseWheelMoved(MouseWheelEvent e){
        amount += e.getWheelRotation();  
        e.consume();
    }
     
    public int getScroll(){
        int t = amount;
        //amount = 0;
        return t;
    }
}
