
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class YurbassFishing implements ActionListener {
    JButton locationListButton;//кнопка перехода на локации
    JButton fishBaseButton;//кнопка перехода на рыболовную базу
    JButton saveButton;//кнопка сохранения
    JButton exitButton;//кнопка выхода
    JButton inventoryButton;//кнопка перехода в инвентарь
    JButton cageButton;//кнопка перехода в садок
    FishBase fb;
    ThisWaterLocList loclistFrame;
    InventoryFrame inventoryFrame;
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
            saveGame();
            JOptionPane.showMessageDialog( null, "Сохранение прошло успешно", "", JOptionPane.DEFAULT_OPTION );
        }
        else if (ae.getActionCommand().equals("exit")){
            menu.dispose();
            System.exit(0);
        }
        else if (ae.getActionCommand().equals("cage")){

        }
        else if (ae.getActionCommand().equals("inventory")){
            inventoryFrame = new InventoryFrame();
            menu.setVisible(false);
            menu.dispose();
        }
    }
    static void saveGame(){
        String inventSpin = "";
        String inventLine = "";
        String inventHook = "";
        String inventSpoon = "";
        String inventBaits = "";
        String inventKat = "";
        try(FileWriter writer = new FileWriter(UserList.users[userSelect].userName, false))
        {
            String text = "";
            text += UserList.users[userSelect].userName + "\n" + UserList.users[userSelect].baseNow + "\n"
                    + UserList.users[userSelect].userMoney + "\n" + UserList.users[userSelect].userExp + "\n";
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] != null){
                    inventSpin += "spin:" + UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j].spinName + "|" + UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j].spinSafety + "\n";
                }
            }
            text += inventSpin;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] != null){
                    inventLine += "line:" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].lineName + "|" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].lineLength + "|" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].tackleNumber + "\n";
                }
            }
            text += inventLine;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] != null){
                    inventHook += "hook:" + UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j].hookName + "|" + UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j].hookQuality + "\n";
                }
            }
            text += inventHook;
            /*for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spoonsUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.spoonsUser[j] != null){
                    inventSpoon += "spoon:" + UserList.users[YurbassFishing.userSelect].inventory.spoonsUser[j].spinName + "|" + UserList.users[YurbassFishing.userSelect].inventory.spoonsUser[j].spinSafety + "\n";
                }
            }
            text += inventSpoon;*/
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j] != null){
                    inventBaits += "baits:" + UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j].baitsName + "|" + UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j].baitsQuantity + "\n";
                }
            }
            text += inventBaits;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.katUser[j] != null){
                    inventKat += "kat:" + UserList.users[YurbassFishing.userSelect].inventory.katUser[j].katName + "|" + UserList.users[YurbassFishing.userSelect].inventory.katUser[j].katSafety + "\n";
                }
            }
            text += inventKat;



            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    static void loadGame(){
        try(FileReader reader = new FileReader(UserList.users[userSelect].userName))
        {
            Scanner scanner = new Scanner(reader);
            UserList.users[userSelect].userName = scanner.nextLine();
            UserList.users[userSelect].baseNow = scanner.nextLine();
            UserList.users[userSelect].userMoney = Long.parseLong(scanner.nextLine());
            UserList.users[userSelect].userExp = Long.parseLong(scanner.nextLine());
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                String sub = "";
                int pos = s.indexOf('|');
                if (s.contains("spin:")){
                    try {
                        sub = s.substring(5, pos);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] == null){
                                for (int i =0; i < SpinningList.spinningList.length; i++){
                                    if (SpinningList.spinningList[i].spinName.equals(sub)){
                                        UserList.users[userSelect].inventory.spinningsUser[j] = SpinningList.spinningList[i];
                                        System.out.println(sub);
                                        sub = s.substring(pos+1);
                                        UserList.users[userSelect].inventory.spinningsUser[j].spinSafety = Integer.parseInt(sub);
                                    }
                                    //break;
                                }
                            }
                            //break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ошибка в получении спиннинга из сохранения");
                    }
                }
                else if (s.contains("line:")){
                    try {
                        sub = s.substring(5, pos);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] == null){
                                for (int i =0; i < LineList.lineList.length; i++){
                                    if (LineList.lineList[i].lineName.equals(sub)){
                                        UserList.users[userSelect].inventory.linesUser[j] = LineList.lineList[i];
                                        System.out.println(sub);
                                        sub = s.substring(pos+1);
                                        int pos2 = sub.indexOf('|');
                                        sub = s.substring(pos+1, pos+pos2+1);
                                        UserList.users[userSelect].inventory.linesUser[j].lineLength = Integer.parseInt(sub);
                                        sub = s.substring(pos+pos2+2);
                                        System.out.println(sub + " grtjg");
                                        UserList.users[userSelect].inventory.linesUser[j].tackleNumber = Integer.parseInt(sub);
                                    }
                                    //break;
                                }
                            }
                            //break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ошибка в получении лески из сохранения");
                    }
                }
                else if (s.contains("hook:")){
                    try {
                        sub = s.substring(5, pos);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] == null){
                                for (int i =0; i < HookList.hookList.length; i++){
                                    if (HookList.hookList[i].hookName.equals(sub)){
                                        UserList.users[userSelect].inventory.hooksUser[j] = HookList.hookList[i];
                                        System.out.println(sub);
                                        sub = s.substring(pos+1);
                                        UserList.users[userSelect].inventory.hooksUser[j].hookQuantity = Integer.parseInt(sub);
                                    }
                                    //break;
                                }
                            }
                            //break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ошибка в получении крючка из сохранения");
                    }
                }
                /*else if (s.contains("spoon:")){
                }*/
                else if (s.contains("baits:")){
                    try {
                        sub = s.substring(6, pos);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j] == null){
                                for (int i =0; i < BaitsList.baitsList.length; i++){
                                    if (BaitsList.baitsList[i].baitsName.equals(sub)){
                                        UserList.users[userSelect].inventory.baitsUser[j] = BaitsList.baitsList[i];
                                        System.out.println(sub);
                                        sub = s.substring(pos+1);
                                        UserList.users[userSelect].inventory.baitsUser[j].baitsQuantity = Integer.parseInt(sub);
                                    }
                                    //break;
                                }
                            }
                            //break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ошибка в получении наживки из сохранения");
                    }
                }
                else if (s.contains("kat:")){
                    try {
                        sub = s.substring(4, pos);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; j++){
                            if (UserList.users[YurbassFishing.userSelect].inventory.katUser[j] == null){
                                for (int i =0; i < KatushkaList.katushkaList.length; i++){
                                    if (KatushkaList.katushkaList[i].katName.equals(sub)){
                                        UserList.users[userSelect].inventory.katUser[j] = KatushkaList.katushkaList[i];
                                        System.out.println(sub);
                                        sub = s.substring(pos+1);
                                        UserList.users[userSelect].inventory.katUser[j].katSafety = Integer.parseInt(sub);
                                    }
                                    //break;
                                }
                            }
                            //break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Ошибка в получении катушки из сохранения");
                    }
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}