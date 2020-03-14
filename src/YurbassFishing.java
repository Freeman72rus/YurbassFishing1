import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YurbassFishing implements ActionListener {
    JButton locationListButton;//кнопка перехода на локации
    JButton fishBaseButton;//кнопка перехода на рыболовную базу
    JButton saveButton;//кнопка сохранения
    JButton exitButton;//кнопка выхода
    JButton inventoryButton;//кнопка перехода в инвентарь
    JButton cageButton;//кнопка перехода в садок
    FishBase fb;
    ThisWaterLocList loclistFrame;
    JFrame menu;
    JLabel locationListLabel;
    JLabel fishBaseLabel;
    JLabel cageLabel;
    JLabel inventoryLabel;
    JLabel saveLabel;
    JLabel exitLabel;
    static int userSelect = 0;//Выбранный сейчас юзер, по умолчанию самый первый созданный, дописать метод выбора профиля игрока при входе

    YurbassFishing(){
        menu = new JFrame("Yurbass Fishing. Главное меню");
        menu.setLayout(null);
        menu.setSize(480,600);
        menu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);

        locationListButton = new JButton(new ImageIcon("src\\Image\\interface\\LocationButton.png"));
        locationListButton.setBounds(200,50,65,60);
        locationListLabel = new JLabel("");
        locationListLabel.setBounds(177,115,150,15);

        fishBaseButton = new JButton(new ImageIcon("src\\Image\\interface\\FishBaseButton.png"));
        fishBaseButton.setBounds(350, 180, 65,60);
        fishBaseLabel = new JLabel("");
        fishBaseLabel.setBounds(342,245,150,15);

        cageButton = new JButton(new ImageIcon("src\\Image\\interface\\CageButton.png"));
        cageButton.setBounds(43,180,85,60);
        cageLabel = new JLabel("");
        cageLabel.setBounds(44,245,150,15);

        inventoryButton = new JButton(new ImageIcon("src\\Image\\interface\\InventoryButton.png"));
        inventoryButton.setBounds(50,310,65,60);
        inventoryLabel = new JLabel("");
        inventoryLabel.setBounds(51,375,150,15);

        saveButton = new JButton(new ImageIcon("src\\Image\\interface\\SaveButton.png"));
        saveButton.setBounds(350,310,65,60);
        saveLabel = new JLabel("");
        saveLabel.setBounds(347,375,150,15);

        exitButton = new JButton(new ImageIcon("src\\Image\\interface\\ExitButton.png"));
        exitButton.setBounds(200,440,65,60);
        exitLabel = new JLabel("");
        exitLabel.setBounds(215,505,150,15);

        locationListButton.addActionListener(this);
        locationListButton.setActionCommand("locations");
        locationListButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = locationListButton.getModel();
                if (mod.isRollover()) locationListLabel.setText("Пойти на локацию");
                else locationListLabel.setText("");
            }
        });

        fishBaseButton.addActionListener(this);
        fishBaseButton.setActionCommand("base");
        fishBaseButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = fishBaseButton.getModel();
                if (mod.isRollover()) fishBaseLabel.setText("Пойти на базу");
                else fishBaseLabel.setText("");
            }
        });

        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");
        saveButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = saveButton.getModel();
                if (mod.isRollover()) saveLabel.setText("Сохранение");
                else saveLabel.setText("");
            }
        });

        exitButton.addActionListener(this);
        exitButton.setActionCommand("exit");
        exitButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = exitButton.getModel();
                if (mod.isRollover()) exitLabel.setText("Выйти");
                else exitLabel.setText("");
            }
        });

        inventoryButton.addActionListener(this);
        inventoryButton.setActionCommand("inventory");
        inventoryButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = inventoryButton.getModel();
                if (mod.isRollover()) inventoryLabel.setText("Инвентарь");
                else inventoryLabel.setText("");
            }
        });

        cageButton.addActionListener(this);
        cageButton.setActionCommand("cage");
        cageButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = cageButton.getModel();
                if (mod.isRollover()) cageLabel.setText("Войти в садок");
                else cageLabel.setText("");
            }
        });
        menu.add(locationListButton);
        menu.add(fishBaseButton);
        menu.add(inventoryButton);
        menu.add(cageButton);
        menu.add(saveButton);
        menu.add(exitButton);
        menu.add(locationListLabel);
        menu.add(fishBaseLabel);
        menu.add(cageLabel);
        menu.add(inventoryLabel);
        menu.add(saveLabel);
        menu.add(exitLabel);

        menu.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new YurbassFishing();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("base")){
            fb = new FishBase();
            menu.setVisible(false);
            menu.dispose();
        }
        else if (ae.getActionCommand().equals("locations")){
            loclistFrame = new ThisWaterLocList();
            menu.setVisible(false);
            menu.dispose();
        }
        else if (ae.getActionCommand().equals("save")){
            
        }
        else if (ae.getActionCommand().equals("exit")){
            menu.dispose();
            System.exit(0);
        }
        else if (ae.getActionCommand().equals("cage")){
            
        }
        else if (ae.getActionCommand().equals("inventory")){
            
        }
    }
}
