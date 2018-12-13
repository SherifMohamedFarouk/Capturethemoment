
package capturethemoment;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import static javafx.application.Application.launch;

public class VideoRecording extends javax.swing.JFrame {
String args[] ;
  
       
    public VideoRecording() {
        initComponents();
        
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setText("Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 410, 200, 50);

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 470, 120, 25);

        jButton3.setText("Watch last Vedio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(370, 350, 150, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capturethemoment/Wallpapers-Camera-Gallery-78-Plus-PIC-WPW1012793.jpg.pagespeed.ce.dGTjytGD0t.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-470, 0, 1420, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        CaptureTheMoment l = new CaptureTheMoment();
       l.setVisible(true);      
               
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String a[] = args ;
   
     GUI.doLaunch(a);
               
           
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoRecording().setVisible(true);
                
            }
        });
    }
    
public static class GUI extends Application{
  
    private String Dir = System.getProperty("user.dir");
       public static void doLaunch(String[] args){
        launch(args);
     }

    @Override
    public void start(Stage stage) throws Exception {

        //goes to user Directory
        File f = new File( "output.mp4");

        //Converts media to string URL
        Media media = new Media(f.toURI().toURL().toString());
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);

        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root, 500, 500, Color.BLACK);
        stage.setScene(scenes);
        stage.setTitle("MediaPlayer");
        stage.show();
        player.play();
        player.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                player.stop();
                stage.close();
            }
        });
    }
}
    
    
     
     
     
     
     
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
