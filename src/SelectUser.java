import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SelectUser {
    JFrame selectUser;
    String[] users = new String[20];
    JList usersList;
    JScrollPane jscrlp;
    JButton selectButton;
    YurbassFishing yf;
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

