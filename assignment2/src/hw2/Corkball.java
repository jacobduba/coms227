package hw2;

/**
 * Model of an obscure game called "Corkball" or sometimes "Fuzzball", generally
 * played in the St Louis area.  It is vaguely similar to baseball, except that
 * it is much simpler since there are no actual bases and the runners are imaginary.
 * See the assignment pdf for further explanation.
 * 
 * @author Jacob Duba
 */
public class Corkball
{
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 2;

  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 5;

  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;

  // An int representing the current inning.
  private int inning;
  // A boolean representing if the inning is top or bottom.
  private boolean isTopOfInning;

  // An int representing the ball count for the current batter.
  private int ballCount;
  // An int representing the called strikes for the current batter.
  private int calledStrikes;
  // An int representing the called outs for the current team batting.
  private int currentOuts;

  // A boolean representing if a runner is on base 1.
  private boolean base1;
  // A boolean representing if a runner is on base 2.
  private boolean base2;
  // A boolean representing if a runner is on base 3.
  private boolean base3;

  // An int representing team 0's score.
  private int team0Score;
  // An int representing team 1's score.
  private int team1Score;

  // An int representing the maximum number of innings in this game.
  private int numInnings;

  /**
   * Constructs a game that has the given number of innings and starts at the top of inning 1.
   * @param givenNumInnings number of innings for the game
   */
  public Corkball(int givenNumInnings) {
    inning = 1;
    isTopOfInning = true;

    ballCount = 0;
    calledStrikes = 0;
    currentOuts = 0;

    base1 = false;
    base2 = false;
    base3 = false;

    numInnings = givenNumInnings;
  }

  /**
   * Method called to indicate a bad pitch at which the batter did not swing. This method adds 1 the batter's count of balls, possibly resulting in a walk.
   * <p>
   * This method does nothing if the game has ended.
   */
  public void ball() {
    if (!gameEnded()) {
      ballCount++;
      if (ballCount == MAX_BALLS) {
        newBatter();
        shiftRunnersBall();
      }
    }
  }

  /**
   * Method called to indicate that the batter is out due to a caught fly.
   * <p>
   * This method does nothing if the game has ended.
   */
  public void caughtFly() {
    strike(true);
  }

  /**
   * Returns true if the game is over, false otherwise.
   * @return true if the game is over, false otherwise
   */
  public boolean gameEnded() {
    return inning > numInnings;
  }

  /**
   * Returns the count of balls for the current batter.
   * @return current number of balls
   */
  public int getBallCount() {
    return ballCount;
  }

  /**
   * Returns the number of called strikes for the current batter.
   * @return current number of strikes
   */
  public int getCalledStrikes() {
    return calledStrikes;
  }

  /**
   * Returns the number of outs for the team currently at bat.
   * @return current number of outs
   */
  public int getCurrentOuts() {
    return currentOuts;
  }

  /**
   * Returns the score for team 0.
   * @return score for team 0.
   */
  public int getTeam0Score() {
    return team0Score;
  }

  /**
   * Returns the score for team 1.
   * @return score for team 1
   */
  public int getTeam1Score() {
    return team1Score;
  }

  /**
   * Method called to indicate that the batter hit the ball. The interpretation of the distance parameter is as follows:
   * <ul>
   *     <li>less than 15: the hit is a foul and the batter is immediately out.</li>
   *     <li>at least 15, but less than 150: the hit is a single. An imaginary runner advances to first base, and all other runners on base advance by 1. If there was a runner on third base, the score increases by 1. </li>
   *     <li>at least 150, but less than 200: the hit is a double. An imaginary runner advances to second base, and all other runners on base advance by 2. If there were runners on second or third, the score increases by 1 or 2. </li>
   *     <li>at least 200, but less than 250: the hit is a triple. An imaginary runner advances to third base, and all other runners on base advance by 3. If there were runners on first, second, or third, the score is increased by 1, 2, or 3. </li>
   *     <li>at least 250: the hit is a home run. All imaginary runners currently on base advance to home. The score is increased by 1 plus the number of runners on base.</li>
   * </ul>
   * This method does nothing if the game has ended.
   * @param distance distance the ball travels (possibly negative)
   */
  public void hit(int distance) {
    if (!gameEnded()) {
      newBatter();
      if (distance < 15) {
        // Strike out
        strike(true);
      } else if (distance < 150) {
        // Shift runners one base, set new runner at base1
        shiftRunnersHit();
        base1 = true;
      } else if (distance < 200) {
        // Shift runners two bases, set new runner at base2
        shiftRunnersHit();
        shiftRunnersHit();
        base2 = true;
      } else if (distance < 250) {
        // Shift runners three bases, set new runner at base3
        shiftRunnersHit();
        shiftRunnersHit();
        shiftRunnersHit();
        base3 = true;
      } else {
        // Shift runners three bases, just add one to the score because the new runner will not stop at any base.
        shiftRunnersHit();
        shiftRunnersHit();
        shiftRunnersHit();
        increaseScore();
      }
    }
  }

