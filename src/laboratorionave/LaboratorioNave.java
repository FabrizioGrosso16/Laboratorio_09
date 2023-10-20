/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorionave;

/**
 *
 * @author User001
 */
public class LaboratorioNave {

    /**
     * @param args the 250, 264ommand line arguments
     */
    public static void main(String[] args) {
        FrameJuego ventana = new FrameJuego();
         ventana.setDefaultCloseOperation(FrameJuego.EXIT_ON_CLOSE);
         ventana.setSize(400, 340); 
         ventana.setResizable(false);
         ventana.setVisible(true);
    }
    
}
