import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class LocFrame extends JFrame implements ActionListener, ChangeListener, MouseMotionListener, MouseListener {
    static JFrame locFrame;
    JButton backButton;
    JButton inventButton;
    JButton settingButton;
    JButton cageButton;
    InventoryFrame inventoryFrame;
    static JLabel clock = new JLabel(YurbassFishing.clockStr);
    static JLabel baits = new JLabel("");
    static JLabel spinSelectLabel = new JLabel("");
    static int s1 = -1;// флаги показывающие достан ли спиннинг и какой (номер по tackleList)
    static int s2 = -1;
    static int s3 = -1;
    static boolean spinSelect1 = false;//флаги показывающие какой спиннинг выбран в настоящий момент
    static boolean spinSelect2 = false;
    static boolean spinSelect3 = false;
    static int y1 = 255;
    static int y2 = 470;
    static int x1_1 = 100;
    static int x2_1 = 140;
    static int x1_2 = 300;
    static int x2_2 = 340;
    static int x1_3 = 500;
    static int x2_3 = 540;
    int mouseClickX;
    int mouseClickY;
    static Tackle spinning1 =  null;
    static Tackle spinning2 = null;
    static Tackle spinning3 = null;
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
        backButton.setToolTipText("На карту локаций");

        inventButton = new JButton(new ImageIcon(LocFrame.class.getResource("/Image/interface/inv1.png")));
        inventButton.setRolloverIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/inv2.png")));
        buttonSetting(inventButton);
        inventButton.setActionCommand("invent");
        inventButton.setBounds(650,485,100,25);

        clock.setBounds(95,483,100,30);
        clock.setFont(new Font("Arial", Font.BOLD, 16));

        baits.setBounds(550,500,80,80);



        locFrame.addMouseListener(this);
        panel.add(backButton);
        panel.add(clock);
        panel.add(inventButton);
        panel.add(baits);
        panel.add(spinSelectLabel);
        locFrame.setVisible(true);
    }

    private void spinZabros() {
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("back")){
            ThisWaterLocList.locListFrame.setVisible(true);
            locFrame.setVisible(false);
            locFrame.dispose();
            ThisWaterLocList.flagEnterLoc = false;
            s1 = -1;
            s2 = -1;
            s3 = -1;
            spinSelect1 = false;
            spinSelect2 = false;
            spinSelect3 = false;
        }
        if (ae.getActionCommand().equals("invent")){
            inventoryFrame = new InventoryFrame();
            locFrame.setVisible(false);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClickX = e.getX();
        mouseClickY = e.getY();
        if (s1!=-1&&mouseClickX>x1_1&&mouseClickX<x2_1&&mouseClickY>y1&&mouseClickY<y2){
            spinSelect1 = true;
            spinSelect2 = spinSelect3 = false;
            spinSelectLabel.setBounds(x2_1-30, y2-20, 17,17);
            spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
            baits.setIcon(SelectUser.tacklesList[InventoryFrame.spinIndex].baitsT.baitsSmallImage);
            if (e.getClickCount() == 2){
                spinSelect1 = false;
                s1 = -1;
                spinSelectLabel.setIcon(null);
                baits.setIcon(null);
            }
        }
        if (s2!=-1&&mouseClickX>x1_2&&mouseClickX<x2_2&&mouseClickY>y1&&mouseClickY<y2){
            spinSelect2 = true;
            spinSelect1 = spinSelect3 = false;
            spinSelectLabel.setBounds(x2_2-30, y2-20, 17,17);
            spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
            if (e.getClickCount() == 2){
                spinSelect2 = false;
                s2 = -1;
                spinSelectLabel.setIcon(null);
                baits.setIcon(null);
            }
        }
        if (s3!=-1&&mouseClickX>x1_3&&mouseClickX<x2_3&&mouseClickY>y1&&mouseClickY<y2){
            spinSelect3 = true;
            spinSelect1 = spinSelect2 = false;
            spinSelectLabel.setBounds(x2_3-30, y2-20, 17,17);
            spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
            if (e.getClickCount() == 2){
                spinSelect3 = false;
                s3 = -1;
                spinSelectLabel.setIcon(null);
                baits.setIcon(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class LocFramePanel extends JPanel{
    BufferedImage locImageD;
    BufferedImage locImageN;
    BufferedImage downPanel;
    BufferedImage timePanel;
    BufferedImage spin1;
    BufferedImage spin2;
    BufferedImage spin3;
    static int time = 0;
    protected void paintComponent(Graphics g){
        try {
            locImageD = ImageIO.read(getClass().getResource(YurbassFishing.nowBase.locationsList[ThisWaterLocList.nowLoc.number].locImageDayPath));
            locImageN = ImageIO.read(getClass().getResource(YurbassFishing.nowBase.locationsList[ThisWaterLocList.nowLoc.number].locImageNightPath));
            downPanel = ImageIO.read(getClass().getResource("/Image/interface/panel.gif"));
            timePanel = ImageIO.read(getClass().getResource("/Image/interface/scenetime.gif"));
            spin1 = spin2 = spin3 = ImageIO.read(getClass().getResource("/Image/Animation/speen(normal).gif"));
            if (YurbassFishing.hours>5 && YurbassFishing.hours<23){
                g.drawImage(locImageD, 0,0, null);
            }
            else {
                g.drawImage(locImageN, 0,0, null);
            }
            if (LocFrame.s1!=-1){
                g.drawImage(spin1, LocFrame.x1_1, LocFrame.y1, null);
                repaint();
            }
            if (LocFrame.s2!=-1){
                g.drawImage(spin2, LocFrame.x1_2, LocFrame.y1, null);
                repaint();
            }
            if (LocFrame.s3!=-1){
                g.drawImage(spin3, LocFrame.x1_3, LocFrame.y1, null);
                repaint();
            }
            /*Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("frewff");
                }
            });
            timer.start();*/


            g.drawImage(downPanel, 0,466, null);
            g.drawImage(timePanel, 80,485, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
