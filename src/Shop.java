import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
        shopF.add(panel);
        shopF.addMouseListener(this);

        jlistSpin = new JList(spinningsList);
        jlistLine = new JList(linesList);
        jlistHook = new JList(hooksList);
        jlistSpoon = new JList(spoonsList);
        jlistBaits = new JList(baitsList);
        jlistKatushka = new JList(katushkasList);


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
            UserList.player1.userMoney += 100;
            System.out.println(UserList.player1.userMoney);
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