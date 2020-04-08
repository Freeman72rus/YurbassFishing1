
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




class InventoryFrame extends JFrame implements MouseListener, ActionListener, ChangeListener, MouseMotionListener {
    static JFrame inventFrame;
    JButton backButton;
    JButton differButton;
    JButton lineListButton;
    JButton hookListButton;
    JButton baitsListButton;
    JButton katListButton;
    JButton getSpinButton;
    JLabel spinImage;
    JLabel lineInfo;
    JLabel hookImage;
    JLabel spoonImage;
    JLabel baitsImage;
    JLabel katImage;
    JLabel info = new JLabel("");
    JLabel info2 = new JLabel("");
    JLabel imageLabel = new JLabel("");
    JComboBox spinCB;
    JList lineList;
    JList hookList;
    JList baitsList;
    JList katList;
    JScrollPane lineScroll;
    JScrollPane hookScroll;
    JScrollPane baitsScroll;
    JScrollPane katScroll;
    JTabbedPane jtab;
    JPanel spinPanel;
    String[] spinInventListName;
    SpinningList.Spinning[] spinInventList;
    LineList.Line[] lineInventList;
    HookList.Hook[] hookInventList;
    BaitsList.Baits[] baitsInventList;
    KatushkaList.Katushka[] katInventList;
    String[] lineInventListName;
    String[] hookInventListName;
    String[] baitsInventListName;
    String[] katInventListName;
    int mouseClicX;
    int mouseClicY;
    int spinIndex = -1;
    int sp;


