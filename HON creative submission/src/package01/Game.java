package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game{
    Choices choices = new Choices();
    Ui ui = new Ui();
    Player player = new Player(100,100,100,1, 3000.00);
    ChoiceHandler choiceHandler = new ChoiceHandler();
    VisibilityManager visibilityManager = new VisibilityManager(ui, player);

    public static void main(String[] args) {
            new Game();
    }

    public Game(){
        ui.createUi(choiceHandler, player);
        visibilityManager.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        String state;
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            switch (command) {
                case "start", "back":
                    state = "back";
                    visibilityManager.showGameScreen();
                    break;
                case "money":
                    state = command;
                    moneyChoice(command);
                    break;
                case "health":
                    state = command;
                    healthChoice(command);
                    break;
                case "happiness":
                    state = command;
                    happinessChoice(command);
                    break;
                case "grade":
                    state = command;
                    gradesChoice(command);
                    break;
                case "nextWeek":
                    player.setWeek(player.getWeek() + 1);
                    player.setHealth(player.getHealth() - 5);
                    player.setHappiness(player.getHappiness() - 10);
                    player.setGrade(player.getGrade() - 10);
                    visibilityManager.updateScreen();
                    if (player.getWeek() == 16 || player.getGrade() < 0 || player.getHealth() < 0 || player.getHappiness() < 0) {
                        visibilityManager.showFinalScreen();
                    }
                    break;
                case "1", "2":
                    if (state.equals("money")) {
                        moneyChoice(command);
                    }
                    if (state.equals("happiness")) {
                        happinessChoice(command);
                    }
                    if(state.equals("grade")){
                        gradesChoice(command);
                    }
                    if(state.equals("health")){
                        healthChoice(command);
                    }
                    break;
                default:
                    break;
            }


        }

        public void moneyChoice(String command) {
            visibilityManager.showStatsChoiceScreen();
            int week = player.getWeek();
            ui.dynamicChoiceButton1.setText(choices.moneyChoices[2 * week - 2]);
            ui.dynamicChoiceButton2.setText(choices.moneyChoices[2 * week - 1]);
            visibilityManager.updateScreen();
            System.out.println(command);
            switch (command) {
                case "1":
                    updateWeights1();
                    visibilityManager.updateScreen();
                    visibilityManager.showGameScreen();
                    break;
                case "2":
                    updateWeights2();
                    visibilityManager.updateScreen();
                    visibilityManager.showGameScreen();
                    break;
            }

        }

        public void healthChoice(String command) {
            visibilityManager.showStatsChoiceScreen();
            visibilityManager.showStatsChoiceScreen();
            int week = player.getWeek();
            ui.dynamicChoiceButton1.setText(choices.healthChoices[2 * week - 2]);
            ui.dynamicChoiceButton2.setText(choices.healthChoices[2 * week - 1]);
            visibilityManager.updateScreen();
            System.out.println(command);
            switch (command) {
                case "1":
                    updateWeights1();
                    visibilityManager.updateScreen();
                    visibilityManager.showGameScreen();
                    break;
                case "2":
                    updateWeights2();
                    visibilityManager.updateScreen();
                    visibilityManager.showGameScreen();
                    break;
            }
        }
            public void happinessChoice (String command){
                visibilityManager.showStatsChoiceScreen();
                visibilityManager.showStatsChoiceScreen();
                int week = player.getWeek();
                ui.dynamicChoiceButton1.setText(choices.happinessChoices[2 * week - 2]);
                ui.dynamicChoiceButton2.setText(choices.happinessChoices[2 * week - 1]);
                visibilityManager.updateScreen();
                System.out.println(command);
                switch (command) {
                    case "1":
                        updateWeights1();
                        visibilityManager.updateScreen();
                        visibilityManager.showGameScreen();
                        break;
                    case "2":
                        updateWeights2();
                        visibilityManager.updateScreen();
                        visibilityManager.showGameScreen();
                        break;
                }
                }
                public void gradesChoice (String command){
                    visibilityManager.showStatsChoiceScreen();
                    visibilityManager.showStatsChoiceScreen();
                    int week = player.getWeek();
                    ui.dynamicChoiceButton1.setText(choices.gradeChoice[2 * week - 2]);
                    ui.dynamicChoiceButton2.setText(choices.gradeChoice[2 * week - 1]);
                    visibilityManager.updateScreen();
                    System.out.println(command);
                    switch (command) {
                        case "1":
                            updateWeights1();
                            visibilityManager.updateScreen();
                            visibilityManager.showGameScreen();
                            break;
                        case "2":
                            updateWeights2();
                            visibilityManager.updateScreen();
                            visibilityManager.showGameScreen();
                            break;

                    }
                }
                public void updateWeights1(){
                    int week = player.getWeek();
                    int current = 2 * week - 2;
                    switch(state){
                        case "money":
                            player.setHappiness((player.getHappiness() +choices.moneyChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.moneyChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.moneyChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.moneyChoiceWeights[current][0]));
                            break;
                        case "happiness":
                            player.setHappiness((player.getHappiness() +choices.happinessChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.happinessChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.happinessChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.happinessChoiceWeights[current][0]));
                            break;
                        case "grade":
                            player.setHappiness((player.getHappiness() +choices.happinessChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.gradeChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.healthChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.moneyChoiceWeights[current][0]));
                            break;
                        case "health":
                            player.setHappiness((player.getHappiness() +choices.healthChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.healthChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.healthChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.healthChoiceWeights[current][0]));
                            break;
                    }
                    System.out.println("{" + (player.getMoney() +choices.moneyChoiceWeights[current][0]) + "," + (player.getGrade() + (choices.gradeChoiceWeights[current][1])) + "," +(player.getHappiness() +choices.happinessChoiceWeights[current][2]) + "," +(player.getHealth() +choices.healthChoiceWeights[current][3]) + "}");
                }


                public void updateWeights2(){
                int week = player.getWeek();
                int current = 2  * week - 1;
                    switch(state){
                        case "money":
                            player.setHappiness((player.getHappiness() +choices.moneyChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.moneyChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.moneyChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.moneyChoiceWeights[current][0]));
                            break;
                        case "happiness":
                            player.setHappiness((player.getHappiness() +choices.happinessChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.happinessChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.happinessChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.happinessChoiceWeights[current][0]));
                            break;
                        case "grade":
                            player.setHappiness((player.getHappiness() +choices.happinessChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.gradeChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.healthChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.moneyChoiceWeights[current][0]));
                            break;
                        case "health":
                            player.setHappiness((player.getHappiness() +choices.healthChoiceWeights[current][2]));
                            player.setGrade((player.getGrade() +choices.healthChoiceWeights[current][1]));
                            player.setHealth((player.getHealth() +choices.healthChoiceWeights[current][3]));
                            player.setMoney((player.getMoney() +choices.healthChoiceWeights[current][0]));
                            break;
                    }
                    System.out.println("{" + (player.getMoney() +choices.moneyChoiceWeights[current][0]) + "," + (player.getGrade() + (choices.gradeChoiceWeights[current][1])) + "," +(player.getHappiness() +choices.happinessChoiceWeights[current][2]) + "," +(player.getHealth() +choices.healthChoiceWeights[current][3]) + "}");
                }
            }
        }

