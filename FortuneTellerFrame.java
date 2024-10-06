import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel MainPanel;
    JPanel TitlePanel;
    JPanel DisplayPanel;
    JPanel ControlPanel;

    JButton GetFortuneButton;
    JButton QuitButton;

    JLabel TitleLabel;
    ImageIcon Icon;

    JTextArea FortuneTextArea;
    JScrollPane Scroller;

    /*Random gen = new Random();*/
    ArrayList<String> FortuneList;

    int PreviousFortune = -1;

    public FortuneTellerFrame() {

        FortuneList = new ArrayList<>();
        FortuneList.add("YOU WILL SOON BE THE LIFE OF THE PARTY...BUT ONLY IF YOU BRING SNACKS");
        FortuneList.add("YOUR FUTURE IS AS BRIGHT AS YOUR COMPUTER SCREEN AT 2AM");
        FortuneList.add("A STRANGER WILL SOON OFFER YOU UNWANTED ADVICE. PLEASE IGNORE THEM");
        FortuneList.add("GOOD THINGS COME TO THOSE WHO WAIT. JUST BE PATIENT UNTIL SNACK TIME");
        FortuneList.add("YOU WILL SOON FIND THE ANSWER TO LIFE'S BIGGEST QUESTION...'WHATS FOR DINNER'");
        FortuneList.add("FORTUNE FAVORS THE BOLD");
        FortuneList.add("YOU WILL RECEIVE GOOD NEWS SOON");
        FortuneList.add("HAPPINESS IS IN YOUR FUTURE");
        FortuneList.add("A NEW ADVENTURE IS COMING YOUR WAY");
        FortuneList.add("YOUR HARD WORK WILL SOON PAY OFF");
        FortuneList.add("SOMETHING UNEXPECTED WILL BRING YOU JOY");
        FortuneList.add("YOU WILL HAVE A GREAT DAY!");

        //Assemble GUI
        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        add(MainPanel, BorderLayout.CENTER);

        createTitlePanel();
        MainPanel.add(TitlePanel, BorderLayout.NORTH);

        createDisplayPanel();
        MainPanel.add(DisplayPanel, BorderLayout.CENTER);

        createControlPanel();
        MainPanel.add(ControlPanel, BorderLayout.SOUTH);
        add(MainPanel);

        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createTitlePanel() {
        TitlePanel = new JPanel();
        Icon = new ImageIcon("C:\\Users\\danie\\IdeaProjects\\Fortune_Teller.jpg\\");
        TitleLabel = new JLabel("Welcome to My Fortune Teller", Icon, JLabel.CENTER);
        TitleLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        TitleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        TitleLabel.setHorizontalTextPosition(JLabel.CENTER);
        TitlePanel.add(TitleLabel);
    }

    private void createDisplayPanel() {
        DisplayPanel = new JPanel();
        FortuneTextArea = new JTextArea(10,45);
        FortuneTextArea.setEditable(false);
        FortuneTextArea.setFont(new Font("Monospaced", Font.PLAIN,12 ));
        Scroller = new JScrollPane(FortuneTextArea);
        DisplayPanel.add(Scroller);
    }

    private void createControlPanel() {
        ControlPanel = new JPanel();
        ControlPanel.setLayout(new GridLayout(1,2));

        GetFortuneButton = new JButton("My Fortune!");
        GetFortuneButton.addActionListener((ActionEvent ae) -> {

            String fortune = getRandomFortune();
            FortuneTextArea.append(fortune + "\n");
        });


        QuitButton = new JButton("Quit!");
        QuitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        ControlPanel.add(GetFortuneButton);
        ControlPanel.add(QuitButton);
    }

    private String getRandomFortune() {
        int index = PreviousFortune;
        while(index == PreviousFortune) {
            index = new Random().nextInt(FortuneList.size());
        }
        PreviousFortune = index;
        return FortuneList.get(index);
    }
}