    InventoryFrame(){
        YurbassFishing.menu.setVisible(false);
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
        backButton = new JButton(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/in_back.png")));
        backButton.setRolloverIcon(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/in_back1.png")));
        buttonSetting(backButton);
        backButton.setActionCommand("выход");
        backButton.setBounds(685,524,85,30);
        differButton = new JButton(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/in_differ.png")));
        differButton.setRolloverIcon(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/in_differ1.png")));
        buttonSetting(differButton);
        differButton.setActionCommand("разное");
        differButton.setBounds(685, 492, 85,30);
        spinImage = new JLabel("");
        lineInfo = new JLabel("");
        lineInfo.setBounds(330,198,110,100);
        hookImage = new JLabel("");
        hookImage.setBounds(330, 320,110,100);
        spoonImage = new JLabel("");
        baitsImage = new JLabel("");
        baitsImage.setBounds(330, 440, 110, 100);
        katImage = new JLabel("");
        katImage.setBounds(330, 80,110,100);
        lineListButton = new JButton("");
        buttonSetting(lineListButton);
        lineListButton.setBounds(675,160,110,75);
        lineListButton.setActionCommand("line");
        hookListButton = new JButton("");
        buttonSetting(hookListButton);
        hookListButton.setBounds(675,240,110,75);
        hookListButton.setActionCommand("hook");
        baitsListButton = new JButton("");
        buttonSetting(baitsListButton);
        baitsListButton.setBounds(675,320, 110,75);
        baitsListButton.setActionCommand("baits");
        katListButton = new JButton("");
        buttonSetting(katListButton);
        katListButton.setBounds(675, 395, 110, 75);
        katListButton.setActionCommand("kat");
        getSpinButton = new JButton(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/getSpin1.png")));
        getSpinButton.setRolloverIcon(new ImageIcon(InventoryFrame.class.getResource("/Image/interface/getSpin2.png")));
        buttonSetting(getSpinButton);
        getSpinButton.setActionCommand("Достать");
        getSpinButton.setBounds(110,403,85,30);
        if (ThisWaterLocList.flagEnterLoc == true){
            panel.add(getSpinButton);
            getSpinButton.setEnabled(false);
        }

        createAllTangleList();

        jtab = new JTabbedPane(SwingConstants.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.add("", lineScroll);
        jtab.add("", hookScroll);
        jtab.add("", baitsScroll);
        jtab.add("", katScroll);
        jtab.setLayout(null);
        jtab.setBounds(430,10,230,180);
        info.setBounds(50,30,250,40);
        info2.setBounds(675,10, 100, 40);
        imageLabel.setBounds(450,215,190,220);
        inventFrame.addMouseListener(this);




        spinCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spinIndex = spinCB.getSelectedIndex();
                spinImage.setIcon(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[spinIndex].spinPathImage);
                spinImage.setBounds(100,150,200,200);
                System.out.println(spinIndex + "frekljg ");
                sp = spinIndex;
                if (spinIndex != -1){
                    getSpinButton.setEnabled(true);
                }

                try {
                    if ( SelectUser.tacklesList[spinIndex].lineT != null&& SelectUser.tacklesList[spinIndex].lineT.tackleNumber ==  SelectUser.tacklesList[spinIndex].spinT.spinCount){
                        lineInfo.setText("<html>Леска<br>" +  ((int) SelectUser.tacklesList[spinIndex].lineT.lineCapacity/1000) + " кг<br>" + "Длина " +  SelectUser.tacklesList[spinIndex].lineT.lineLength + " м");
                    }
                    else lineInfo.setText("");
                    if ( SelectUser.tacklesList[spinIndex].hookT != null){
                        hookImage.setIcon(SelectUser.tacklesList[spinIndex].hookT.hookSmallImage);
                    }
                    else hookImage.setIcon(null);
                /*if (tacklesList[spinIndex].spoonT != null){
                    spoonImage.setIcon(new ImageIcon(tacklesList[spinIndex].spoonT.spoonPathImage));
                    spoonImage.setBounds(200,300,100,100);
                }*/
                    if ( SelectUser.tacklesList[spinIndex].baitsT != null){
                        baitsImage.setIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsSmallImage);
                    }
                    else baitsImage.setIcon(null);
                    if (SelectUser.tacklesList[spinIndex].katushkaT != null&& SelectUser.tacklesList[spinIndex].katushkaT.tackleNumber ==  SelectUser.tacklesList[spinIndex].spinT.spinCount){
                        katImage.setIcon(SelectUser.tacklesList[spinIndex].katushkaT.katSmallImage);
                    }
                    else katImage.setIcon(null);
                }
                catch (Exception e){
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
                        try {
                            for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.linesUser.length;k++) {
                                if (j!=-1&&UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber == SelectUser.tacklesList[j].spinT.spinCount){
                                    UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber = -1;
                                    break;
                                }
                            }
                        }
                        catch (Exception ex){
                        }
                        if (j != -1&&UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber == -1){
                            UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].tackleNumber =  SelectUser.tacklesList[j].spinT.spinCount;
                             SelectUser.tacklesList[j].lineT = UserList.users[YurbassFishing.userSelect].inventory.linesUser[i];
                            lineInfo.setText("<html>Леска<br>" +  ((int) SelectUser.tacklesList[spinIndex].lineT.lineCapacity/1000) + " кг<br>" + "Длина " +  SelectUser.tacklesList[spinIndex].lineT.lineLength + " м");
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
        hookList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    int j = -1;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    j = spinCB.getSelectedIndex();
                    if (j != -1){
                        if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i].hookQuantity>0){
                            UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i].hookQuantity -= 1;
                            SelectUser.tacklesList[j].hookT = UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i];
                            hookImage.setIcon(SelectUser.tacklesList[spinIndex].hookT.hookSmallImage);
                            info2.setText(hookInventList[i].hookQuantity + " шт");
                        }
                    }
                }
            }
        });

        baitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    int j = -1;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    j = spinCB.getSelectedIndex();
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length;k++){
                        if (j != -1 && baitsInventListName[i].equals(UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsName)){
                            if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsQuantity>0){
                                UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsQuantity -= 1;
                                SelectUser.tacklesList[j].baitsT = UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k];
                                baitsImage.setIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsSmallImage);
                                info2.setText(baitsInventList[i].baitsQuantity + " шт");
                                break;
                            }
                        }
                    }
                }
            }
        });

        katList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    int j = -1;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    j = spinCB.getSelectedIndex();
                    try {
                        for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.katUser.length;k++) {
                            if (j!=-1&&UserList.users[YurbassFishing.userSelect].inventory.katUser[k].tackleNumber == SelectUser.tacklesList[j].spinT.spinCount){
                                UserList.users[YurbassFishing.userSelect].inventory.katUser[k].tackleNumber = -1;
                                break;
                            }
                        }
                    }
                    catch (Exception ex){
                    }
                    if (j != -1&&UserList.users[YurbassFishing.userSelect].inventory.katUser[i].tackleNumber == -1){
                        UserList.users[YurbassFishing.userSelect].inventory.katUser[i].tackleNumber =  SelectUser.tacklesList[j].spinT.spinCount;
                        SelectUser.tacklesList[j].katushkaT = UserList.users[YurbassFishing.userSelect].inventory.katUser[i];
                        katImage.setIcon(SelectUser.tacklesList[spinIndex].katushkaT.katSmallImage);
                    }
                    else if (UserList.users[YurbassFishing.userSelect].inventory.katUser[i].tackleNumber != -1){
                        info.setText("Катушка установлена на комплект " + (UserList.users[YurbassFishing.userSelect].inventory.katUser[i].tackleNumber+1));
                    }
                    else{
                        info.setText("");
                    }
                }
            }
        });

        lineList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index;
                index = ((JList)e.getSource()).getSelectedIndex();
                if (index != -1){
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.linesUser.length;k++){
                        if (lineInventList[index].tackleNumber == UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber){
                            info2.setText("Длина " + lineInventList[index].lineLength + " м");
                            imageLabel.setIcon(lineInventList[index].linePathImage);
                            break;
                        }
                    }
                }
                else {
                    info2.setText("");
                    imageLabel.setIcon(null);
                }
            }
        });

        hookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index;
                index = ((JList)e.getSource()).getSelectedIndex();
                if (index != -1){
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length;k++){
                        if (hookInventList[index].hookName.equals(UserList.users[YurbassFishing.userSelect].inventory.hooksUser[k].hookName)){
                            info2.setText(hookInventList[index].hookQuantity + " шт");
                            imageLabel.setIcon(hookInventList[index].hookPathImage);
                            break;
                        }
                    }
                }
                else {
                    info2.setText("");
                    imageLabel.setIcon(null);
                }
            }
        });

        //здесь вставить такой же обработчик для блёсен

        baitsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index;
                index = ((JList)e.getSource()).getSelectedIndex();
                if (index != -1){
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length;k++){
                        if (baitsInventList[index].baitsName.equals(UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsName)){
                            info2.setText(baitsInventList[index].baitsQuantity + " шт");
                            imageLabel.setIcon(baitsInventList[index].baitsPathImage);
                            break;
                        }
                    }
                }
                else {
                    info2.setText("");
                    imageLabel.setIcon(null);
                }
            }
        });

        katList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index;
                index = ((JList)e.getSource()).getSelectedIndex();
                if (index != -1){
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.katUser.length;k++){
                        if (katInventList[index].tackleNumber == UserList.users[YurbassFishing.userSelect].inventory.katUser[k].tackleNumber){
                            info2.setText("Износ " + (100 - katInventList[index].katSafety) + "%");
                            imageLabel.setIcon(katInventList[index].katPathImage);
                            break;
                        }
                    }
                }
                else {
                    info2.setText("");
                    imageLabel.setIcon(null);
                }
            }
        });


        panel.add(backButton);
        panel.add(differButton);
        panel.add(lineListButton);
        panel.add(hookListButton);
        panel.add(baitsListButton);
        panel.add(katListButton);
        panel.add(lineInfo);
        panel.add(hookImage);
        panel.add(baitsImage);
        panel.add(katImage);
        panel.add(info);
        panel.add(info2);
        panel.add(imageLabel);
        panel.add(spinCB);
        panel.add(spinImage);
        panel.add(jtab);



        inventFrame.add(panel);
        inventFrame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("выход")){
            if (ThisWaterLocList.flagEnterLoc == true){
                YurbassFishing.menu.setVisible(false);
                LocFrame.locFrame.setVisible(true);
            }
            else{
                YurbassFishing.menu.setVisible(true);
            }
            inventFrame.setVisible(false);
            inventFrame.dispose();
        }
        if (ae.getActionCommand().equals("line")){
            jtab.setSelectedIndex(0);
        }
        if (ae.getActionCommand().equals("hook")){
            jtab.setSelectedIndex(1);
        }
        if (ae.getActionCommand().equals("baits")){
            jtab.setSelectedIndex(2);
        }
        if (ae.getActionCommand().equals("kat")){
            jtab.setSelectedIndex(3);
        }
        if (ae.getActionCommand().equals("Достать")){
            if (SelectUser.tacklesList[spinIndex].lineT!=null&&SelectUser.tacklesList[spinIndex].katushkaT!=null&&SelectUser.tacklesList[spinIndex].hookT!=null&&SelectUser.tacklesList[spinIndex].baitsT!=null||SelectUser.tacklesList[spinIndex].lineT!=null&&SelectUser.tacklesList[spinIndex].katushkaT!=null&&SelectUser.tacklesList[spinIndex].spoonT!=null){
                if (LocFrame.s1 == -1){
                    if (LocFrame.s2!=SelectUser.tacklesList[spinIndex].spinT.spinCount&&LocFrame.s3!=SelectUser.tacklesList[spinIndex].spinT.spinCount){
                        LocFrame.s1 = SelectUser.tacklesList[spinIndex].spinT.spinCount;
                        LocFrame.locFrame.setVisible(true);
                        LocFrame.baits.setIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsSmallImage);
                        LocFrame.spinSelect1 = true;
                        LocFrame.spinSelect2 = LocFrame.spinSelect3 = false;
                        LocFrame.spinSelectLabel.setBounds(LocFrame.x2_1-30, LocFrame.y2-20, 17,17);
                        LocFrame.spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
                        inventFrame.setVisible(false);
                        inventFrame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog( null, "Этот спиннинг уже на воде", "", JOptionPane.DEFAULT_OPTION );
                    }
                }
                else if (LocFrame.s2 == -1){
                    if (LocFrame.s1!=SelectUser.tacklesList[spinIndex].spinT.spinCount&&LocFrame.s3!=SelectUser.tacklesList[spinIndex].spinT.spinCount){
                        LocFrame.s2 = SelectUser.tacklesList[spinIndex].spinT.spinCount;
                        LocFrame.locFrame.setVisible(true);
                        LocFrame.baits.setIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsSmallImage);
                        LocFrame.spinSelect2 = true;
                        LocFrame.spinSelect1 = LocFrame.spinSelect3 = false;
                        LocFrame.spinSelectLabel.setBounds(LocFrame.x2_2-30, LocFrame.y2-20, 17,17);
                        LocFrame.spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
                        inventFrame.setVisible(false);
                        inventFrame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog( null, "Этот спиннинг уже на воде", "", JOptionPane.DEFAULT_OPTION );
                    }
                }
                else if (LocFrame.s3 == -1){
                    if (LocFrame.s1!=SelectUser.tacklesList[spinIndex].spinT.spinCount&&LocFrame.s2!=SelectUser.tacklesList[spinIndex].spinT.spinCount){
                        LocFrame.s3 = SelectUser.tacklesList[spinIndex].spinT.spinCount;
                        LocFrame.locFrame.setVisible(true);
                        LocFrame.baits.setIcon(SelectUser.tacklesList[spinIndex].baitsT.baitsSmallImage);
                        LocFrame.spinSelect3 = true;
                        LocFrame.spinSelect1 = LocFrame.spinSelect2 = false;
                        LocFrame.spinSelectLabel.setBounds(LocFrame.x2_3-30, LocFrame.y2-20, 17,17);
                        LocFrame.spinSelectLabel.setIcon(new ImageIcon(LocFrame.class.getResource("/Image/interface/triangle.gif")));
                        inventFrame.setVisible(false);
                        inventFrame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog( null, "Этот спиннинг уже на воде", "", JOptionPane.DEFAULT_OPTION );
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog( null, "Спиннинг собран не полностью. Необходимые компоненты: леска, катушка, блесна или крючок и наживка", "", JOptionPane.DEFAULT_OPTION );
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseClicX = mouseEvent.getX();
        mouseClicY = mouseEvent.getY();
        spinIndex = spinCB.getSelectedIndex();
        try{
            if (mouseClicX>308&&mouseClicX<415&&mouseClicY>200&&mouseClicY<295){
                if (mouseEvent.getClickCount() == 2){
                    lineInfo.setText("");
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.linesUser.length;k++){
                        if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber == SelectUser.tacklesList[spinIndex].lineT.tackleNumber){
                            UserList.users[YurbassFishing.userSelect].inventory.linesUser[k].tackleNumber = -1;
                            break;
                        }
                    }
                    SelectUser.tacklesList[spinIndex].lineT = null;
                }
            }
            if (mouseClicX>308&&mouseClicX<415&&mouseClicY>320&&mouseClicY<417){
                if (mouseEvent.getClickCount() == 2){
                    hookImage.setIcon(null);
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length;k++){
                        if (SelectUser.tacklesList[spinIndex].hookT.hookName.equals(UserList.users[YurbassFishing.userSelect].inventory.hooksUser[k].hookName)){
                            UserList.users[YurbassFishing.userSelect].inventory.hooksUser[k].hookQuantity += 1;
                            info2.setText("");
                            break;
                        }
                    }
                    SelectUser.tacklesList[spinIndex].hookT = null;
                }
            }
            if (mouseClicX>308&&mouseClicX<415&&mouseClicY>440&&mouseClicY<537){
                if (mouseEvent.getClickCount() == 2){
                    baitsImage.setIcon(null);
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length;k++){
                        if (SelectUser.tacklesList[spinIndex].baitsT.baitsName.equals(UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsName)){
                            UserList.users[YurbassFishing.userSelect].inventory.baitsUser[k].baitsQuantity += 1;
                            info2.setText("");
                            break;
                        }
                    }
                    SelectUser.tacklesList[spinIndex].baitsT = null;
                }
            }
            if (mouseClicX>308&&mouseClicX<415&&mouseClicY>80&&mouseClicY<177){
                if (mouseEvent.getClickCount() == 2){
                    katImage.setIcon(null);
                    for (int k = 0; k<UserList.users[YurbassFishing.userSelect].inventory.katUser.length;k++){
                        if (UserList.users[YurbassFishing.userSelect].inventory.katUser[k].tackleNumber == SelectUser.tacklesList[spinIndex].katushkaT.tackleNumber){
                            UserList.users[YurbassFishing.userSelect].inventory.katUser[k].tackleNumber = -1;
                            break;
                        }
                    }
                    SelectUser.tacklesList[spinIndex].katushkaT = null;
                }
            }
        }
        catch (Exception e){
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
        //создание панели со спиннингами
        spinPanel = new JPanel();
        spinInventListName = new String[100];
        spinInventList = new SpinningList.Spinning[100];
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; i++){
                spinInventList[i] = UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[i];
                spinInventListName[i] = spinInventList[i].spinName + " (комплект " + (spinInventList[i].spinCount+1) + ")";
            }
        }
        catch (Exception e){
        }
        spinCB = new JComboBox(spinInventListName);
        try{
            for (int i = 0; i < spinInventListName.length; ){
                if (spinInventListName[i] == null){
                    spinCB.removeItemAt(i);
                }
                else i++;
            }
        }
        catch (Exception e){
        }
        spinCB.setBounds(45,16,230,20);
