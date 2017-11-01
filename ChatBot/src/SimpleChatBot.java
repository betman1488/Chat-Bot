import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleChatBot extends JFrame implements ActionListener{

    final String TITLE_OF_PROGRAM = "Chatter: simle chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String CHB_AI = "AI";
    final String BTN_ENTER = "Enter";

    JTextArea dialogue;
    JCheckBox ai;
    JTextField massage;
    SimpleBot sbot;
    SimpleAttributeSet botStyle;


    SimpleChatBot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);


        dialogue = new JTextArea();
        dialogue.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(dialogue);

        botStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(botStyle, true);
        StyleConstants.setForeground(botStyle, Color.blue);

        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox(CHB_AI);
        ai.doClick();
        massage = new JTextField();
        massage.addActionListener(this);
        JButton enter = new JButton(BTN_ENTER);
        enter.addActionListener(this);

        bp.add(ai);
        bp.add(massage);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (massage.getText().trim().length() > 0) {
            dialogue.append(massage.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) + sbot.sayInReturn(massage.getText(), ai.isSelected()) + "\n");
        }
        massage.setText("");
        massage.requestFocusInWindow();

    }

    public static void main(String[] args) {
        new SimpleChatBot();
    }

}
