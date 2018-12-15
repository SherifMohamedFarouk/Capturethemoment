package capturethemoment;
 import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;






public class Algorithms {

        public static void  doLaunch(final String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                     chargerLibrairie();
                     new Algorithms(args);
                }
            });
        }

       static void chargerLibrairie(){
             NativeLibrary.addSearchPath(
                    RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
            LibXUtil.initialise();
        }
       
        private Algorithms(String[] args) {
            JFrame frame = new JFrame("Tutoriel vlcj");
            frame.setLocation(600,150);
            frame.setSize(700, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            //Créer une instance de Canvas
            Canvas c = new Canvas();
            //L'arrière plan de la vidéo est noir par défaut
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            //La vidéo prend toute la surface
            p.add(c, BorderLayout.CENTER);
            frame.add(p, BorderLayout.CENTER);

            //Créer une instance factory
            MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
            //Créer une instance lecteur média
            EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new     Win32FullScreenStrategy(frame));
            mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
            //Plein écran
            
            //Cacher le curseur de la souris à l'intérieur de JFrame
            mediaPlayer.setEnableMouseInputHandling(false);
            //Désactiver le clavier à l'intérieur de JFrame
            mediaPlayer.setEnableKeyInputHandling(true);
           
            //Préparer le fichier
            mediaPlayer.prepareMedia("output.mp4");
            //lire le fichier 
            mediaPlayer.play();
                                new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
               mediaPlayer.stop();
              frame.setVisible(false);
             

            }
        }, 
      6000
             
);
   
            
        }

    Algorithms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
