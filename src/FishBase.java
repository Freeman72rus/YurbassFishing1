import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

class FishBase extends JFrame implements ActionListener {//Класс описывает рыболовную базу
    JFrame fb;
    JButton shopButton;
    JButton buttonMenu;
    JButton fishOcenButton;
    JButton fishAllSellButton;
    JButton informButton;
    JButton mapButton;
    JButton clubButton;
    JButton licenceButton;
    JButton recordButton;
    JButton foodShopButton;
    JButton houseShopButton;
    JButton autoShopButton;
    JButton tourShopButton;
    JButton regTurnirButton;
    JButton barButton;
    JLabel infoButLab;
    static JLabel clock = new JLabel(YurbassFishing.clockStr);
    YurbassFishing yf = new YurbassFishing();
    Shop shop;
    final ImageIcon shopIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_sh.gif"));
    final ImageIcon menuIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_menu.gif"));
    final ImageIcon fishOcIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_fo.gif"));
    final ImageIcon fishAllSellIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_fc.gif"));
    final ImageIcon informIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_info.gif"));
    final ImageIcon mapIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_map.gif"));
    final ImageIcon clubIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_club.gif"));
    final ImageIcon licenseIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_lic.gif"));
    final ImageIcon recordIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_rec.gif"));
    final ImageIcon foodShopIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_food.gif"));
    final ImageIcon houseShopIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_house.gif"));
    final ImageIcon autoShopIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_auto.gif"));
    final ImageIcon tourShopIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_tour.gif"));
    final ImageIcon regTurnirIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_reg.gif"));
    final ImageIcon barIm = new ImageIcon(FishBase.class.getResource("/Image/interface/b_bar.gif"));

