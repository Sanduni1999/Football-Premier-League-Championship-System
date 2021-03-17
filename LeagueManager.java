package w1761916;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LeagueManager {

    void addClub(FootballClub footballClub);
    void deleteClub(String clubName);
    void statistics(String clubName);
    void premierLeagueTable();
    void addPlayedMatch(PlayedMatch playedMatch);
    void saveInFile(String fileName) throws IOException;
    void loadFile(String fileName) throws IOException, ClassNotFoundException;
    void gui();
}


