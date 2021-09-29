package hw2;

public class SimpleTest {
    public static void main(String[] args) {
        Corkball game = new Corkball(3);
        System.out.println(game);

        System.out.println(game.isTopOfInning());
        game.strike(false);
        System.out.println(game);
        game.strike(false);
        System.out.println(game);
        game.strike(false);
        System.out.println(game);
        game.strike(false);
        System.out.println(game);

        game.strike(true);
        System.out.println(game.isTopOfInning());
        System.out.println(game);

        System.out.println("Hit testing");
        game = new Corkball(3);
        game.strike(false);
        game.hit(15);
        System.out.println(game);
        game.hit(15);
        System.out.println(game);
        game.hit(15);
        System.out.println(game);
        game.hit(15);
        System.out.println(game);

        game.hit(150);
        System.out.println(game);

        game = new Corkball(3);
        game.ball();
        System.out.println(game.getBallCount());
        game.ball();
        System.out.println(game.getBallCount());
        game.ball();
        System.out.println(game.getBallCount());
        game.strike(true);
        System.out.println(game.getBallCount());

        game = new Corkball(3);
        game.hit(225);
        System.out.println(game);
        game.ball();
        game.ball();
        game.ball();
        game.ball();
        System.out.println(game);
        game.ball();
        System.out.println(game);

        System.out.println("Testing homerun");
        game = new Corkball(3);
        game.hit(250);
        game.hit(150);
        game.hit(200);
        game.strike(true);
        game.strike(true);
        game.strike(true);
        System.out.println(game);
        game.hit(250);
        System.out.println(game);
    }
}