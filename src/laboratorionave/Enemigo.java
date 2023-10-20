/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorionave;

/**
 *
 * @author User001
 */
import javax.swing.*;
import java.awt.*;

public class Enemigo extends JPanel {
    private int velocidad;
    public Enemigo(int x, int y, int velocidad) {
        this.velocidad = velocidad;
        setBounds(x, y, 30, 30); 
        setBackground(Color.GREEN); 
    }
    public void mover() {
        setLocation(getX(), getY() + velocidad);
    }
    public boolean verificaColision(int tankeX, int tankeY, int tankeWidth, int tankeHeight) {
        return getBounds().intersects(new Rectangle(tankeX, tankeY, tankeWidth, tankeHeight));
    }
}