package w1761916;

import java.util.Objects;

public abstract class FootballClub extends SportsClub implements Comparable<FootballClub> {

    private String clubType;
    //private String clubID;
    private int noOfWins;
    private int noOfDraws;
    private int defeats;
    private int goalsReceived;
    private int goalsScored;
    private Double points;
    private int noOfMatchesPlayed;

    public FootballClub(int clubCategory, String clubName, String clubLocation, String clubType, int noOfWins, int noOfDraws, int defeats, int goalsReceived, int goalsScored, Double points, int noOfMatchesPlayed) {
        super(clubCategory, clubName, clubLocation);
        this.clubType = clubType;
        //this.clubID = clubID;
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.points = points;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) {
        this.clubType = clubType;
    }
    /*
        public String getClubID() {
            return clubID;
        }

        public void setClubID(String clubID) {
            this.clubID = clubID;
        }
    */
    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                super.toString()+
                "clubType='" + clubType + '\'' +
                //", clubID='" + clubID + '\'' +
                ", noOfWins=" + noOfWins +
                ", noOfDraws=" + noOfDraws +
                ", defeats=" + defeats +
                ", GoalsReceived=" + goalsReceived +
                ", GoalsScored=" + goalsScored +
                ", points=" + points +
                ", noOfMatchesPlayed=" + noOfMatchesPlayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub club = (FootballClub) o;
        return noOfWins == club.noOfWins &&
                noOfDraws == club.noOfDraws &&
                defeats == club.defeats &&
                goalsReceived == club.goalsReceived &&
                goalsScored == club.goalsScored &&
                Double.compare(club.points, points) == 0 &&
                noOfMatchesPlayed == club.noOfMatchesPlayed &&
                Objects.equals(clubType, club.clubType);
        //Objects.equals(clubID, club.clubID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clubType, noOfWins, noOfDraws, defeats, goalsReceived, goalsScored, points, noOfMatchesPlayed);
    }

    @Override
    public int compareTo(FootballClub o) {
        Double comparePoints=((FootballClub)o).getPoints();
        return (int) (comparePoints-this.points);

    }
}