    FishBase(){
        yf.menu.setVisible(false);
        fb = new JFrame("Рыболовная база " + UserList.users[YurbassFishing.userSelect].baseNow);
        fb.setLayout(null);
        fb.setSize(800,600);
        fb.setLocationRelativeTo(null);
        fb.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        fb.setVisible(true);
        fb.setResizable(false);

        shopButton = new JButton(shopIm);
        shopButton.setBounds(50,150,65,65);
        shopButton.addActionListener(this);
        shopButton.setActionCommand("shop");
        fb.add(shopButton);
        shopButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = shopButton.getModel();
                if (mod.isRollover())infoButLab.setText("Рыболовный магазин");
                else infoButLab.setText("");
            }
        });

        buttonMenu = new JButton(menuIm);
        buttonMenu.setBounds(700,490,65,65);
        buttonMenu.addActionListener(this);
        buttonMenu.setActionCommand("menu");
        fb.add(buttonMenu);
        buttonMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = buttonMenu.getModel();
                if (mod.isRollover())infoButLab.setText("Выход в меню");
                else infoButLab.setText("");
            }
        });


        fishOcenButton = new JButton(fishOcIm);
        fishOcenButton.setBounds(125,150,65,65);
        fishOcenButton.addActionListener(this);
        fishOcenButton.setActionCommand("ocenka");
        fb.add(fishOcenButton);
        fishOcenButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = fishOcenButton.getModel();
                if (mod.isRollover())infoButLab.setText("Оценка улова");
                else infoButLab.setText("");
            }
        });

        fishAllSellButton = new JButton(fishAllSellIm);
        fishAllSellButton.setBounds(200,150,65,65);
        fishAllSellButton.addActionListener(this);
        fishAllSellButton.setActionCommand("sellFish");
        fb.add(fishAllSellButton);
        fishAllSellButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = fishAllSellButton.getModel();
                if (mod.isRollover())infoButLab.setText("Продать всю рыбу");
                else infoButLab.setText("");
            }
        });

        informButton = new JButton(informIm);
        informButton.setBounds(275,150,65,65);
        informButton.addActionListener(this);
        informButton.setActionCommand("inform");
        fb.add(informButton);
        informButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = informButton.getModel();
                if (mod.isRollover())infoButLab.setText("Информация и пресса");
                else infoButLab.setText("");
            }
        });

        mapButton = new JButton(mapIm);
        mapButton.setBounds(350,150,65,65);
        mapButton.addActionListener(this);
        mapButton.setActionCommand("maps");
        fb.add(mapButton);
        mapButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = mapButton.getModel();
                if (mod.isRollover())infoButLab.setText("Заказ путёвки");
                else infoButLab.setText("");
            }
        });

        clubButton = new JButton(clubIm);
        clubButton.setBounds(425,150,65,65);
        clubButton.addActionListener(this);
        clubButton.setActionCommand("club");
        fb.add(clubButton);
        clubButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = clubButton.getModel();
                if (mod.isRollover())infoButLab.setText("Рыболовные клубы");
                else infoButLab.setText("");
            }
        });

        licenceButton = new JButton(licenseIm);
        licenceButton.setBounds(500,150,65,65);
        licenceButton.addActionListener(this);
        licenceButton.setActionCommand("licence");
        fb.add(licenceButton);
        licenceButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = licenceButton.getModel();
                if (mod.isRollover())infoButLab.setText("Выдача лицензий");
                else infoButLab.setText("");
            }
        });

        recordButton = new JButton(recordIm);
        recordButton.setBounds(575,150,65,65);
        recordButton.addActionListener(this);
        recordButton.setActionCommand("record");
        fb.add(recordButton);
        recordButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = recordButton.getModel();
                if (mod.isRollover())infoButLab.setText("Таблица рекордов");
                else infoButLab.setText("");
            }
        });


        foodShopButton = new JButton(foodShopIm);
        foodShopButton.setBounds(650,150,65,65);
        foodShopButton.addActionListener(this);
        foodShopButton.setActionCommand("food");
        fb.add(foodShopButton);
        foodShopButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = foodShopButton.getModel();
                if (mod.isRollover())infoButLab.setText("Продуктовый магазин");
                else infoButLab.setText("");
            }
        });

        houseShopButton = new JButton(houseShopIm);
        houseShopButton.setBounds(200,225,65,65);
        houseShopButton.addActionListener(this);
        houseShopButton.setActionCommand("house");
        fb.add(houseShopButton);
        houseShopButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = houseShopButton.getModel();
                if (mod.isRollover())infoButLab.setText("Покупка недвижимости");
                else infoButLab.setText("");
            }
        });

        autoShopButton = new JButton(autoShopIm);
        autoShopButton.setBounds(275,225,65,65);
        autoShopButton.addActionListener(this);
        autoShopButton.setActionCommand("auto");
        fb.add(autoShopButton);
        autoShopButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = autoShopButton.getModel();
                if (mod.isRollover())infoButLab.setText("Покупка автомобиля");
                else infoButLab.setText("");
            }
        });

        tourShopButton = new JButton(tourShopIm);
        tourShopButton.setBounds(350,225,65,65);
        tourShopButton.addActionListener(this);
        tourShopButton.setActionCommand("tour");
        fb.add(tourShopButton);
        tourShopButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = tourShopButton.getModel();
                if (mod.isRollover())infoButLab.setText("Горящие туры");
                else infoButLab.setText("");
            }
        });

        regTurnirButton = new JButton(regTurnirIm);
        regTurnirButton.setBounds(425,225,65,65);
        regTurnirButton.addActionListener(this);
        regTurnirButton.setActionCommand("turnir");
        fb.add(regTurnirButton);
        regTurnirButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = regTurnirButton.getModel();
                if (mod.isRollover())infoButLab.setText("Регистрация на турнир");
                else infoButLab.setText("");
            }
        });

        barButton = new JButton(barIm);
        barButton.setBounds(500,225,65,65);
        barButton.addActionListener(this);
        barButton.setActionCommand("bar");
        fb.add(barButton);
        barButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                ButtonModel mod = barButton.getModel();
                if (mod.isRollover())infoButLab.setText("Бар");
                else infoButLab.setText("");
            }
        });

        infoButLab = new JLabel("");
        infoButLab.setBounds(10,540,150,15);
        fb.add(infoButLab);

        clock.setBounds(0,0,100,100);
        fb.add(clock);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("shop")){//Дописать вход в магазин
            shop = new Shop();
            fb.setVisible(false);
            fb.dispose();
        }
        else if (ae.getActionCommand().equals("menu")){
            yf.menu.setVisible(true);
            fb.setVisible(false);
            fb.dispose();
        }
    }
}
