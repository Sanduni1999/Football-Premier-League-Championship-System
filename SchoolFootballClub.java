package w1761916;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub {

    public SchoolFootballClub(int clubCategory, String clubName, String clubLocation, String clubType, int noOfWins, int noOfDraws, int defeats, int goalsReceived, int goalsScored, Double points, int noOfMatchesPlayed) {
        super(clubCategory, clubName, clubLocation, clubType, noOfWins, noOfDraws, defeats, goalsReceived, goalsScored, points, noOfMatchesPlayed);
    }

    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                super.toString()+
                '}';
    }
}