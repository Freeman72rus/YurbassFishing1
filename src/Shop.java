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

class Shop extends JFrame implements MouseListener, ActionListener, ChangeListener {//Класс реализует магазин товаров
    JFrame shopF;
    FishBase fb = new FishBase();;
    int mouseClicX;
    int mouseClicY;
    int countSpin = 0;
    JList jlistSpin;
    JList jlistLine;
    JList jlistHook;
    JList jlistSpoon;
    JList jlistBaits;
    JList jlistKatushka;
    JScrollPane jscrlpSpin;
    JScrollPane jscrlpLine;
    JScrollPane jscrlpHook;
    JScrollPane jscrlpSpoon;
    JScrollPane jscrlpBaits;
    JScrollPane jscrlpKatushka;
    JTabbedPane jtab;
    String[] spinningsList = {SpinningList.spinning_1.spinName, SpinningList.spinning_2.spinName};
    String[] linesList = {LineList.line_1.lineName, LineList.line_2.lineName};
    String[] hooksList = {HookList.hook_1.hookName, HookList.hook_2.hookName};
    SpoonList.Spoon[] spoonsList = {SpoonList.spoon_1, SpoonList.spoon_2};
    String[] baitsList = {BaitsList.bWorm.baitsName, BaitsList.prManka.baitsName, BaitsList.arVanil.baitsName};
    String[] katushkasList = {KatushkaList.katushka_1.katName, KatushkaList.katushka_2.katName};
    JLabel infoButLab = new JLabel("");
    JButton spinButton = new JButton("");
    JButton lineButton = new JButton("");
    JButton hookButton = new JButton("");
    JButton spoonButton = new JButton("");
    JButton baitsButton = new JButton("");
    JButton katushkaButton = new JButton("");
    String[] spinImage = {"src\\Image\\dev\\sp_lord.jpg", "src\\Image\\dev\\sp_cottus 000.jpg"};
    String[] lineImage = {"src\\Image\\dev\\leska.jpg"};
    String[] hookImage = {"src\\Image\\dev\\hk_viper.jpg", "src\\Image\\dev\\hk_fisher.jpg"};
    String[] spoonImage = {"src\\Image\\dev\\bl_weltic.jpg", "src\\Image\\dev\\bl_champ.jpg"};
    String[] baitsImage = {"src\\Image\\dev\\pr_worm.jpg", "src\\Image\\dev\\pr_manka.gif", "src\\Image\\dev\\ar_vanil.jpg"};
    String[] katushkaImage = {"src\\Image\\dev\\kt_daiwa.jpg", "src\\Image\\dev\\kt_cardinal.jpg"};
    JLabel imageLabel;
    JLabel info1;
    JLabel info2;
    JLabel info3;
    JLabel userMoney;
    JLabel buyInfo;

