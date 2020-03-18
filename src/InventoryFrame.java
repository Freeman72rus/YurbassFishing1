import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class InventoryFrame extends JFrame implements MouseListener, ActionListener, ChangeListener, MouseMotionListener {
    JFrame inventFrame;
    YurbassFishing yf = new YurbassFishing();
    JButton backButton;
    JButton differButton;
    JLabel spinImage;
    JLabel info;
    JComboBox spinCB;
    JPanel spinPanel;
    String[] spinInventList;
    Tackle[] tacklesList = new Tackle[100];


    InventoryFrame(){
        yf.menu.setVisible(false);
        inventFrame = new JFrame("Инвентарь");
        inventFrame.setSize(800,600);
        inventFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        inventFrame.setResizable(false);
        inventFrame.setLocationRelativeTo(null);
        inventFrame.setLayout(null);
        InventoryPanel panel = new InventoryPanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        //кнопку назад и разное
        backButton = new JButton(new ImageIcon("src\\\\Image\\\\interface\\\\in_back.png"));
        backButton.setRolloverIcon(new ImageIcon("src\\\\Image\\\\interface\\\\in_back1.png"));
        buttonSetting(backButton);
        backButton.setActionCommand("выход");
        backButton.setBounds(685,524,85,30);
        differButton = new JButton(new ImageIcon("src\\\\Image\\\\interface\\\\in_differ.png"));
        differButton.setRolloverIcon(new ImageIcon("src\\\\Image\\\\interface\\\\in_differ1.png"));
        buttonSetting(differButton);
        differButton.setActionCommand("разное");
        differButton.setBounds(685, 492, 85,30);
        spinImage = new JLabel("");
        //создание выпадающего списка спиннингов
        createSpinList();
        spinCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int spinIndex = spinCB.getSelectedIndex();
                tacklesList[spinIndex] = new Tackle(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[spinIndex]);
                spinImage.setIcon(new ImageIcon(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[spinIndex].spinPathImage));
                System.out.println(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[spinIndex].spinPathImage);
                spinImage.setBounds(100,150,200,200);
            }
        });


        panel.add(backButton);
        panel.add(differButton);
        panel.add(spinCB);
        panel.add(spinImage);



        inventFrame.add(panel);
        inventFrame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("выход")){
            yf.menu.setVisible(true);
            inventFrame.setVisible(false);
            inventFrame.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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

    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
    void buttonSetting(JButton button){
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        button.addChangeListener(this);
        button.addMouseMotionListener(this);
    }
    void createSpinList(){
        spinPanel = new JPanel();
        spinInventList = new String[100];
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; i++){
                spinInventList[i] = UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[i].spinName;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        spinCB = new JComboBox(spinInventList);
        try{
            for (int i = 0; i < spinInventList.length; ){
                if (spinInventList[i] == null){
                    spinCB.removeItemAt(i);
                }
                else i++;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());;
        }
        spinCB.setBounds(45,16,230,20);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InventoryFrame();
            }
        });
    }
}
class InventoryPanel extends JPanel{
    BufferedImage imageBackground;
    protected void paintComponent(Graphics g){
        try {
            imageBackground = ImageIO.read(new File("src\\Image\\interface\\invent.jpg"));
            g.drawImage(imageBackground, 0,0, null);
            //g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
            //g.drawString("назад", 680, 550);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
