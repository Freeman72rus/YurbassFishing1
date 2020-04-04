import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class ThisWaterLocList implements ActionListener{
    static JFrame locListFrame;
    YurbassFishing yf = new YurbassFishing();
    int mouseClicX;
    int mouseClicY;
    JButton[] buttonLoc;
    JButton backButton;
    final ImageIcon butLocIm = new ImageIcon(ThisWaterLocList.class.getResource("/Image/interface/locbutton.gif"));
    final ImageIcon butLocIm2 = new ImageIcon(ThisWaterLocList.class.getResource("/Image/interface/locbutton2.gif"));
    static LocationList.Location nowLoc = null;
    LocFrame locFrame;
    ThisWaterLocList(){
        yf.menu.setVisible(false);
        locListFrame = new JFrame();
        locListFrame.setSize(800,600);
        locListFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        locListFrame.setLayout(null);
        locListFrame.setResizable(false);
        locListFrame.setLocationRelativeTo(null);
        locListFrame.setUndecorated(true);
        LocPanel panel = new LocPanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        locListFrame.add(panel);
        backButton = new JButton("");
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        backButton.setBounds(80, 560,140,20);
        panel.add(backButton);

        for (int i =0; i<BaseList.baseList.length; i++){
            if (BaseList.baseList[i].name.equals(UserList.users[YurbassFishing.userSelect].baseNow)){
                for (int j =0; j<BaseList.baseList[i].locationsList.length; j++){
                    buttonLoc = new JButton[BaseList.baseList[i].locationsList.length];
                    buttonLoc[i] = new JButton(butLocIm);
                    buttonLoc[i].setBounds(BaseList.baseList[i].locationsList[j].x, BaseList.baseList[i].locationsList[j].y, 45,42);
                    buttonLoc[i].setBorderPainted(false);
                    buttonLoc[i].setFocusPainted(false);
                    buttonLoc[i].setContentAreaFilled(false);
                    buttonLoc[i].setPressedIcon(butLocIm2);
                    buttonLoc[i].setRolloverIcon(butLocIm2);
                    buttonLoc[i].addActionListener(this);
                    buttonLoc[i].setActionCommand(String.valueOf(j));
                    panel.add(buttonLoc[i]);
                }
            }
        }

        locListFrame.setVisible(true);
    }
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThisWaterLocList();
            }
        });
    }

    static String imgPath(String s){//метод возвращает путь к картинке расположения локаций базы на которой сейчас игрок
        for (int i = 0; i< BaseList.baseList.length; i++){
            if (BaseList.baseList[i].name.equals(s)){
                s = BaseList.baseList[i].pathImage;
            }
        }
        return s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("back")){
            yf.menu.setVisible(true);
            locListFrame.setVisible(false);
            locListFrame.dispose();
        }
        int locSel = -1;
        try{
            locSel = Integer.parseInt(e.getActionCommand());
        }
        catch (Exception ex){

        }
        if (locSel>-1){
            nowLoc = YurbassFishing.nowBase.locationsList[locSel];
            locFrame = new LocFrame();
            locListFrame.setVisible(false);
            locListFrame.dispose();
        }
    }
}
class LocPanel extends JPanel{
    BufferedImage background;
    BufferedImage locMap;
    BufferedImage globus;
    protected void paintComponent(Graphics g){
        try {
            background = ImageIO.read(getClass().getResource("/Image/interface/mapsmall_background.jpg"));
            locMap = ImageIO.read(getClass().getResource(ThisWaterLocList.imgPath(UserList.users[YurbassFishing.userSelect].baseNow)));
            globus = ImageIO.read(getClass().getResource("/Image/interface/globus.gif"));
            g.drawImage(background, 0,0, null);
            g.drawImage(locMap, 75,60, null);
            g.drawImage(globus, 185,560, null);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("Главное меню", 80, 580);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString(UserList.users[YurbassFishing.userSelect].baseNow, 390, 40);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}