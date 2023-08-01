/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bolton.view;

import com.bolton.controller.ControllerFactory;
import com.bolton.controller.UserController;
import com.bolton.model.Post;
import com.bolton.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    public HomeView() {
        initComponents();
        loadPost();
        loadUsersWithFollowButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allPostTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        postButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        logOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Feed");

        allPostTextArea.setColumns(20);
        allPostTextArea.setRows(5);
        jScrollPane1.setViewportView(allPostTextArea);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Suggestions");

        postButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postButton.setText("POST");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        postTextArea.setColumns(20);
        postTextArea.setRows(5);
        jScrollPane3.setViewportView(postTextArea);

        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(postButton))
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logOutButton)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(postButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logOutButton)
                        .addGap(19, 19, 19))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadPost(){

        ControllerFactory controllerFactory = ControllerFactory.getInstance();

        UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);
        List<Post> posts = userController.getAllPosts();
        StringBuilder postContent = new StringBuilder();

        for (Post post : posts) {
            postContent
                    .append("Name: ").append(post.getUser().getName()).append("\n")
                    .append(post.getContent()).append("\n\n");
        }


        if (posts.isEmpty()) {
            postContent.append("No posts to show");
        }else {
            allPostTextArea.setText(postContent.toString());
        }

    }

    private void loadUsersWithFollowButton(){
        ControllerFactory controllerFactory = ControllerFactory.getInstance();

        UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);
        List<User> users = userController.getAllUsers();
//        JList<User> userList = new JList<>(users.toArray(new User[0]));
//        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set selection mode to SINGLE_SELECTION
//        userList.setCellRenderer(new UserListCellRenderer());
//
//        JScrollPane scrollPane = new JScrollPane(userList);
//        scrollPane.setPreferredSize(new Dimension(190, 360));
//
//        // Add the JScrollPane to jScrollPane2
//        jScrollPane2.setViewportView(scrollPane);

        // Create a new panel to hold the follow buttons
        JPanel usersPanel = new JPanel();
        usersPanel.setLayout(new GridLayout(0, 2, 5, 5));

        for (User user : users) {
            // Create a label for the user name
            JLabel nameLabel = new JLabel(user.getName());

            // Create a new follow button for each user
            JButton followButton = new JButton("Follow");
            followButton.setPreferredSize(new Dimension(15, 15));
            followButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Follow button clicked"
                            + "\nUser ID: " + user.getId()
                            + "\nUser Name: " + user.getName());


                    ControllerFactory controllerFactory = ControllerFactory.getInstance();

                    UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);
                    userController.follow(user.getEmail());
                    followButton.setText("Following");
                    followButton.setEnabled(false);
                    loadUsersWithFollowButton();
                }
            });

            // Add the name label and follow button to the panel
            usersPanel.add(nameLabel);
            usersPanel.add(followButton);
        }

        // Create a scroll pane for the users panel
        JScrollPane usersScrollPane = new JScrollPane(usersPanel);

        // Add the users scroll pane to jScrollPane2
        jScrollPane2.setViewportView(usersScrollPane);

    }

    // Inner class to render users with a follow button in the JList
//    class UserListCellRenderer extends JPanel implements ListCellRenderer<User> {
//
//        private JButton followButton;
//        private JLabel nameLabel;
//
//        public UserListCellRenderer() {
//            setLayout(new BorderLayout());
//
//            nameLabel = new JLabel();
//            followButton = new JButton("Follow");
//            followButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Get the selected user when the follow button is clicked
//                    User selectedUser = (User) followButton.getClientProperty("user");
//                    if (selectedUser != null) {
//                        System.out.println("Follow button clicked");
//                        System.out.println(selectedUser.getName());
//
//                        // Perform the follow action here
//                        // For example: userController.follow(selectedUser);
//                    }
//                }
//            });
//            add(nameLabel, BorderLayout.CENTER);
//            add(followButton, BorderLayout.EAST);
//            followButton.addActionListener(new ActionList
//        }
//
//        @Override
//        public Component getListCellRendererComponent(JList<? extends User> list, User user, int index,
//                                                      boolean isSelected, boolean cellHasFocus) {
//            nameLabel.setText(user.getName());
//            followButton.putClientProperty("user", user);
//
//            return this;
//        }
//    }

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        ControllerFactory controllerFactory = ControllerFactory.getInstance();

        UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);
        userController.logout();

        new LoginForm().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_logOutButtonActionPerformed

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        ControllerFactory controllerFactory = ControllerFactory.getInstance();

        UserController userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerType.USER);

        String content = postTextArea.getText().trim();

        // check if content is empty
        if(content.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Post content cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userController.post(content);
        postTextArea.setText("");
        loadPost();
    }//GEN-LAST:event_postButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea allPostTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton postButton;
    private javax.swing.JTextArea postTextArea;
    // End of variables declaration//GEN-END:variables
}
