public class Main {

    public static void main(String[] args) {

        int krunalScore = calculateHighScore(1020);
        displayHighScorePosition("Krunal",krunalScore);
        int timScore = calculateHighScore(500);
        displayHighScorePosition("Tim",timScore);
        int jack = calculateHighScore(-5656);
        displayHighScorePosition("jack",jack);
    }
    public static void displayHighScorePosition(String playerName,int position) {
        System.out.println(playerName + " managed to get " + position + " on high score table");
    }

    public static int calculateHighScore(int score) {
        if(score > 1000)
            return 1;
        else if(score >=500 && score <=1000)
            return 2;
        else if(score >=100 && score <500)
            return 3;
        else
            return 4;
    }
}