//создание листа лесок
        int j = 1;
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineName.contains("кг")){
                    j++;
                }
            }
        }
        catch (Exception e){
        }
        lineInventList = new LineList.Line[j];
        lineInventListName = new String[j];
        lineList = new JList(lineInventListName);
        lineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            int k = 0;
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[i].lineName.contains("кг")){
                    lineInventList[k] = UserList.users[YurbassFishing.userSelect].inventory.linesUser[i];
                    lineInventListName[k] = lineInventList[k].lineName;
                    k++;
                }
            }
        }
        catch (Exception e){
        }
        lineScroll = new JScrollPane(lineList);
        lineScroll.setBounds(0,0,230,180);
//создание листа крючков
       j = 1;
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i].hookName !=null){
                    j++;
                }
            }
        }
        catch (Exception e){
        }
        hookInventList = new HookList.Hook[j];
        hookInventListName = new String[j];
        hookList = new JList(hookInventListName);
        hookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            int k = 0;
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i].hookName!=null){
                    hookInventList[k] = UserList.users[YurbassFishing.userSelect].inventory.hooksUser[i];
                    hookInventListName[k] = hookInventList[k].hookName;
                    k++;
                }
            }
        }
        catch (Exception e){
        }
        hookScroll = new JScrollPane(hookList);
        hookScroll.setBounds(0,0,230,180);
