package package01;
public class VisibilityManager {
    Ui ui;
    Player player;
    public VisibilityManager(Ui ui, Player player) {
       this.ui = ui;
       this.player = player;
    }

    public void hideStats(){
        ui.statsPanel.setVisible(false);
    }
    public void showFinalScreen(){
        ui.finalScreenPanel.setVisible(true);
        hideAllChoices();
        hideGameScreen();
        hideTitleScreen();
        hideStats();
    }
    public void hideAllChoices(){
        ui.statsChoicePanel.setVisible(false);
        ui.backButtonPanel.setVisible(false);
    }
    public void hideTitleScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.subTitleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
    }
    public void hideGameScreen(){
        ui.weekPanel.setVisible(false);
        ui.choicePanel.setVisible(false);
        ui.nextWeekButtonPanel.setVisible(false);
    }
    public void showTitleScreen(){

        //Start screen shown
        ui.titleNamePanel.setVisible(true);
        ui.subTitleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        ui.statsPanel.setVisible(false);
        ui.finalScreenPanel.setVisible(false);

        //Game screen hidden
        hideGameScreen();

        hideAllChoices();
    }


    public void showGameScreen(){
        //Start screen shown
        hideTitleScreen();
        //Game screen hidden
        ui.weekPanel.setVisible(true);
        ui.choicePanel.setVisible(true);
        ui.statsPanel.setVisible(true);
        ui.nextWeekButtonPanel.setVisible(true);
        ui.backButtonPanel.setVisible(false);
        hideAllChoices();
    }

    public void showStatsChoiceScreen(){
        hideTitleScreen();
        //Game screen hidden
        hideGameScreen();
        //Money screen shown
        ui.backButtonPanel.setVisible(true);
        ui.statsChoicePanel.setVisible(true);
    }







    public void updateScreen(){
        ui.weekLabel.setText("Week " + player.getWeek() + "/16");
        ui.healthLabel.setText("Health: " + player.getHealth());
        ui.gradeLabel.setText("Grade: " + player.getGrade() + "%");
        ui.moneyLabel.setText("Money: $" + player.getMoney());
        ui.happinessLabel.setText("Happiness: " + player.getHappiness());
    }
}
