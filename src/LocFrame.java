import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

class LocFrame extends JFrame implements ActionListener, ChangeListener, MouseMotionListener {
    JFrame locFrame;
    JButton backButton;
    JButton inventButton;
    JButton settingButton;
    JButton cageButton;

    LocFrame(){
        ThisWaterLocList.locListFrame.setVisible(false);
        locFrame = new JFrame(YurbassFishing.nowBase.name + ": " + ThisWaterLocList.nowLoc.locName);
        locFrame.setSize(816,630);
        locFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        locFrame.setLayout(null);
        locFrame.setResizable(false);
        locFrame.setLocationRelativeTo(null);
        LocFramePanel panel = new LocFramePanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        locFrame.add(panel);

        backButton = new JButton("");
        buttonSetting(backButton);
        backButton.setActionCommand("back");
        backButton.setBounds(760,479,40,40);



        panel.add(backButton);
        locFrame.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("back")){
            ThisWaterLocList.locListFrame.setVisible(true);
            locFrame.setVisible(false);
            locFrame.dispose();
        }
    }
    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LocFrame();
            }
        });
    }
    void buttonSetting(JButton button){
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        button.addChangeListener(this);
        button.addMouseMotionListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
class LocFramePanel extends JPanel{
    BufferedImage locImageD;
    BufferedImage locImageN;
    BufferedImage downPanel;
    protected void paintComponent(Graphics g){
        try {
            locImageD = ImageIO.read(getClass().getResource(YurbassFishing.nowBase.locationsList[ThisWaterLocList.nowLoc.number].locImageDayPath));
            locImageN = ImageIO.read(getClass().getResource(YurbassFishing.nowBase.locationsList[ThisWaterLocList.nowLoc.number].locImageNightPath));
            downPanel = ImageIO.read(getClass().getResource("/Image/interface/panel.gif"));
            if (YurbassFishing.hours>5 && YurbassFishing.hours<23){
                g.drawImage(locImageD, 0,0, null);
            }
            else {
                g.drawImage(locImageN, 0,0, null);
            }
            g.drawImage(downPanel, 0,466, null);
            /*g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("Главное меню", 80, 580);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString(UserList.users[YurbassFishing.userSelect].baseNow, 390, 40);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