//создание листа наживок
        j = 1;
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[i].baitsName !=null&&UserList.users[YurbassFishing.userSelect].inventory.baitsUser[i].baitsType == TypeBaits.BAITS){
                    j++;
                }
            }
        }
        catch (Exception e){
        }
        baitsInventList = new BaitsList.Baits[j];
        baitsInventListName = new String[j];
        baitsList = new JList(baitsInventListName);
        baitsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            int k = 0;
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[i].baitsName !=null&&UserList.users[YurbassFishing.userSelect].inventory.baitsUser[i].baitsType == TypeBaits.BAITS){
                    baitsInventList[k] = UserList.users[YurbassFishing.userSelect].inventory.baitsUser[i];
                    baitsInventListName[k] = baitsInventList[k].baitsName;
                    k++;
                }
            }
        }
        catch (Exception e){
        }
        baitsScroll = new JScrollPane(baitsList);
        baitsScroll.setBounds(0,0,230,180);

        //создание списка катушек
        j = 1;
        try{
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.katUser[i].katName.length()>0){
                    j++;
                }
            }
        }
        catch (Exception e){
        }
        katInventList = new KatushkaList.Katushka[j];
        katInventListName = new String[j];
        katList = new JList(katInventListName);
        katList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try{
            int k = 0;
            for (int i = 0; i < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; i++){
                if (UserList.users[YurbassFishing.userSelect].inventory.katUser[i].katName.length()>0){
                    katInventList[k] = UserList.users[YurbassFishing.userSelect].inventory.katUser[i];
                    katInventListName[k] = katInventList[k].katName;
                    k++;
                }
            }
        }
        catch (Exception e){
        }
        katScroll = new JScrollPane(katList);
        katScroll.setBounds(0,0,230,180);

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
            imageBackground = ImageIO.read(getClass().getResource("/Image/interface/invent.jpg"));
            g.drawImage(imageBackground, 0,0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}