/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hugo Ordoñez
 */
public class ReturnViws {

    
  ///-------------------------------------metodo para retonar el Internal frame  
    public JInternalFrame returnInternal(JPanel panel, String text) {
        JInternalFrame interno = new JInternalFrame(text);
        interno.add(panel);
        interno.setClosable(true);
        interno.pack();
        interno.setVisible(true);
        
        return interno;
    }
    //--------------
}
