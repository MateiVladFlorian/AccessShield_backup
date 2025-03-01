package AddUIComponent;

/**
 *
 * @author vlad
 */
public class Add_UI_Component 
{
    public static void Add_UI_Container(javax.swing.GroupLayout layout, javax.swing.JPanel panel)
    {               
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel)  // Adaugă panoul la fereastră
                    .addContainerGap()
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel)  // Adaugă panoul în secțiunea verticală
                    .addContainerGap()
                )
        );
    }
    
    public static void Add_UI_Container(javax.swing.GroupLayout layout, javax.swing.JPanel panel, int x, int y) 
    {
        x = Math.max(0, x);
        y = Math.max(0, y);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(x) 
                    .addComponent(panel)  // Setare dimensiuni
                )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(y)
                    .addComponent(panel)
                )
        );
    }
}
