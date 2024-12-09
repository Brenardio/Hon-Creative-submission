package package01;
import javax.swing.*;
import java.awt.*;
import package01.Game.ChoiceHandler;

public class Ui {
    JFrame window;
    JPanel finalScreenPanel, titleNamePanel, subTitleNamePanel, startButtonPanel, choicePanel, statsPanel, weekPanel, backButtonPanel, nextWeekButtonPanel, statsChoicePanel;
    JLabel finalScreenLabel, titleNameLabel, subTitleNameLabel, weekLabel, moneyLabel, happinessLabel, gradeLabel, healthLabel;
    JButton startButton, healthButton, moneyButton, happinessButton, gradeButton, backButton, nextWeekButton, dynamicChoiceButton1, dynamicChoiceButton2;


    Font titleFont = new Font("Times New Roman", Font.BOLD, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font subTitleFont = new Font("Times New Roman", Font.BOLD, 18);
    public void createUi(ChoiceHandler choiceHandler, Player player) {
        //Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.getContentPane().setForeground(Color.white);
        window.setLayout(null);

        //Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("HON 100");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);

        subTitleNamePanel = new JPanel();
        subTitleNamePanel.setBounds(100, 200, 600, 250);
        subTitleNamePanel.setBackground(Color.black);
        subTitleNameLabel = new JLabel("surviving life as an honors student");
        subTitleNameLabel.setFont(subTitleFont);
        subTitleNameLabel.setForeground(Color.white);
        subTitleNamePanel.add(subTitleNameLabel);

        //start button
        //TODO: Figure out why the heck the background of the button wont change (Not that big of a problem but it would be nice to have control)Friday
        //DONE: it was the OS
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("Start");
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("start");
        startButton.setForeground(Color.black);
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.add(subTitleNamePanel);

        //choice buttons
        choicePanel = new JPanel();
        choicePanel.setBounds(150, 100, 500, 200);
        choicePanel.setBackground(Color.black);
        choicePanel.setForeground(Color.white);
        choicePanel.setLayout(new GridLayout(2, 2));
        window.add(choicePanel);

        healthButton = new JButton("Health");
        healthButton.setFont(normalFont);
        healthButton.setForeground(Color.black);
        healthButton.setBackground(Color.white);
        healthButton.setFocusPainted(false);
        healthButton.addActionListener(choiceHandler);
        healthButton.setActionCommand("health");
        choicePanel.add(healthButton);

        moneyButton = new JButton("Money");
        moneyButton.setFont(normalFont);
        moneyButton.setForeground(Color.black);
        moneyButton.setBackground(Color.white);
        moneyButton.setFocusPainted(false);
        moneyButton.addActionListener(choiceHandler);
        moneyButton.setActionCommand("money");
        choicePanel.add(moneyButton);

        happinessButton = new JButton("Happiness");
        happinessButton.setFont(normalFont);
        happinessButton.setForeground(Color.black);
        happinessButton.setBackground(Color.white);
        happinessButton.setFocusPainted(false);
        happinessButton.addActionListener(choiceHandler);
        happinessButton.setActionCommand("happiness");
        choicePanel.add(happinessButton);

        gradeButton = new JButton("Grade");
        gradeButton.setFont(normalFont);
        gradeButton.setForeground(Color.black);
        gradeButton.setBackground(Color.white);
        gradeButton.setFocusPainted(false);
        gradeButton.addActionListener(choiceHandler);
        gradeButton.setActionCommand("grade");
        choicePanel.add(gradeButton);

        weekPanel = new JPanel();
        weekPanel.setBounds(100, 10, 200, 100);
        weekPanel.setBackground(Color.black);
        weekPanel.setForeground(Color.white);
        weekLabel = new JLabel("Week " + player.getWeek() + "/16");
        weekLabel.setFont(normalFont);
        weekLabel.setForeground(Color.white);
        weekPanel.add(weekLabel);
        window.add(weekPanel);

        statsPanel = new JPanel();
        statsPanel.setBounds(200, 350, 400, 200);
        statsPanel.setBackground(Color.black);
        statsPanel.setForeground(Color.white);
        statsPanel.setLayout(new GridLayout(2, 2));
        window.add(statsPanel);

        healthLabel = new JLabel("Health: " + player.getHealth());
        healthLabel.setFont(normalFont);
        healthLabel.setForeground(Color.white);
        healthLabel.setBackground(Color.black);
        statsPanel.add(healthLabel);

        moneyLabel = new JLabel("Money: $" + player.getMoney());
        moneyLabel.setFont(normalFont);
        moneyLabel.setForeground(Color.white);
        moneyLabel.setBackground(Color.black);
        statsPanel.add(moneyLabel);

        happinessLabel = new JLabel("Happiness: " + player.getHappiness());
        happinessLabel.setFont(normalFont);
        happinessLabel.setForeground(Color.white);
        happinessLabel.setBackground(Color.black);
        statsPanel.add(happinessLabel);

        gradeLabel = new JLabel("Grade: " + player.getGrade() + "%");
        gradeLabel.setFont(normalFont);
        gradeLabel.setForeground(Color.white);
        gradeLabel.setBackground(Color.black);
        statsPanel.add(gradeLabel);

        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(5, 500, 200, 100);
        backButtonPanel.setBackground(Color.black);
        backButton = new JButton("Back");
        backButton.setFont(normalFont);
        backButton.setForeground(Color.black);
        backButton.addActionListener(choiceHandler);
        backButton.setActionCommand("back");
        backButtonPanel.add(backButton);
        window.add(backButtonPanel);

        nextWeekButtonPanel = new JPanel();
        nextWeekButtonPanel.setBounds(600, 500, 200, 100);
        nextWeekButtonPanel.setBackground(Color.black);
        nextWeekButton = new JButton("Next Week");
        nextWeekButton.setFont(normalFont);
        nextWeekButton.setForeground(Color.black);
        nextWeekButton.addActionListener(choiceHandler);
        nextWeekButton.setActionCommand("nextWeek");
        nextWeekButtonPanel.add(nextWeekButton);
        window.add(nextWeekButtonPanel);

    //Dynamic Panel for different choices :)
        statsChoicePanel = new JPanel();
        statsChoicePanel.setBounds(50,100,700,200);
        statsChoicePanel.setBackground(Color.black);
        statsChoicePanel.setLayout(new GridLayout(2,1));
        window.add(statsChoicePanel);
        dynamicChoiceButton1 = new JButton("");
        dynamicChoiceButton1.addActionListener(choiceHandler);
        dynamicChoiceButton1.setActionCommand("1");
        dynamicChoiceButton1.setFont(normalFont);
        dynamicChoiceButton1.setForeground(Color.black);
        dynamicChoiceButton1.setBackground(Color.black);
        statsChoicePanel.add(dynamicChoiceButton1);

        dynamicChoiceButton2 = new JButton("");
        dynamicChoiceButton2.addActionListener(choiceHandler);
        dynamicChoiceButton2.setActionCommand("2");
        dynamicChoiceButton2.setFont(normalFont);
        dynamicChoiceButton2.setForeground(Color.black);
        dynamicChoiceButton2.setBackground(Color.black);
        statsChoicePanel.add(dynamicChoiceButton2);

        finalScreenPanel = new JPanel();
        finalScreenPanel.setBounds(100, 100, 600, 100);
        finalScreenPanel.setBackground(Color.black);
       finalScreenLabel = new JLabel("GAME OVER!");
       finalScreenLabel.setFont(titleFont);
       finalScreenLabel.setForeground(Color.white);
       finalScreenLabel.setBackground(Color.black);
       window.add(finalScreenPanel);
        finalScreenPanel.add(finalScreenLabel);

        window.setVisible(true);
    }
}