  /**
   * Moves all players to next base.
   */
  private void shiftRunnersHit() {
    // If runner on base3, remove runner from base3 and increase score
    if (base3) {
      base3 = false;
      increaseScore();
    }

    // If runner on base 2, remove runner from base 2 and add runner to base 3
    if (base2) {
      base2 = false;
      base3 = true;
    }

    // If runner on base 1, remove runner from base 1 and add runner to base 2
    if (base1) {
      base2 = true;
      base1 = false;
    }
  }

  /**
   * Lets a runner walk to first base.
   */
  private void shiftRunnersBall() {
    // If first base is already taken
    // Else set first base as taken
    if (base1) {
      // And if second base is taken too
      // Else set second base as taken
      if (base2) {
        // And if third base is taken too, score a point
        // Else set third base as taken
        if (base3) {
          increaseScore();
        } else {
          base3 = true;
        }
      } else {
        base2 = true;
      }
    } else {
      base1 = true;
    }
  }

  private void increaseScore() {
    if (isTopOfInning) {
      team0Score++;
    } else {
      team1Score++;
    }
  }

  private void newBatter() {
    ballCount = 0;
    calledStrikes = 0;
  }

  /**
   * Returns true if it's the first half of the inning (team 0 is at bat).
   * @return true if it's the first half of the inning, false otherwise
   */
  public boolean isTopOfInning() {
    return isTopOfInning;
  }

  /**
   * Returns true if there is a runner on the indicated base, false otherwise.
   * @param which an int representing which base.
   * @return boolean representing if there is a runner on the indicated base.
   */
  public boolean runnerOnBase(int which) {
    if (which == 1) {
      return base1;
    } else if (which == 2) {
      return base2;
    } else if (which == 3) {
      return base3;
    } else {
      return false;
    }
  }

  /**
   * Method called to indicate a strike for the current batter. If the swung parameter is true, the batter is immediately out. Otherwise, 1 is added to the batters current count of called strikes (possibly resulting in the batter being out).
   * <p>
   * This method does nothing if the game has ended.
   * @param swung true if the batter swung at the pitch, false if it's a "called" strike.
   */
  public void strike(boolean swung) {
    if (!gameEnded()) {
      calledStrikes++;
      if (swung || getCalledStrikes() == MAX_STRIKES) {
        currentOuts++;
        newBatter();

        // If team reached MAX_OUTS, switch teams
        if (currentOuts == MAX_OUTS) {
          currentOuts = 0;
          // Change inning if it's the bottom
          if (!isTopOfInning) {
            inning++;
          }
          isTopOfInning = !isTopOfInning;
          calledStrikes = 0;
          base1 = false;
          base2 = false;
          base3 = false;
        }
      }
    }
  }

  /**
   * Returns the current inning. Innings are numbered starting at 1. When the game is over, this method returns the game's total number of innings, plus one.
   * @return current inning, or the number of innings plus one in case the game is over
   */
  public int whichInning() {
    return inning;
  }

  // The methods below are provided for you and you should not modify them.
  // The compile errors will go away after you have written stubs for the
  // rest of the API methods.
  /**
   * Returns a three-character string representing the players on base, in the
   * order first, second, and third, where 'X' indicates a player is present and
   * 'o' indicates no player. For example, the string "XXo" means that there are
   * players on first and second but not on third.
   *
   * @return three-character string showing players on base
   */
  public String getBases()
  {
    return (runnerOnBase(1) ? "X" : "o") + (runnerOnBase(2) ? "X" : "o")
        + (runnerOnBase(3) ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state. The
   * format is:
   *
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * 
   * The first three characters represent the players on base as returned by the
   * <code>getBases()</code> method. The 'T' after the inning number indicates
   * it's the top of the inning, and a 'B' would indicate the bottom. The score always
   * shows team 0 first.
   * 
   * @return one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTopOfInning() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, whichInning(), topOrBottom, getTeam0Score(),
        getTeam1Score(), getBallCount(), getCalledStrikes(), getCurrentOuts());
  }


}
