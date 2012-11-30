
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharBot {

    public static void main(String[] args) throws FileNotFoundException {
        new ChatFrame();
    }
}

class ChatFrame extends JFrame {

    private StringBuilder chatHistory = new StringBuilder();
    private JTextArea textArea;
    private JTextField textField;
    private Question q;

    /**
     * @throws FileNotFoundException
     */
    public ChatFrame() throws FileNotFoundException {
        q = new Question();
        
        textArea = new JTextArea(20, 50);
        textArea.setText(chatHistory.toString());
        textArea.setEditable(false);
        add(new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
                BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);

        textField = new JTextField();
        JButton sendButton = new JButton("Send");
        box.add(textField);
        box.add(sendButton);

        ActionListener sendListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = textField.getText();
                if (str != null && str.trim().length() > 0) {
                    inputText(str);
                }
                textField.setText("");
                answerText(q.getAnswer(str));
                textField.requestFocus();
            }
        };

        textField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        answerText("Hi, my name is Agent. And what is your name?");
        runMain();
    }

    public void runMain(){
        while (true) {
            long timer = System.currentTimeMillis();
            while ((System.currentTimeMillis()-timer<100000)) {}
            answerText("....");
        }
    }

    private void inputText (String str) {
        chatHistory.append("user: ");
        chatHistory.append(str);
        chatHistory.append("\n");
        textArea.setText(chatHistory.toString());
    }

    private void answerText (String str) {
        chatHistory.append("agent: ");
        chatHistory.append(str);
        chatHistory.append("\n");
        textArea.setText(chatHistory.toString());
    }

}