    Shop(){
        //UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
       // UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
        fb.fb.setVisible(false);
        shopF = new JFrame("Рыболовный магазин");
        shopF.setSize(800,600);
        shopF.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        shopF.setResizable(false);
        shopF.setLocationRelativeTo(null);
        shopF.setLayout(null);
        ShopPanel panel = new ShopPanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        imageLabel = new JLabel("");
        info1 = new JLabel("");
        info1.setFont(new Font("Arial", Font.PLAIN, 14));
        info1.setForeground(Color.BLACK);
        info2 = new JLabel("");
        info2.setFont(new Font("Arial", Font.PLAIN, 14));
        info2.setForeground(Color.BLACK);
        info3 = new JLabel("");
        info3.setFont(new Font("Arial", Font.PLAIN, 14));
        info3.setForeground(Color.BLACK);
        userMoney = new JLabel(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
        userMoney.setFont(new Font("Arial", Font.PLAIN, 14));
        userMoney.setForeground(Color.WHITE);
        userMoney.setBounds(650,490,300,15);
        buyInfo = new JLabel("");
        buyInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        buyInfo.setForeground(Color.BLACK);
        buyInfo.setBounds(5,520,300,15);

        panel.add(imageLabel);
        panel.add(info1);
        panel.add(info2);
        panel.add(info3);
        panel.add(userMoney);
        panel.add(buyInfo);
        shopF.add(panel);
        shopF.addMouseListener(this);

        jlistSpin = new JList(spinningsList);
        jlistLine = new JList(linesList);
        jlistHook = new JList(hooksList);
        jlistSpoon = new JList(spoonsList);
        jlistBaits = new JList(baitsList);
        jlistKatushka = new JList(katushkasList);

        jlistSpin.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(spinImage[i]));
                imageLabel.setBounds(320,70,200,200);
                info1.setText("Цена: " + SpinningList.spinningList[i].spinPrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                info3.setText("Выдерживает вес " + ((int)SpinningList.spinningList[i].spinCapacity)/1000 + " кг");
                info3.setBounds(10, 250, 200,15);
            }
        });
        jlistLine.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(lineImage[0]));
                imageLabel.setBounds(280,50,200,200);
                info1.setText("Цена: " + LineList.lineList[i].linePrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                info3.setText("Длина " + LineList.lineList[i].lineLength + " м");
                info3.setBounds(10, 250, 200,15);
            }
        });
        jlistHook.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(hookImage[i]));
                imageLabel.setBounds(280,50,200,200);
                info1.setText("Цена: " + HookList.hookList[i].hookPrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                info3.setText("Количество в наборе: " + HookList.hookList[i].hookQuantity + " шт");
                info3.setBounds(10, 250, 200,15);
            }
        });
        jlistSpoon.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(spoonImage[i]));
                imageLabel.setBounds(280,50,200,200);
                /*info1.setText("Цена: " + SpoonList.spoonList[i].hookPrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                info3.setText("Количество в наборе: " + SpoonList.spoonList[i].hookQuantity + " шт");
                info3.setBounds(10, 250, 200,15);*/
            }
        });
        jlistBaits.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(baitsImage[i]));
                imageLabel.setBounds(300,50,200,200);
                info1.setText("Цена: " + BaitsList.baitsList[i].baitsPrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                if (BaitsList.baitsList[i].baitsType.equals(TypeBaits.BAITS)){
                    info3.setText("Количество: " + BaitsList.baitsList[i].baitsQuantity + " шт");
                }
                else if (BaitsList.baitsList[i].baitsType.equals(TypeBaits.PRIKORM)){
                    info3.setText("Количество порций: " + BaitsList.baitsList[i].baitsQuantity);
                }
                else if (BaitsList.baitsList[i].baitsType.equals(TypeBaits.AROMA)){
                    info3.setText("Количество использований: " + BaitsList.baitsList[i].baitsQuantity);
                }
                info3.setBounds(10, 250, 220,15);
            }
        });
        jlistKatushka.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent le) {
                int i;
                i = ((JList)le.getSource()).getSelectedIndex();
                imageLabel.setIcon(new ImageIcon(katushkaImage[i]));
                imageLabel.setBounds(280,50,200,200);
                info1.setText("Цена: " + KatushkaList.katushkaList[i].katPrice + " руб.");
                info1.setBounds(10, 120, 100, 15);
                info2.setText("<html>Для покупки сделайте<br>двойной щелчок");
                info2.setBounds(10, 160, 150, 30);
                info3.setText("<html>Количество подшипников: " + KatushkaList.katushkaList[i].katPodshipQuantity + " шт<br>"
                + "Выдерживает вес: " + ((int)KatushkaList.katushkaList[i].katCapacity)/1000 + " кг");
                info3.setBounds(10, 250, 220,30);
            }
        });
        jlistSpin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= SpinningList.spinningList[i].spinPrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= SpinningList.spinningList[i].spinPrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] = new SpinningList.Spinning(countSpin, SpinningList.spinningList[i].spinName, SpinningList.spinningList[i].spinPathImage, SpinningList.spinningList[i].spinCapacity, SpinningList.spinningList[i].spinPrice, SpinningList.spinningList[i].spinSafety);
                                countSpin += 1;
                                buyInfo.setText("Куплен спиннинг " + spinningsList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });
        jlistLine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= LineList.lineList[i].linePrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= LineList.lineList[i].linePrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] = new  LineList.Line(LineList.lineList[i].lineName, LineList.lineList[i].linePathImage, LineList.lineList[i].lineCapacity, LineList.lineList[i].lineLength, LineList.lineList[i].linePrice, LineList.lineList[i].tackleNumber, LineList.lineList[i].tackleSelect);
                                buyInfo.setText("Куплена леска на " + linesList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });
        jlistHook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= HookList.hookList[i].hookPrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= HookList.hookList[i].hookPrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] = HookList.hookList[i];
                                buyInfo.setText("Куплены крючки " + hooksList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });
        /*jlistSpoon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= SpoonList.spoonList[i].spoonPrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= SpoonList.spoonList[i].spoonPrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spoonsUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.spoonsUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.spoonsUser[j] = SpoonList.spoonList[i];
                                buyInfo.setText("Куплено: " + spoonsList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });*/
        jlistBaits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= BaitsList.baitsList[i].baitsPrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= BaitsList.baitsList[i].baitsPrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j] = BaitsList.baitsList[i];
                                buyInfo.setText("Куплено: " + baitsList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });
        jlistKatushka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2){
                    int i;
                    i = ((JList)e.getSource()).getSelectedIndex();
                    if (UserList.users[YurbassFishing.userSelect].userMoney >= KatushkaList.katushkaList[i].katPrice){
                        UserList.users[YurbassFishing.userSelect].userMoney -= KatushkaList.katushkaList[i].katPrice;
                        userMoney.setText(UserList.users[YurbassFishing.userSelect].userMoney + " руб.");
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.katUser[j] == null){
                                UserList.users[YurbassFishing.userSelect].inventory.katUser[j] = KatushkaList.katushkaList[i];
                                buyInfo.setText("Куплено: " + katushkasList[i]);
                                break;
                            }
                            else buyInfo.setText("Нет места для этой категории товара");
                        }
                    }
                    else buyInfo.setText("Не хватает средств");
                }
            }
        });


        jlistSpin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistLine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistHook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistSpoon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistBaits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistKatushka.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jscrlpSpin = new JScrollPane(jlistSpin);
        jscrlpLine = new JScrollPane(jlistLine);
        jscrlpHook = new JScrollPane(jlistHook);
        jscrlpSpoon = new JScrollPane(jlistSpoon);
        jscrlpBaits = new JScrollPane(jlistBaits);
        jscrlpKatushka = new JScrollPane(jlistKatushka);

        jscrlpSpin.setSize(230,345);
        jscrlpSpin.setBounds(0,0,230,345);
        jscrlpLine.setSize(230,345);
        jscrlpHook.setSize(230,345);
        jscrlpSpoon.setSize(230,345);
        jscrlpBaits.setSize(230,345);
        jscrlpKatushka.setSize(230,345);

        jtab = new JTabbedPane(SwingConstants.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.add("Спиннинги",  jscrlpSpin);
        jtab.add("Лески", jscrlpLine);
        jtab.add("Крючки", jscrlpHook);
        jtab.add("Блёсны", jscrlpSpoon);
        jtab.add("Наживки", jscrlpBaits);
        jtab.add("Катушки", jscrlpKatushka);
        jtab.setSize(500,565);
        jtab.setBounds(558,13,225,340);
        jtab.setLayout(null);
        jtab.setIconAt(0, new ImageIcon("src\\Image\\interface\\locbutton.gif"));


        infoButLab.setBounds(350,515,180,15);
        infoButLab.setFont(new Font("Arial", Font.PLAIN, 16));
        infoButLab.setForeground(Color.BLACK);

        spinButton.setBounds(265,475,65,65);
        spinButton.setBorderPainted(false);
        spinButton.setFocusPainted(false);
        spinButton.setContentAreaFilled(false);
        spinButton.setActionCommand("spin");
        spinButton.addActionListener(this);
        spinButton.addChangeListener(this);

        lineButton.setBounds(340,415,65,65);
        lineButton.setBorderPainted(false);
        lineButton.setFocusPainted(false);
        lineButton.setContentAreaFilled(false);
        lineButton.setActionCommand("line");
        lineButton.addActionListener(this);
        lineButton.addChangeListener(this);

        hookButton.setBounds(425,400,65,65);
        hookButton.setBorderPainted(false);
        hookButton.setFocusPainted(false);
        hookButton.setContentAreaFilled(false);
        hookButton.setActionCommand("hook");
        hookButton.addActionListener(this);
        hookButton.addChangeListener(this);

        spoonButton.setBounds(515,400,65,65);
        spoonButton.setBorderPainted(false);
        spoonButton.setFocusPainted(false);
        spoonButton.setContentAreaFilled(false);
        spoonButton.setActionCommand("spoon");
        spoonButton.addActionListener(this);
        spoonButton.addChangeListener(this);

        baitsButton.setBounds(605,400,65,65);
        baitsButton.setBorderPainted(false);
        baitsButton.setFocusPainted(false);
        baitsButton.setContentAreaFilled(false);
        baitsButton.setActionCommand("baits");
        baitsButton.addActionListener(this);
        baitsButton.addChangeListener(this);

        katushkaButton.setBounds(695,400,65,65);
        katushkaButton.setBorderPainted(false);
        katushkaButton.setFocusPainted(false);
        katushkaButton.setContentAreaFilled(false);
        katushkaButton.setActionCommand("kat");
        katushkaButton.addActionListener(this);
        katushkaButton.addChangeListener(this);


        panel.add(infoButLab);
        panel.add(spinButton);
        panel.add(lineButton);
        panel.add(hookButton);
        panel.add(spoonButton);
        panel.add(baitsButton);
        panel.add(katushkaButton);

        panel.add(jtab);

        shopF.setVisible(true);
    }
   public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Shop();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseClicX = mouseEvent.getX();
        mouseClicY = mouseEvent.getY();
        if (mouseEvent.getX()>660&&mouseEvent.getY()>560){
            fb.fb.setVisible(true);
            shopF.setVisible(false);
            shopF.dispose();
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
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("spin")){
            jtab.setSelectedIndex(0);
        }
        else if (ae.getActionCommand().equals("line")){
            jtab.setSelectedIndex(1);
        }
        else if (ae.getActionCommand().equals("hook")){
            jtab.setSelectedIndex(2);
        }
        else if (ae.getActionCommand().equals("spoon")){
            jtab.setSelectedIndex(3);
        }
        else if (ae.getActionCommand().equals("baits")){
            jtab.setSelectedIndex(4);
        }
        else if (ae.getActionCommand().equals("kat")){
            jtab.setSelectedIndex(5);
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        ButtonModel buttonModelSpin = spinButton.getModel();
        ButtonModel buttonModelLine = lineButton.getModel();
        ButtonModel buttonModelHook = hookButton.getModel();
        ButtonModel buttonModelSpoon = spoonButton.getModel();
        ButtonModel buttonModelBaits = baitsButton.getModel();
        ButtonModel buttonModelKat = katushkaButton.getModel();
        if (buttonModelSpin.isRollover()){
            infoButLab.setText("Спиннинги");
        }
        else if (buttonModelLine.isRollover()){
            infoButLab.setText("Лески");
        }
        else if (buttonModelHook.isRollover()){
            infoButLab.setText("Крючки");
        }
        else if (buttonModelSpoon.isRollover()){
            infoButLab.setText("Блёсны");
        }
        else if (buttonModelBaits.isRollover()){
            infoButLab.setText("Наживки и прикормки");
        }
        else if (buttonModelKat.isRollover()){
            infoButLab.setText("Катушки");
        }
        else infoButLab.setText("");
    }

}
class ShopPanel extends JPanel{
    BufferedImage imageBackground;
    BufferedImage imageFon;
    BufferedImage imageText;
    protected void paintComponent(Graphics g){
        try {
            imageBackground = ImageIO.read(new File("src\\Image\\interface\\shop.jpg"));
            imageFon = ImageIO.read(new File("src\\Image\\interface\\shop_part2.gif"));
            imageText = ImageIO.read(new File("src\\Image\\interface\\shop_part1.gif"));
            g.drawImage(imageBackground, 0,0, null);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
            g.drawString("назад", 680, 550);
            g.drawImage(imageFon,225,10,null);
            g.drawImage(imageText,554,10,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}