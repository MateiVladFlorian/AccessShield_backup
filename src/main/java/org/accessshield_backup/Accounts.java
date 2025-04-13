package org.accessshield_backup;

import AccountsManager.LoginModel;
import AccountsManager.TemporaryToken;
import Entities.Account;
import Entities.UserProfile;
import Entities.UsersRoles;
import core.AccountSession;
import core.AccountsUtil;
import core.EmailProvider;
import core.ManagerEntities;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import jpa.AccountJpaController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author vlad
 */
public class Accounts extends javax.swing.JFrame {
    private LoginModel Signin;
    
    private TemporaryToken token = new TemporaryToken();
    private String t = token.GenerateToken(64);   
    private boolean loggedInWithoutError = true;
    
    private Account account;
    private UserProfile user_profile;
    private UsersRoles role;
    private ManagerEntities em; 
    
    /**
     * Creates new form Accounts
     */
    
    public static Accounts accounts;
    
    public Accounts() 
    {
        Signin = new LoginModel();
        em = new ManagerEntities(); 
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recover = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        register = new javax.swing.JButton();
        signIn1 = new ApplicationManager.Authentication.SignIn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign in");

        recover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recover.setForeground(new java.awt.Color(0, 51, 255));
        recover.setText("         Lost password?");
        recover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recoverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recoverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recoverMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recoverMouseReleased(evt);
            }
        });

        login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        login.setText("Sign In");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        register.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        register.setText("Sign Up");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(signIn1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recover, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(signIn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recover, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void recoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverMousePressed
        if(!signIn1.username.getText().isEmpty()) {
            Color pressed = Color.decode("#e60000");
            recover.setForeground(pressed);
        }
    }//GEN-LAST:event_recoverMousePressed

    private void recoverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverMouseReleased
        if(!signIn1.username.getText().isEmpty()) {
            Color pressed = Color.decode("#3333ff");
            recover.setForeground(pressed);

            token.UpdateValueVariable("GENERATED_TOKEN", t);
            token.setToken("GENERATED_TOKEN", t);

            AccountJpaController ajc = new AccountJpaController();
            account = em.getManagerEntities().find(Account.class, 
                    ajc.getIndexAccountSelected(signIn1.username.getText()));

            if (account.getEmail().length() > 0) 
            {
                EmailProvider.Send(account.getEmail(), "sabu zhwq mypf dwvs", 
                        account.getEmail(), "Reset account", 
                        "Your access token is: " + t);
                
                /* open recover window after sending of email message */
                Recover recoverWin = new Recover();
                recoverWin.setFullName(account.getUsername());
                
                recoverWin.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_recoverMouseReleased

    private void recoverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverMouseExited
        Color pressed = Color.decode("#3333ff");
        recover.setForeground(pressed);
    }//GEN-LAST:event_recoverMouseExited

    private void recoverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverMouseEntered
        if(!signIn1.username.getText().isEmpty()) {
            Color pressed = Color.decode("#6f6fff");
            recover.setForeground(pressed);
        }
    }//GEN-LAST:event_recoverMouseEntered

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        new SignUp().setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        AccountJpaController ajc = new AccountJpaController();
        account = ajc.getAccountFromUsername(signIn1.username.getText());
        loggedInWithoutError = true;
        
        if (account != null) 
        {
            user_profile  = em.getManagerEntities().find(UserProfile.class, account.getId());
            role = em.getManagerEntities().find(UsersRoles.class, account.getId());
            String encryptedPassword = AccountsUtil.GenerateSHA256(new String(signIn1.password.getPassword()));
            
            if (!encryptedPassword.equals(account.getPassword())) {
                JOptionPane.showMessageDialog(this, "Do you lost the password?");
                signIn1.password.setBorder(BorderFactory.createLineBorder(Color.RED));
                loggedInWithoutError = false;
                
                signIn1.password.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent arg0) {
                        /* remove the red border of password field, when the user try editing again */
                        signIn1.password.setBorder(BorderFactory.createLineBorder(Color.gray));
                    }
                });
            }
        }
        else if (account == null)
            JOptionPane.showMessageDialog(this, "This account does not exists!");
        
        if(account != null && role != null && user_profile == null && loggedInWithoutError)
            new UsersProfile().setVisible(true);
        else if (account != null && role != null && user_profile != null) // Daca utilizatorul inregistrat si-a personalizat profilul si si-a setat rolul (admin or quest)
        {
            if(Signin.Login_Model(signIn1.username.getText(), new String(signIn1.password.getPassword()))) 
            { 
                AccountSession.setAccountId(account.getId());  // Retine id-ul utilizatorului logat
                AccountSession.setUsername(account.getUsername()); // Retine numele utilizatorului logat
                AccountSession.Authenticate(true);

                LocalDateTime now = LocalDateTime.now();
                Timestamp checkIn = Timestamp.valueOf(now);
                account.setDatetimeconnected(checkIn);

                new Building_Management().setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Accounts().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton login;
    private javax.swing.JLabel recover;
    private javax.swing.JButton register;
    private ApplicationManager.Authentication.SignIn signIn1;
    // End of variables declaration//GEN-END:variables
}
