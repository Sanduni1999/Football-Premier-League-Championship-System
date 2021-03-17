package w1761916;

import java.io.Serializable;
import java.util.Objects;

public class PlayedMatch implements Serializable {
    private int day;
    private int month;
    private int year;

    private String clubName1;
    private int isWins1;
    private int isDraws1;
    private int isDefeats1;
    private int goalsReceived1;
    private int goalsScored1;
    private Double points1;

    private String clubName2;
    private int isWins2;
    private int isDraws2;
    private int isDefeats2;
    private int goalsReceived2;
    private int goalsScored2;
    private Double points2;

    public PlayedMatch(int day, int month, int year, String clubName1, int isWins1, int isDraws1, int isDefeats1, int goalsReceived1, int goalsScored1, Double points1, String clubName2, int isWins2, int isDraws2, int isDefeats2, int goalsReceived2, int goalsScored2, Double points2) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.clubName1 = clubName1;
        this.isWins1 = isWins1;
        this.isDraws1 = isDraws1;
        this.isDefeats1 = isDefeats1;
        this.goalsReceived1 = goalsReceived1;
        this.goalsScored1 = goalsScored1;
        this.points1 = points1;
        this.clubName2 = clubName2;
        this.isWins2 = isWins2;
        this.isDraws2 = isDraws2;
        this.isDefeats2 = isDefeats2;
        this.goalsReceived2 = goalsReceived2;
        this.goalsScored2 = goalsScored2;
        this.points2 = points2;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClubName1() {
        return clubName1;
    }

    public void setClubName1(String clubName1) {
        this.clubName1 = clubName1;
    }

    public int getIsWins1() {
        return isWins1;
    }

    public void setIsWins1(int isWins1) {
        this.isWins1 = isWins1;
    }

    public int getIsDraws1() {
        return isDraws1;
    }

    public void setIsDraws1(int isDraws1) {
        this.isDraws1 = isDraws1;
    }

    public int getIsDefeats1() {
        return isDefeats1;
    }

    public void setIsDefeats1(int isDefeats1) {
        this.isDefeats1 = isDefeats1;
    }

    public int getGoalsReceived1() {
        return goalsReceived1;
    }

    public void setGoalsReceived1(int goalsReceived1) {
        this.goalsReceived1 = goalsReceived1;
    }

    public int getGoalsScored1() {
        return goalsScored1;
    }

    public void setGoalsScored1(int goalsScored1) {
        this.goalsScored1 = goalsScored1;
    }

    public Double getPoints1() {
        return points1;
    }

    public void setPoints1(Double points1) {
        this.points1 = points1;
    }

    public String getClubName2() {
        return clubName2;
    }

    public void setClubName2(String clubName2) {
        this.clubName2 = clubName2;
    }

    public int getIsWins2() {
        return isWins2;
    }

    public void setIsWins2(int isWins2) {
        this.isWins2 = isWins2;
    }

    public int getIsDraws2() {
        return isDraws2;
    }

    public void setIsDraws2(int isDraws2) {
        this.isDraws2 = isDraws2;
    }

    public int getIsDefeats2() {
        return isDefeats2;
    }

    public void setIsDefeats2(int isDefeats2) {
        this.isDefeats2 = isDefeats2;
    }

    public int getGoalsReceived2() {
        return goalsReceived2;
    }

    public void setGoalsReceived2(int goalsReceived2) {
        this.goalsReceived2 = goalsReceived2;
    }

    public int getGoalsScored2() {
        return goalsScored2;
    }

    public void setGoalsScored2(int goalsScored2) {
        this.goalsScored2 = goalsScored2;
    }

    public Double getPoints2() {
        return points2;
    }

    public void setPoints2(Double points2) {
        this.points2 = points2;
    }

    @Override
    public String toString() {
        return "PlayedMatch{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", clubName1='" + clubName1 + '\'' +
                ", isWins1=" + isWins1 +
                ", isDraws1=" + isDraws1 +
                ", isDefeats1=" + isDefeats1 +
                ", goalsReceived1=" + goalsReceived1 +
                ", goalsScored1=" + goalsScored1 +
                ", points1=" + points1 +
                ", clubName2='" + clubName2 + '\'' +
                ", isWins2=" + isWins2 +
                ", isDraws2=" + isDraws2 +
                ", isDefeats2=" + isDefeats2 +
                ", goalsReceived2=" + goalsReceived2 +
                ", goalsScored2=" + goalsScored2 +
                ", points2=" + points2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayedMatch that = (PlayedMatch) o;
        return day == that.day &&
                month == that.month &&
                year == that.year &&
                isWins1 == that.isWins1 &&
                isDraws1 == that.isDraws1 &&
                isDefeats1 == that.isDefeats1 &&
                goalsReceived1 == that.goalsReceived1 &&
                goalsScored1 == that.goalsScored1 &&
                isWins2 == that.isWins2 &&
                isDraws2 == that.isDraws2 &&
                isDefeats2 == that.isDefeats2 &&
                goalsReceived2 == that.goalsReceived2 &&
                goalsScored2 == that.goalsScored2 &&
                Objects.equals(clubName1, that.clubName1) &&
                Objects.equals(points1, that.points1) &&
                Objects.equals(clubName2, that.clubName2) &&
                Objects.equals(points2, that.points2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, clubName1, isWins1, isDraws1, isDefeats1, goalsReceived1, goalsScored1, points1, clubName2, isWins2, isDraws2, isDefeats2, goalsReceived2, goalsScored2, points2);
    }
}
