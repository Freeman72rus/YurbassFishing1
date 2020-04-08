
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class YurbassFishing implements ActionListener {
    static String myDocs=new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    static final int weight = 800;
    static final int height = 600;
    private static String s1;
    JButton locationListButton;//кнопка перехода на локации
    JButton fishBaseButton;//кнопка перехода на рыболовную базу
    JButton saveButton;//кнопка сохранения
    JButton exitButton;//кнопка выхода
    JButton inventoryButton;//кнопка перехода в инвентарь
    JButton cageButton;//кнопка перехода в садок
    FishBase fb;
    ThisWaterLocList loclistFrame;
    InventoryFrame inventoryFrame;
    static JFrame menu;
    JLabel locationListLabel;
    JLabel fishBaseLabel;
    JLabel cageLabel;
    JLabel inventoryLabel;
    JLabel saveLabel;
    JLabel exitLabel;
    static JLabel clock = new JLabel("");
    static int userSelect = 0;//Выбранный сейчас юзер, по умолчанию самый первый созданный, дописать метод выбора профиля игрока при входе
    static int countSpin = 0;//глобальный счетчик спиннингов купленных в этом профиле
    final ImageIcon loc = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/LocationButton.png"));
    final ImageIcon fishBase = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/FishBaseButton.png"));
    final ImageIcon cage = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/CageButton.png"));
    final ImageIcon inventory = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/InventoryButton.png"));
    final ImageIcon save = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/SaveButton.png"));
    final ImageIcon exit = new ImageIcon(YurbassFishing.class.getResource("/Image/interface/ExitButton.png"));
    static int time = 0;
    static int hours = 0;
    static int minutes =0;
    static int days = 1;
    static int month = 1;
    static int years = 2020;
    static String daysWeek = "Среда";
    static int daysWeekCount = 3;
    static String clockStr;
    static String clockStr2;
    static BaseList.Base nowBase = BaseList.home;


    YurbassFishing(){
        menu = new JFrame("Yurbass Fishing. Главное меню");
        menu.setLayout(null);
        menu.setSize(480,600);
        menu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);

        clock.setBounds(370,40,100,100);
        clock.setText("<html>" + hours + ":" + minutes + "<br>" + daysWeek + "<br>" + days + "." + month + "." + years + "<br>");

        locationListButton = new JButton(loc);
        locationListButton.setBounds(200,50,65,60);
        locationListLabel = new JLabel("");
        locationListLabel.setBounds(177,115,150,15);

        fishBaseButton = new JButton(fishBase);
        fishBaseButton.setBounds(350, 180, 65,60);
        fishBaseLabel = new JLabel("");
        fishBaseLabel.setBounds(342,245,150,15);

        cageButton = new JButton(cage);
        cageButton.setBounds(43,180,85,60);
        cageLabel = new JLabel("");
        cageLabel.setBounds(44,245,150,15);

        inventoryButton = new JButton(inventory);
        inventoryButton.setBounds(50,310,65,60);
        inventoryLabel = new JLabel("");
        inventoryLabel.setBounds(51,375,150,15);

        saveButton = new JButton(save);
        saveButton.setBounds(350,310,65,60);
        saveLabel = new JLabel("");
        saveLabel.setBounds(347,375,150,15);

        exitButton = new JButton(exit);
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

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCounter();
            }
        });
        timer.start();


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
        menu.add(clock);

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
        }
        else if (ae.getActionCommand().equals("locations")){
            loclistFrame = new ThisWaterLocList();
            menu.setVisible(false);
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
        }
    }
    static void timeCounter(){
        if (time<100){
            time +=1;
        }
        else time = 1;
        if (time == 100){
            minutes +=10;
            if (minutes == 60){
                minutes = 0;
                hours +=1;
                if (hours == 24){
                    daysWeekCount += 1;
                    days += 1;
                    hours = 0;
                    if (daysWeekCount >7){
                        daysWeekCount = 1;
                    }
                    if ((month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)&&days>31){
                        days = 1;
                        month +=1;
                        if (month>12){
                            years+=1;
                            month = 1;
                        }
                    }
                    if ((month == 4||month == 6||month == 9||month == 11)&&days>30){
                        days = 1;
                        month +=1;
                    }
                    if (month == 2&&days>28){
                        days = 1;
                        month +=1;
                    }
                }
            }
        }
        switch (daysWeekCount){
            case 1: daysWeek = "Понедельник";
                break;
            case 2: daysWeek = "Вторник";
                break;
            case 3: daysWeek = "Среда";
                break;
            case 4: daysWeek = "Четверг";
                break;
            case 5: daysWeek = "Пятница";
                break;
            case 6: daysWeek = "Суббота";
                break;
            case 7: daysWeek = "Воскресение";
                break;
        }
        if (hours <10){
            clockStr = "<html>0"+hours;
            clockStr2 = "0" + hours;
        }
        else{
            clockStr = "<html>" + hours;
            clockStr2 = "" + hours;
        }
        if (minutes == 0){
            clockStr += ":" + minutes + "0<br>" + daysWeek + "<br>";
            clockStr2 += ":" + minutes + "0";
        }
        else{
            clockStr += ":" + minutes + "<br>" + daysWeek + "<br>";
            clockStr2 += ":" + minutes;
        }
        if (days<10){
            clockStr += "0" + days + ".";
        }
        else clockStr += days + ".";
        if (month<10){
            clockStr += "0" + month;
        }
        else clockStr += month;
        clockStr += "." + years;
        clock.setText(clockStr);
        FishBase.clock.setText(clockStr);
        LocFrame.clock.setText(clockStr2);

    }
    static void saveGame(){
        String inventSpin = "";
        String inventLine = "";
        String inventHook = "";
        String inventSpoon = "";
        String inventBaits = "";
        String inventKat = "";
        String tackle = "";
        File folder = new File(myDocs + "\\Yurbass Fishing");
        folder.mkdir();
        folder = new File(myDocs + "\\Yurbass Fishing\\Save");
        folder.mkdir();
        try(FileWriter writer = new FileWriter(myDocs + "\\Yurbass Fishing\\Save\\" + UserList.users[userSelect].userName + ".txt", StandardCharsets.UTF_8, false))
        {
            String text = "";
            text += UserList.users[userSelect].userName + "\n" + UserList.users[userSelect].baseNow + "\n" + UserList.users[userSelect].userMoney + "\n" + UserList.users[userSelect].userExp
                    + "\n" + countSpin + "\n" + hours + "\n" + minutes + "\n" + daysWeekCount + "\n" + days + "\n" + month + "\n" + years + "\n";
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] != null){
                    inventSpin += "spin:\n" + UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j].spinName + "\n" + UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j].spinSafety + "\n" + UserList.users[userSelect].inventory.spinningsUser[j].spinCount + "\n";
                }
            }
            text += inventSpin;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] != null){
                    inventLine += "line:\n" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].lineName + "\n" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].lineLength + "\n" + UserList.users[YurbassFishing.userSelect].inventory.linesUser[j].tackleNumber + "\n";
                }
            }
            text += inventLine;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] != null){
                    inventHook += "hook:\n" + UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j].hookName + "\n" + UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j].hookQuantity + "\n";
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
                    inventBaits += "baits:\n" + UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j].baitsName + "\n" + UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j].baitsQuantity + "\n";
                }
            }
            text += inventBaits;
            for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; j++){
                if (UserList.users[YurbassFishing.userSelect].inventory.katUser[j] != null){
                    inventKat += "kat:\n" + UserList.users[YurbassFishing.userSelect].inventory.katUser[j].katName + "\n" + UserList.users[YurbassFishing.userSelect].inventory.katUser[j].katSafety + "\n" + UserList.users[YurbassFishing.userSelect].inventory.katUser[j].tackleNumber + "\n";
                }
            }
            text += inventKat;
            for (int j = 0; j<SelectUser.tacklesList.length;j++){
                if (SelectUser.tacklesList[j]!= null){
                    tackle += "tackle:\n" + UserList.users[userSelect].inventory.spinningsUser[j].spinCount + "\n";
                    if (SelectUser.tacklesList[j].hookT !=null){
                        tackle += SelectUser.tacklesList[j].hookT.hookName + "\n";
                    }
                    else tackle += "null"+"\n";
                    if (SelectUser.tacklesList[j].baitsT !=null){
                        tackle += SelectUser.tacklesList[j].baitsT.baitsName + "\n";
                    }
                    else tackle += "null"+"\n";
                }
            }
            text += tackle;



            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    static void loadGame(){
        try(FileReader reader = new FileReader(myDocs + "\\Yurbass Fishing\\Save\\" + UserList.users[userSelect].userName + ".txt", StandardCharsets.UTF_8))
        {
            Scanner scanner = new Scanner(reader);
            UserList.users[userSelect].userName = scanner.nextLine();
            UserList.users[userSelect].baseNow = scanner.nextLine();
            UserList.users[userSelect].userMoney = Long.parseLong(scanner.nextLine());
            UserList.users[userSelect].userExp = Long.parseLong(scanner.nextLine());
            countSpin = Integer.parseInt(scanner.nextLine());
            hours = Integer.parseInt(scanner.nextLine());
            minutes = Integer.parseInt(scanner.nextLine());
            daysWeekCount = Integer.parseInt(scanner.nextLine());
            days = Integer.parseInt(scanner.nextLine());
            month = Integer.parseInt(scanner.nextLine());
            years = Integer.parseInt(scanner.nextLine());
            while (scanner.hasNextLine()) {
                s1 = scanner.nextLine();
                System.out.println(s1);
                try {
                    if (s1.contains("spin:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.spinningsUser.length; j++) {
                            if (UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j] == null) {
                                for (int i = 0; i < SpinningList.spinningList.length; i++) {
                                    if (SpinningList.spinningList[i].spinName.equals(s1)) {
                                        UserList.users[userSelect].inventory.spinningsUser[j] = new SpinningList.Spinning(YurbassFishing.countSpin, SpinningList.spinningList[i].spinName, SpinningList.spinningList[i].spinPathImage, SpinningList.spinningList[i].spinCapacity, SpinningList.spinningList[i].spinPrice, SpinningList.spinningList[i].spinSafety);
                                        UserList.users[userSelect].inventory.spinningsUser[j].spinSafety = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.spinningsUser[j].spinSafety);
                                        UserList.users[userSelect].inventory.spinningsUser[j].spinCount = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.spinningsUser[j].spinCount);
                                        SelectUser.tacklesList[j] = new Tackle(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[j]);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex){
                }
                try {
                    if (s1.contains("line:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.linesUser.length; j++) {
                            if (UserList.users[YurbassFishing.userSelect].inventory.linesUser[j] == null) {
                                for (int i = 0; i < LineList.lineList.length; i++) {
                                    if (LineList.lineList[i].lineName.equals(s1)) {
                                        UserList.users[userSelect].inventory.linesUser[j] = new  LineList.Line(LineList.lineList[i].lineName, LineList.lineList[i].linePathImage, LineList.lineList[i].lineSmallImage, LineList.lineList[i].lineCapacity, LineList.lineList[i].lineLength, LineList.lineList[i].linePrice, LineList.lineList[i].tackleNumber);
                                        UserList.users[userSelect].inventory.linesUser[j].lineLength = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.linesUser[j].lineLength);
                                        UserList.users[userSelect].inventory.linesUser[j].tackleNumber = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.linesUser[j].tackleNumber);
                                        for (int k = 0; k<SelectUser.tacklesList.length; k++){
                                            if (SelectUser.tacklesList[k]!=null&&SelectUser.tacklesList[k].spinT.spinCount==UserList.users[userSelect].inventory.linesUser[j].tackleNumber){
                                                SelectUser.tacklesList[k].lineT = UserList.users[userSelect].inventory.linesUser[j];
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex){
                }
                try {
                    if (s1.contains("hook:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.hooksUser.length; j++) {
                            if (UserList.users[YurbassFishing.userSelect].inventory.hooksUser[j] == null) {
                                for (int i = 0; i < HookList.hookList.length; i++) {
                                    if (HookList.hookList[i].hookName.equals(s1)) {
                                        UserList.users[userSelect].inventory.hooksUser[j] = new HookList.Hook(HookList.hookList[i].hookName, HookList.hookList[i].hookPathImage, HookList.hookList[i].hookSmallImage, HookList.hookList[i].hookQuality, HookList.hookList[i].hookQuantity, HookList.hookList[i].hookPrice, HookList.hookList[i].tackleNumber);
                                        UserList.users[userSelect].inventory.hooksUser[j].hookQuantity = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.hooksUser[j].hookQuantity);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex){
                }
                try {
                    if (s1.contains("baits:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.baitsUser.length; j++) {
                            if (UserList.users[YurbassFishing.userSelect].inventory.baitsUser[j] == null) {
                                for (int i = 0; i < BaitsList.baitsList.length; i++) {
                                    if (BaitsList.baitsList[i].baitsName.equals(s1)) {
                                        UserList.users[userSelect].inventory.baitsUser[j] = new BaitsList.Baits(BaitsList.baitsList[i].baitsName, BaitsList.baitsList[i].baitsPathImage, BaitsList.baitsList[i].baitsSmallImage, BaitsList.baitsList[i].baitsType, BaitsList.baitsList[i].baitsQuantity, BaitsList.baitsList[i].baitsPrice, BaitsList.baitsList[i].tackleNumber);
                                        UserList.users[userSelect].inventory.baitsUser[j].baitsQuantity = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.baitsUser[j].baitsQuantity);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex){
                }
                try {
                    if (s1.contains("kat:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                        for (int j = 0; j < UserList.users[YurbassFishing.userSelect].inventory.katUser.length; j++) {
                            if (UserList.users[YurbassFishing.userSelect].inventory.katUser[j] == null) {
                                for (int i = 0; i < KatushkaList.katushkaList.length; i++) {
                                    if (KatushkaList.katushkaList[i].katName.equals(s1)) {
                                        UserList.users[userSelect].inventory.katUser[j] = new KatushkaList.Katushka(KatushkaList.katushkaList[i].katName, KatushkaList.katushkaList[i].katPathImage, KatushkaList.katushkaList[i].katSmallImage, KatushkaList.katushkaList[i].katCapacity, KatushkaList.katushkaList[i].katPodshipQuantity, KatushkaList.katushkaList[i].katPrice, KatushkaList.katushkaList[i].katSafety, KatushkaList.katushkaList[i].tackleNumber);
                                        UserList.users[userSelect].inventory.katUser[j].katSafety = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.katUser[j].katSafety);
                                        UserList.users[userSelect].inventory.katUser[j].tackleNumber = Integer.parseInt(scanner.nextLine());
                                        System.out.println(UserList.users[userSelect].inventory.katUser[j].tackleNumber);
                                        for (int k = 0; k<SelectUser.tacklesList.length; k++){
                                            if (SelectUser.tacklesList[k]!=null&&SelectUser.tacklesList[k].spinT.spinCount==UserList.users[userSelect].inventory.katUser[j].tackleNumber){
                                                SelectUser.tacklesList[k].katushkaT = UserList.users[userSelect].inventory.katUser[j];
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex){
                }
                try {
                    if (s1.contains("tackle:")) {
                        s1 = scanner.nextLine();
                        System.out.println(s1);
                            for (int j = 0; j < SelectUser.tacklesList.length; j++) {
                                if (SelectUser.tacklesList[j].spinT != null && SelectUser.tacklesList[j].spinT.spinCount == Integer.parseInt(s1)) {
                                    s1 = scanner.nextLine();
                                    for (int l = 0; l < UserList.users[userSelect].inventory.hooksUser.length;l++) {
                                        if (s1.equals(UserList.users[userSelect].inventory.hooksUser[l].hookName)){
                                            SelectUser.tacklesList[j].hookT = UserList.users[userSelect].inventory.hooksUser[l];
                                            break;
                                        }
                                        else SelectUser.tacklesList[j].hookT = null;
                                    }
                                    s1 = scanner.nextLine();
                                    for (int l = 0; l < UserList.users[userSelect].inventory.baitsUser.length;l++) {
                                        if (s1.equals(UserList.users[userSelect].inventory.baitsUser[l].baitsName)){
                                            SelectUser.tacklesList[j].baitsT = UserList.users[userSelect].inventory.baitsUser[l];
                                            break;
                                        }
                                        else SelectUser.tacklesList[j].baitsT = null;
                                    }
                                    break;
                                }
                            }
                    }
                }
                catch (Exception ex){
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}