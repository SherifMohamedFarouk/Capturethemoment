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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

public class VideoRecording extends javax.swing.JFrame {

    String args[];
    String name;
    static JFrame frame = new JFrame();
    static String DN = "DataBase";
    static String fn = "DataName" + ".txt";
    static String fP = "DataPath" + ".txt";

    public VideoRecording() {
        initComponents();

        File directory = new File(DN);
        if (!directory.exists()) {
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        File file = new File(DN + "/" + fn);
        if (!file.exists()) {
            try {
                Object result = JOptionPane.showInputDialog(frame, "Enter User Name:");
                name = result.toString();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(name);
                bw.close();
                jLabel4.setText(name);
                File directory1 = new File("Videos");
                if (!directory1.exists()) {
                    directory1.mkdir();
                    // If you require it to make the entire directory path including parents,
                    // use directory.mkdirs(); here instead.
                }
                File directory2 = new File("Videos//" + name);
                if (!directory2.exists()) {
                    directory2.mkdir();
                    // If you require it to make the entire directory path including parents,
                    // use directory.mkdirs(); here instead.
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        } else {
            FileReader fr;
            try {
                fr = new FileReader(file);
                LineNumberReader ln = new LineNumberReader(fr);
                while (ln.getLineNumber() == 0) {
                    String s = ln.readLine();
                    name = s;
                    jLabel4.setText(name);
                    System.out.println(s);

                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//         FileReader fr;
//          try {
//              
//              if (fr == null)
//              fr = new FileReader("DataBase//"+"DataName"+ ".txt");
//               LineNumberReader ln = new LineNumberReader(fr);
//               
//            while (ln.getLineNumber() == 0){
//               
//              String s = ln.readLine();
//              if (s == null){
//                 System.out.println(s);
//                 Object result = JOptionPane.showInputDialog(frame, "Enter an AES key:"); 
//                name = result.toString();
//               jLabel4.setText(name);
//               File(name, DN, fn);
//              }
//              
//              System.out.println(s);
//             jLabel4.setText(s);
//         
//            }
//        
//          } catch (FileNotFoundException ex) {
//              Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
//          } catch (IOException ex) {
//              Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
//          }
//         
//        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setText("Record");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 420, 330, 40);

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Exit");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(300, 470, 190, 30);

        jButton3.setText("Watch last Record");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(230, 380, 150, 21);

        jButton4.setText("Save last Record");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(390, 380, 170, 21);

        jButton5.setText("Existing User");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(510, 120, 250, 30);

        jButton6.setText("New User");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(510, 160, 250, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("User  :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 130, 130, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Moments");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 10, 350, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 130, 350, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capturethemoment/free-download-vintage-camera-wallpaper-for-desktop-mobiles-800x600.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 1420, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FileReader fr;
        try {
            fr = new FileReader("DataBase//" + "DataName" + ".txt");
            CaptureTheMoment l = new CaptureTheMoment(fr);
            l.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String a[] = args;
        a = null;

        Algorithms.doLaunch(a);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FileReader fr;
        try {
            fr = new FileReader("DataBase//" + "DataName" + ".txt");
            LineNumberReader ln = new LineNumberReader(fr);
            while (ln.getLineNumber() == 0) {
                String s = ln.readLine();
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to save the vedio ?", "Save",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {

                    File directory = new File("Videos");
                    if (!directory.exists()) {
                        directory.mkdir();
                        // If you require it to make the entire directory path including parents,
                        // use directory.mkdirs(); here instead.
                    }
                    File directory2 = new File("Videos//" + s);
                    if (!directory2.exists()) {
                        directory2.mkdir();
                        // If you require it to make the entire directory path including parents,
                        // use directory.mkdirs(); here instead.
                    }
                    if (writeFile.getLatestFilefromDir("Videos//" + s) == null) {
                        writeFile.copyfile("output.mp4", "2018", "Videos//" + s);
                    } else {
                        int f = Integer.parseInt(writeFile.getLatestFilefromDir("Videos//" + s));
                        f = f + 1;
                        String ve = String.format("%d", f);
                        writeFile.copyfile("output.mp4", ve, "Videos//" + s);

                    }

                    System.out.println(writeFile.getLatestFilefromDir("Videos//" + s));
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
                System.out.println(s);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        }

        String multiLineMsg[] = {"File has been saved", "please go and check"};
        JOptionPane.showMessageDialog(frame, multiLineMsg);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        File file = new File(DN + "/" + fn);
        try {
            Object result = JOptionPane.showInputDialog(frame, "Enter User Name:");
            name = result.toString();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name);
            bw.close();
            jLabel4.setText(name);
            File directory1 = new File("Videos");
            if (!directory1.exists()) {
                directory1.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }
            File directory2 = new File("Videos//" + name);
            if (!directory2.exists()) {
                directory2.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            } else {
                String multiLineMsg[] = {"That is an Existing User", "please chose another name"};
                JOptionPane.showMessageDialog(frame, multiLineMsg);

            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        FileReader fr;
        try {
            fr = new FileReader(file);
            LineNumberReader ln = new LineNumberReader(fr);
            while (ln.getLineNumber() == 0) {
                String s = ln.readLine();
                name = s;
                jLabel4.setText(name);
                System.out.println(s);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

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

    public static void File(String value, String directoryName, String fileName) {
//  
//      File file1 = new File("DataBase\\DataName.txt");
//        if (file1.exists()){
//         FileReader fr;
//          try {
//              fr = new FileReader(file1);
//               LineNumberReader ln = new LineNumberReader(fr);
//            while (ln.getLineNumber() == 0){
//              String s = ln.readLine();
//              System.out.println("The line is: "+ s);
//            }
//        
//          } catch (FileNotFoundException ex) {
//              Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
//          } catch (IOException ex) {
//              Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
//          }
//        }

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        File file = new File(directoryName + "/" + fileName);
        if (!file.exists()) {
            try {

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(value);
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        } else {
            FileReader fr;
            try {
                fr = new FileReader(file);
                LineNumberReader ln = new LineNumberReader(fr);
                while (ln.getLineNumber() == 0) {
                    String s = ln.readLine();

                    System.out.println(s);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

//    
//public static class GUI extends Application{
//  
//    private String Dir = System.getProperty("user.dir");
//       public static void doLaunch(String[] args){
//        launch(args);
//     }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//
//        //goes to user Directory
//        File f = new File( "output.mp4");
//
//        //Converts media to string URL
//        Media media = new Media(f.toURI().toURL().toString());
//        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
//        MediaView viewer = new MediaView(player);
//        //change width and height to fit video
//        DoubleProperty width = viewer.fitWidthProperty();
//        DoubleProperty height = viewer.fitHeightProperty();
//        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
//        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
//        viewer.setPreserveRatio(true);
//
//        StackPane root = new StackPane();
//        root.getChildren().add(viewer);
//
//        //set the Scene
//        Scene scenes = new Scene(root, 500, 500, Color.BLACK);
//        stage.setScene(scenes);
//        stage.setTitle("MediaPlayer");
//        stage.show();
//        player.play();
//     
//        player.setOnEndOfMedia(new Runnable() {
//            @Override
//            public void run() {
//                player.pause();
//                stage.hide();
//                
//            }
//        });
//        
//    }
//}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
