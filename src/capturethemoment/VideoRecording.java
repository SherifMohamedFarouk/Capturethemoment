package capturethemoment;

import com.teamdev.jxcapture.EncodingParameters;
import com.teamdev.jxcapture.ImageCapture;
import com.teamdev.jxcapture.VideoCapture;
import com.teamdev.jxcapture.audio.AudioCodec;
import com.teamdev.jxcapture.audio.AudioEncodingParameters;
import com.teamdev.jxcapture.audio.AudioSource;
import com.teamdev.jxcapture.video.VideoFormat;
import com.teamdev.jxcapture.video.VideoSource;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        
         jFileChooser2.setCurrentDirectory(new java.io.File("Videos"));
       jFileChooser2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
       jFileChooser2.setAcceptAllFileFilterUsed(false);
        jFileChooser2.setMultiSelectionEnabled(true);

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
        jPanel3 = new javax.swing.JPanel();
        jFileChooser2 = new javax.swing.JFileChooser();
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
        jButton1.setBounds(320, 510, 330, 40);

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Exit");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 560, 190, 30);

        jButton3.setText("Watch last Record");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(320, 480, 150, 21);

        jButton4.setText("Save last Record");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(480, 480, 170, 21);

        jButton5.setText("Existing User");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(700, 100, 250, 30);

        jButton6.setText("New User");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(700, 150, 250, 30);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 4));

        jFileChooser2.setBackground(new java.awt.Color(0, 102, 102));
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 190, 730, 260);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("User  :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 110, 130, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Moments");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(370, 10, 350, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 110, 350, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capturethemoment/WhatsApp Image 2019-01-15 at 6.13.33 PM.jpeg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VideoCapture videoCapture = VideoCapture.create(VideoFormat.WMV);

        java.util.List<VideoSource> availableVideoSources = VideoSource.getAvailable();
        System.out.println("availableVideoSources = " + availableVideoSources);

        if (availableVideoSources.isEmpty()) {
            throw new IllegalStateException("No external video sources available");
        }

        VideoSource webCamera = availableVideoSources.get(0);
        System.out.println("webCamera = " + webCamera);

        videoCapture.setVideoSource(webCamera);

        java.util.List<com.teamdev.jxcapture.Codec> videoCodecs = videoCapture.getVideoCodecs();
        com.teamdev.jxcapture.Codec videoCodec = videoCodecs.get(0);
        System.out.println("videoCodec = " + videoCodec);

        EncodingParameters encodingParameters = new EncodingParameters(new File("output.mp4"));
        encodingParameters.setBitrate(500000);
        encodingParameters.setFramerate(10);
        encodingParameters.setKeyFrameInterval(1);
        encodingParameters.setCodec(videoCodec);

        System.out.println("Available audio recording sources:");
        java.util.List<AudioSource> audioSources = AudioSource.getAvailable();
        for (AudioSource audioSource : audioSources) {
            System.out.println("audioSource = " + audioSource);
        }
        if (audioSources.isEmpty()) {
            System.err.println("No audio sources available");
        } else {
            AudioSource audioSource = audioSources.get(0);
            System.out.println("Selected audio source = " + audioSource);
            videoCapture.setAudioSource(audioSource);

            java.util.List<AudioCodec> audioCodecs = videoCapture.getAudioCodecs();
            if (audioSources.isEmpty()) {
                System.err.println("No audio codecs available");
            } else {
                System.out.println("Available audio codecs:");
                for (AudioCodec audioCodec : audioCodecs) {
                    System.out.println("audioCodec = " + audioCodec);
                }

                // Enable and configure audio encoding
                AudioEncodingParameters audioEncoding = new AudioEncodingParameters();

                AudioCodec audioCodec = audioCodecs.get(0);
                System.out.println("Selected audio codec = " + audioCodec);
                audioEncoding.setCodec(audioCodec);

                encodingParameters.setAudioEncoding(audioEncoding);
            }
        }
        System.out.println("encodingParameters = " + encodingParameters);
        ImageCapture webCameraImageCapture = ImageCapture.create();
        webCameraImageCapture.setImageSource(webCamera);
        WebCameraView webCameraView = new WebCameraView(webCameraImageCapture);
        webCameraView.show();
        videoCapture.start(encodingParameters);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                videoCapture.stop();
                webCameraView.hide();
                 try {
            Desktop.getDesktop().open(new File("output.mp4"));
        } catch (IOException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        }
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                    @Override
                    public void run() {

                        try {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
                            LocalDateTime now = LocalDateTime.now();
                            System.out.println(dtf.format(now));
                            FileReader fr;

                            fr = new FileReader("DataBase//" + "DataName" + ".txt");
                            LineNumberReader ln = new LineNumberReader(fr);
                            while (ln.getLineNumber() == 0) {
                                String s = ln.readLine();
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                int response = JOptionPane.showConfirmDialog(null, "Do you want to save the video ?", "Save",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (response == JOptionPane.NO_OPTION) {

                                } else if (response == JOptionPane.YES_OPTION) {
                                  
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response1 = JOptionPane.showConfirmDialog(null, "would you like to enter a new event ?", "Save",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response1 == JOptionPane.NO_OPTION) {
                        JFileChooser chooser = new JFileChooser();
                        chooser.setCurrentDirectory(new java.io.File("Videos//" + s));
                        chooser.setDialogTitle("choosertitle");
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        chooser.setAcceptAllFileFilterUsed(false);

                        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            System.out.println("getSelectedFile() : " + chooser.getSelectedFile().getName());
                            String n = chooser.getSelectedFile().getName();
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
                            File directory3 = new File("Videos//" + s + "//" + n);
                            if (!directory3.exists()) {
                                directory3.mkdir();
                                // If you require it to make the entire directory path including parents,
                                // use directory.mkdirs(); here instead.
                            }
                            if (writeFile.getLatestFilefromDir("Videos//" + s + "//" + n) == null) {
                                writeFile.copyfile("output.mp4", dtf.format(now), "Videos//" + s + "//" + n);
                            } else {
                                int f = Integer.parseInt(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                                f = f + 1;
                                String ve = String.format("%d", f);
                                writeFile.copyfile("output.mp4", ve, "Videos//" + s + "//" + n);
                                
                            }

                            System.out.println(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                        } else {
                            System.out.println("No Selection ");
                        }
                        String multiLineMsg[] = {"File has been saved", "please go and check"};
                                JOptionPane.showMessageDialog(frame, multiLineMsg);

                    } else if (response1 == JOptionPane.YES_OPTION) {
                        Object result = JOptionPane.showInputDialog(frame, "Enter the Event :");
                        String n = result.toString();

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
                        File directory3 = new File("Videos//" + s + "//" + n);
                        if (!directory3.exists()) {
                            directory3.mkdir();
                            // If you require it to make the entire directory path including parents,
                            // use directory.mkdirs(); here instead.
                        }
                        if (writeFile.getLatestFilefromDir("Videos//" + s + "//" + n) == null) {
                            writeFile.copyfile("output.mp4", dtf.format(now), "Videos//" + s + "//" + n);
                        } else {
                            int f = Integer.parseInt(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                            f = f + 1;
                            String ve = String.format("%d", f);
                            writeFile.copyfile("output.mp4", ve, "Videos//" + s + "//" + n);
                           
                        }

                        System.out.println(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                       String multiLineMsg[] = {"File has been saved", "please go and check"};
                                JOptionPane.showMessageDialog(frame, multiLineMsg);
                    } else if (response1 == JOptionPane.CLOSED_OPTION) {
                        System.out.println("JOptionPane closed");
                    }
                    System.out.println(s);
                                } else if (response == JOptionPane.CLOSED_OPTION) {
                                    System.out.println("JOptionPane closed");
                                }
                                System.out.println(s);
                            }
                        } //}//end of while
                        catch (FileNotFoundException ex) {
                            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                },
                        5000
                );

            }
        },
                5000
        );
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String a[] = args;
        a = null;

        try {
            Desktop.getDesktop().open(new File("output.mp4"));
        } catch (IOException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FileReader fr;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
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
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response1 = JOptionPane.showConfirmDialog(null, "would you like to enter a new event ?", "Save",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response1 == JOptionPane.NO_OPTION) {
                        JFileChooser chooser = new JFileChooser();
                        chooser.setCurrentDirectory(new java.io.File("Videos//" + s));
                        chooser.setDialogTitle("choosertitle");
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        chooser.setAcceptAllFileFilterUsed(false);

                        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            System.out.println("getSelectedFile() : " + chooser.getSelectedFile().getName());
                            String n = chooser.getSelectedFile().getName();
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
                            File directory3 = new File("Videos//" + s + "//" + n);
                            if (!directory3.exists()) {
                                directory3.mkdir();
                                // If you require it to make the entire directory path including parents,
                                // use directory.mkdirs(); here instead.
                            }
                            if (writeFile.getLatestFilefromDir("Videos//" + s + "//" + n) == null) {
                                writeFile.copyfile("output.mp4", dtf.format(now), "Videos//" + s + "//" + n);
                            } else {
                                int f = Integer.parseInt(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                                f = f + 1;
                                String ve = String.format("%d", f);
                                writeFile.copyfile("output.mp4", ve, "Videos//" + s + "//" + n);
                                
                            }

                            System.out.println(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                        } else {
                            System.out.println("No Selection ");
                        }
                        String multiLineMsg[] = {"File has been saved", "please go and check"};
                                JOptionPane.showMessageDialog(frame, multiLineMsg);

                    } else if (response1 == JOptionPane.YES_OPTION) {
                        Object result = JOptionPane.showInputDialog(frame, "Enter the Event :");
                        String n = result.toString();

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
                        File directory3 = new File("Videos//" + s + "//" + n);
                        if (!directory3.exists()) {
                            directory3.mkdir();
                            // If you require it to make the entire directory path including parents,
                            // use directory.mkdirs(); here instead.
                        }
                        if (writeFile.getLatestFilefromDir("Videos//" + s + "//" + n) == null) {
                            writeFile.copyfile("output.mp4", dtf.format(now), "Videos//" + s + "//" + n);
                        } else {
                            int f = Integer.parseInt(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                            f = f + 1;
                            String ve = String.format("%d", f);
                            writeFile.copyfile("output.mp4", ve, "Videos//" + s + "//" + n);
                           
                        }

                        System.out.println(writeFile.getLatestFilefromDir("Videos//" + s + "//" + n));
                       String multiLineMsg[] = {"File has been saved", "please go and check"};
                                JOptionPane.showMessageDialog(frame, multiLineMsg);
                    } else if (response1 == JOptionPane.CLOSED_OPTION) {
                        System.out.println("JOptionPane closed");
                    }
                    System.out.println(s);

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


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Videos"));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile().getName());
            File file = new File(DN + "/" + fn);
            try {
                name = chooser.getSelectedFile().getName();

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

        } else {
            System.out.println("No Selection ");
        }
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

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed

        System.out.println("getSelectedFile() : " + jFileChooser2.getSelectedFile());
        try {
            Desktop.getDesktop().open(new File(jFileChooser2.getSelectedFile().getAbsolutePath()));
        } catch (IOException ex) {
            Logger.getLogger(VideoRecording.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jFileChooser2ActionPerformed

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

    private static class WebCameraView {

        private static final Dimension VIEW_DIMENSIONS = new Dimension(700, 700);
        private static final Point VIEW_LOCATION = new Point(550, 120);
        private static final int UPDATE_INTERVAL = 100;

        private JWindow webCameraView;
        private BufferedImage snapshot;
        private Timer updateTimer;

        public WebCameraView(final ImageCapture webCameraCapture) {
            webCameraView = new JWindow() {
                @Override
                public void paint(Graphics g) {
                    if (snapshot != null) {
                        g.drawImage(snapshot, 0, 0, VIEW_DIMENSIONS.width, VIEW_DIMENSIONS.height, null);
                    }
                }
            };
            updateTimer = new Timer(UPDATE_INTERVAL, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    webCameraCapture.takeSnapshot();
                    if (snapshot != null) {
                        snapshot.flush();
                    }
                    snapshot = webCameraCapture.getImage();
                    webCameraView.repaint();
                }
            });
        }

        public void show() {

            webCameraView.setLocation(VIEW_LOCATION);
            webCameraView.setSize(VIEW_DIMENSIONS);
            webCameraView.setAlwaysOnTop(true);
            webCameraView.setVisible(true);
            updateTimer.start();
        }

        public void hide() {
            updateTimer.stop();
            webCameraView.dispose();
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
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
