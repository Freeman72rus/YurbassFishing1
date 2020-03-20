
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
    JButton lineListButton;
    JLabel spinImage;
    JLabel lineInfo;
    JLabel hookImage;
    JLabel spoonImage;
    JLabel baitsImage;
    JLabel katImage;
    JLabel info = new JLabel("");
    JComboBox spinCB;
    JList lineList;
    JScrollPane lineScroll;
    JTabbedPane jtab;
    JPanel spinPanel;
    String[] spinInventList;
    String[] lineInventList;
    int mouseClicX;
    int mouseClicY;
    int spinIndex = -1;


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
        lineInfo = new JLabel("");
        lineInfo.setBounds(330,140,200,200);
        hookImage = new JLabel("");
        spoonImage = new JLabel("");
        baitsImage = new JLabel("");
        katImage = new JLabel("");
        lineListButton = new JButton("");
        buttonSetting(lineListButton);
        lineListButton.setBounds(675,160,110,75);
        lineListButton.setActionCommand("line");
        //создание выпадающего списка спиннингов
        createAllTangleList();
        jtab = new JTabbedPane(SwingConstants.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.add("", lineScroll);
        jtab.setLayout(null);
        jtab.setBounds(430,10,230,180);
        info.setBounds(50,30,250,40);
        inventFrame.addMouseListener(this);


        spinCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spinIndex = spinCB.getSelectedIndex();
                spinImage.setIcon(new ImageIcon(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[spinIndex].spinPathImage));
                spinImage.setBounds(100,150,200,200);
                try {
                    if (SelectUser.tacklesList[spinIndex].lineT != null&&SelectUser.tacklesList[spinIndex].lineT.tackleNumber == spinIndex){
                        lineInfo.setText("<html>Леска<br>" +  ((int)SelectUser.tacklesList[spinIndex].lineT.lineCapacity/1000) + " кг<br>" + "Длина " + SelectUser.tacklesList[spinIndex].lineT.lineLength + " м");
                    }
                    else lineInfo.setText("");
                    if (SelectUser.tacklesList[spinIndex].hookT != null){
                        hookImage.setIcon(new ImageIcon(SelectUser.tacklesList[spinIndex].hookT.hookPathImage));
                        hookImage.setBounds(200,200,100,100);
                    }
                /*if (tacklesList[spinIndex].spoonT != null){
                    spoonImage.setIcon(new ImageIcon(tacklesList[spinIndex].spoonT.spoonPathImage));
                    spoonImage.setBounds(200,300,100,100);
                }*/
                    if (SelectUser.tacklesList[spinIndex].baitsT != null){
                        baitsImage.setIcon(new ImageIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsPathImage));
                        baitsImage.setBounds(200,400,100,100);
                    }
                    if (SelectUser.tacklesList[spinIndex].katushkaT != null){
                        katImage.setIcon(new ImageIcon(SelectUser.tacklesList[spinIndex].katushkaT.katPathImage));
                        katImage.setBounds(200,500,100,100);
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage() + " ferge");
                }

            }
        });
        lineList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    int j = -1;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    j = spinCB.getSelectedIndex();
                    System.out.println(i);
                    if (j != -1&&UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber == -1){
                        /*if (tacklesList[j].lineT != null){
                            tacklesList[j].lineT.tackleNumber = -1;
                        }*/
                        UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber = j;
                        SelectUser.tacklesList[j].lineT = UserList.users[YurbassFishing.userSelect].inventory.linesUser[i];
                        //lineInfo.setText("<html>Леска<br>" + ((int)UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineCapacity/1000) + " кг<br>" + "Длина " + UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineLength + " м");
                        lineInfo.setText("<html>Леска<br>" +  ((int)SelectUser.tacklesList[spinIndex].lineT.lineCapacity/1000) + " кг<br>" + "Длина " + SelectUser.tacklesList[spinIndex].lineT.lineLength + " м");
                    }
                    else if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber != -1){
                        info.setText("Леска установлена на комплект " + (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber+1));
                    }
                    else{
                        info.setText("");
                    }
                }
            }
        });


        panel.add(backButton);
        panel.add(differButton);
        panel.add(lineListButton);
        panel.add(lineInfo);
        panel.add(info);
        panel.add(spinCB);
        panel.add(spinImage);
        panel.add(jtab);



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
        if (ae.getActionCommand().equals("line")){
            jtab.setSelectedIndex(0);
            //lineScroll.setSize(200,200);
            //lineScroll.setBounds(200,200,200,200);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseClicX = mouseEvent.getX();
        mouseClicY = mouseEvent.getY();
        spinIndex = spinCB.getSelectedIndex();
        try{
            if (mouseClicX>310&&mouseClicX<415&&mouseClicY>200&&mouseClicY<295){
                if (mouseEvent.getClickCount() == 2){
                    lineInfo.setText("");
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.linesUser.length;k++){
                        if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber == spinIndex){
                            UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber = -1;
                            SelectUser.tacklesList[spinIndex].lineT.tackleNumber = -1;
                            System.out.println(UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber);
                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
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
    void createAllTangleList(){
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

        int j = 1;
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineName.contains("кг")){
                    j++;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(j);
        lineInventList = new String[j];
        lineList = new JList(lineInventList);
        lineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            int k = 0;
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineName.contains("кг")){
                    lineInventList[k] = UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineName;
                    k++;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        lineScroll = new JScrollPane(lineList);
        lineScroll.setBounds(0,0,230,180);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}