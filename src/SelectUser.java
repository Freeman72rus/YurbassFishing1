
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Unit2 on 16.03.20.
 */
class SelectUser {
    JFrame selectUser;
    String[] users = new String[20];
    JList usersList;
    JScrollPane jscrlp;
    JButton selectButton;
    YurbassFishing yf;
    static Tackle[] tacklesList = new Tackle[100];
    SelectUser(){
        selectUser = new JFrame("Выбор профиля");
        selectUser.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        selectUser.setLayout(new FlowLayout());
        selectUser.setSize(300,300);
        selectUser.setLocationRelativeTo(null);
        selectUser.setResizable(false);

        for (int i = 0; i < UserList.users.length; i++){
            users[i] = UserList.users[i].userName;
        }
        usersList = new JList(users);
        usersList.setSize(150,100);
        jscrlp = new JScrollPane(usersList);
        selectUser.add(jscrlp);
        selectButton = new JButton("Выбрать");
        selectUser.add(selectButton);
        selectUser.setVisible(true);
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int j = usersList.getSelectedIndex();
                if (j != -1){
                    YurbassFishing.userSelect = j;
                    YurbassFishing.loadGame();
                    yf = new YurbassFishing();
                    selectUser.setVisible(false);
                }
            }
        });
        for (int i = 0; i<tacklesList.length;i++){
            tacklesList[i] = new Tackle(UserList.users[YurbassFishing.userSelect].inventory.spinningsUser[i]);
        }
    }
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectUser();
            }
        });
    }
}
