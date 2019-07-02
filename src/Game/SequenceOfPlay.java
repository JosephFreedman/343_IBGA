package Game;

import UI.MainGameScreen;

public class SequenceOfPlay {
    MainGameScreen mainGameScreen;

    SequenceOfPlay(MainGameScreen mainGameScreen) {
        this.mainGameScreen = mainGameScreen;
    }

    public void run(PlayerNode currentPlayer) {
        collectIncome();
        drawACard();
        takeTwoActions();
        takeFreeActions();
        transferMoney();
        takeSpecialPowerActions();
        addTargets();
    }


    private void collectIncome() {
        mainGameScreen.setPhase("Collect Income");
    }

    private void drawACard() {

    }

    private void takeTwoActions() {

    }

    private void takeFreeActions() {

    }

    private void transferMoney() {

    }

    private void takeSpecialPowerActions() {

    }

    private void addTargets() {

    }
}
