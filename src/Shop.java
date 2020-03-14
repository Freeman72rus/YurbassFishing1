import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Shop extends JFrame implements MouseListener{//Класс реализует магазин товаров
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

    Shop(){
        UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
        UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
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
        jscrlpSpin.setBounds(100,100,230,345);
        jscrlpLine.setSize(230,345);
        jscrlpHook.setSize(230,345);
        jscrlpSpoon.setSize(230,345);
        jscrlpBaits.setSize(230,345);
        jscrlpKatushka.setSize(230,345);

        //jscrlpSpin.setBounds(570,20,210,320);
        jtab = new JTabbedPane(SwingConstants.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.add("Спиннинги",  jscrlpSpin);
        jtab.add("Лески", jscrlpLine);
        jtab.add("Крючки", jscrlpHook);
        jtab.add("Блёсны", jscrlpSpoon);
        jtab.add("Наживки", jscrlpBaits);
        jtab.add("Катушки", jscrlpKatushka);
        jtab.setSize(500,565);
        jtab.setBounds(232,10,550,565);
        jtab.setLayout(null);
        jtab.setIconAt(0, new ImageIcon("src\\Image\\interface\\locbutton.gif"));

        panel.add(jtab);
        //panel.add(jscrlpSpin);

        shopF.setVisible(true);
    }
   public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Shop();
            }
        });
       System.out.println(BaseList.baseList[0].locationsList[0].x);
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
        if (mouseEvent.getX()<200&&mouseEvent.getY()<200){
            jtab.setSelectedIndex(1);
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