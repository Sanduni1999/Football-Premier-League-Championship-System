package w1761916;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {

    private int clubCategory;
    private String clubName;
    private String clubLocation;

    public SportsClub(int clubCategory, String clubName, String clubLocation) {
        this.clubCategory = clubCategory;
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public int getClubCategory() {
        return clubCategory;
    }

    public void setClubCategory(int clubCategory) {
        this.clubCategory = clubCategory;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    @Override
    public String toString() {
        return
                "clubCategory='" + clubCategory + '\'' +
                        ", clubName='" + clubName + '\'' +
                        ", clubLocation='" + clubLocation + '\'' +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(clubCategory, that.clubCategory) &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubLocation, that.clubLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubCategory, clubName, clubLocation);
    }


}
