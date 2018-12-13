
package capturethemoment;
import tablelayout.swing.Table;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import static java.lang.Thread.sleep;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class CaptureTheMoment extends JFrame {
    
    private JLabel text1;
    private JLabel text2;
    private JPanel canvas;
    private static FFmpegFrameRecorder recorder = null;
    private static OpenCVFrameGrabber grabber = null;
    private static final int WEBCAM_DEVICE_INDEX = 0;
    private static final int CAPTUREWIDTH = 700;
    private static final int CAPTUREHRIGHT = 700;
    private static final int FRAME_RATE = 30;
    private static final int GOP_LENGTH_IN_FRAMES = 60;
    private volatile boolean runnable = true;
    private static final long serialVersionUID = 1L;
    private Catcher cat;
    private Thread catcher;
    String args[] ;
    public CaptureTheMoment() {
        grabber = new OpenCVFrameGrabber(WEBCAM_DEVICE_INDEX);
        cat = new Catcher();

        setTitle("Camera Recorder");
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        text1 = new JLabel("  ");
        text2 = new JLabel(" ");
        canvas = new JPanel();
        Table table = new Table();
        table.pad(40);
        getContentPane().add(table);
        canvas.setBorder(BorderFactory.createEtchedBorder());
        table.addCell(canvas).width(CAPTUREWIDTH).height(CAPTUREHRIGHT);
        table.row();
        table.addCell(text1);
        table.row();
        table.addCell(text2);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
         
            catcher = new Thread(cat);
            catcher.start();
            runnable = true;
            text1.setText("<html><font color='red'>Recording ...</font></html>");
             new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
             
                try {
                    catcher.stop();
                    recorder.stop();
                    grabber.stop();
                    runnable = false;
                    
                    text1.setText("");
                    setVisible(false);
                    
    
     
                         
               
                } catch (Exception ex) {
                    Logger.getLogger(CaptureTheMoment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FrameGrabber.Exception ex) {
                    Logger.getLogger(CaptureTheMoment.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }, 
      9000
             
);
             
                                  new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
               GUI.doLaunch(args);
         
             

            }
        }, 
      9000
             
);
   
       
    }
     class Catcher implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
               // while (runnable) {
                    try {
                        grabber.setImageWidth(CAPTUREWIDTH);
                        grabber.setImageHeight(CAPTUREHRIGHT);
                        grabber.start();
                        recorder = new FFmpegFrameRecorder(
                                "output.mp4",
                                CAPTUREWIDTH, CAPTUREHRIGHT, 2);
                        recorder.setInterleaved(true);
                        // video options //
                        recorder.setVideoOption("tune", "zerolatency");
                        recorder.setVideoOption("preset", "ultrafast");
                        recorder.setVideoOption("crf", "28");
                        recorder.setVideoBitrate(2000000);
                        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
                        recorder.setFormat("mp4");
                        recorder.setFrameRate(FRAME_RATE);
                        recorder.setGopSize(GOP_LENGTH_IN_FRAMES);
                        // audio options //
                        recorder.setAudioOption("crf", "0");
                        recorder.setAudioQuality(0);
                        recorder.setAudioBitrate(192000);
                        recorder.setSampleRate(44100);
                        recorder.setAudioChannels(2);
                        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);

                        recorder.start();

                        Frame capturedFrame = null;
                        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
                        long startTime = System.currentTimeMillis();
                        long frame = 0;
                        while ((capturedFrame = grabber.grab()) != null&&runnable) {
                            BufferedImage buff = paintConverter.getBufferedImage(capturedFrame, 1);
                            Graphics g = canvas.getGraphics();
                            g.drawImage(buff, 0, 0, CAPTUREWIDTH, CAPTUREHRIGHT, 0, 0, buff.getWidth(), buff.getHeight(), null);
                            recorder.record(capturedFrame);
                            frame++;
                            long waitMillis = 1000 * frame / FRAME_RATE - (System.currentTimeMillis() - startTime);
                            while (waitMillis <= 0) {
                                // If this error appeared, better to consider lower FRAME_RATE.
                                System.out.println("[ERROR] grab image operation is too slow to encode, skip grab image at frame = " + frame + ", waitMillis = " + waitMillis);
                                recorder.record(capturedFrame);  // use same capturedFrame for fast processing.
                                frame++;
                                waitMillis = 1000 * frame / FRAME_RATE - (System.currentTimeMillis() - startTime);
                            }
                            //System.out.println("frame " + frame + ", System.currentTimeMillis() = " + System.currentTimeMillis() + ", waitMillis = " + waitMillis);
                            Thread.sleep(waitMillis);
                        }
                    } catch (FrameGrabber.Exception ex) {
                        Logger.getLogger(CaptureTheMoment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CaptureTheMoment.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(CaptureTheMoment.class.getName()).log(Level.SEVERE, null, ex);
                    }

                //}//end of while
            }
        }
    }
    
    
    
    public static void main(String[] args) {
         new CaptureTheMoment();
    }
    
    
    
    
    public static class GUI extends Application{
  
    private String Dir = System.getProperty("user.dir");
       public static void doLaunch(String[] args){
        launch(args);
     }

    @Override
    public void start(Stage stage) throws java.lang.Exception {

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
        Scene scenes = new Scene(root, 700, 700, javafx.scene.paint.Color.BLACK);
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
    
    
    
}
