import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class ThisWaterLocList implements MouseListener{
    JFrame locListFrame;
    YurbassFishing yf = new YurbassFishing();
    int mouseClicX;
    int mouseClicY;
    JButton[] buttonLoc;
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
        locListFrame.addMouseListener(this);
        locListFrame.add(panel);

        for (int i =0; i<BaseList.baseList.length; i++){
            if (BaseList.baseList[i].name.equals(UserList.users[YurbassFishing.userSelect].baseNow)){
                for (int j =0; j<BaseList.baseList[i].locationsList.length; j++){
                    buttonLoc = new JButton[BaseList.baseList[i].locationsList.length];
                    int f = BaseList.baseList[i].locationsList.length;
                    System.out.println(f);
                    buttonLoc[i] = new JButton(new ImageIcon("src\\Image\\interface\\locbutton.gif"));
                    buttonLoc[i].setBounds(BaseList.baseList[i].locationsList[j].x, BaseList.baseList[i].locationsList[j].y, 45,42);
                    buttonLoc[i].setBorderPainted(false);
                    buttonLoc[i].setFocusPainted(false);
                    buttonLoc[i].setContentAreaFilled(false);
                    buttonLoc[i].setPressedIcon(new ImageIcon("src\\Image\\interface\\locbutton2.gif"));
                    buttonLoc[i].setRolloverIcon(new ImageIcon("src\\Image\\interface\\locbutton2.gif"));
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
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseClicX = mouseEvent.getX();
        mouseClicY = mouseEvent.getY();
        if (mouseEvent.getX()>80&&mouseEvent.getX()<220&&mouseEvent.getY()>560&&mouseEvent.getY()<580){
            yf.menu.setVisible(true);
            locListFrame.setVisible(false);
            locListFrame.dispose();
        }
        //locListFrame.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    static String imgPath(String s){//метод возвращает путь к картинке расположения локаций базы на которой сейчас игрок
        for (int i = 0; i< BaseList.baseList.length; i++){
            if (BaseList.baseList[i].name.equals(s)){
                s = BaseList.baseList[i].pathImage;
            }
        }
        return s;
    }
}
class LocPanel extends JPanel{
    BufferedImage background;
    BufferedImage locMap;
    BufferedImage globus;
    protected void paintComponent(Graphics g){
        try {
            background = ImageIO.read(new File("src\\\\Image\\\\interface\\\\mapsmall background.jpg"));
            locMap = ImageIO.read(new File(ThisWaterLocList.imgPath(UserList.users[YurbassFishing.userSelect].baseNow)));
            globus = ImageIO.read(new File("src\\\\Image\\\\interface\\\\globus.gif"));
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