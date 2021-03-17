package w1761916;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    static LeagueManager manager=new PremierLeagueManager();
    final static Scanner userInput=new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        while(true) {
            System.out.println("Welcome to the Premier League system! Please select your preferred option. ");
            System.out.println("1 = Add a football club");
            System.out.println("2 = Delete a football club");
            System.out.println("3 = Show statistics");
            System.out.println("4 = Show Premier League Table");
            System.out.println("5 = Add a Played Match");
            System.out.println("6 = Graphical User Interface (GUI)");
            System.out.println("7 = Save data to the file");
            System.out.println("8 = Load data from the file");
            System.out.println("9 = Quit");

           // menu:
           // while(true) {
            //    showMenu();
                int choice=userInput.nextInt();
                switch (choice) {
                    case 1:
                        addClub();
                        break;

                    case 2:
                        deleteClub();
                        break;

                    case 3:
                        statistics();
                        break;

                    case 4:
                        manager.premierLeagueTable();
                        break;

                    case 5:
                        addPlayedMatch();
                        break;

                    case 6:
                        manager.gui();
                        break;

                    case 7:
                        manager.saveInFile("text.txt");
                        break;
                    case 8:
                        manager.loadFile("text.txt") ;
                        break;

                    case 9:
                        System.out.println("Thank you for using the application!");
                        System.exit(1);
                        //manager.saveInFile("text.txt");
                        //break menu;

                    default:
                        System.out.println("Invalid option. Please try again");
                }
            }
        }


    private static void addClub() {

        FootballClub footballClub = null; //to be changed

        System.out.println("Please enter the club Category. 1. Football Club/ 2. Other");
        System.out.println("Please enter the relevant number only. ");
        int clubCategory = userInput.nextInt();
        System.out.println("Please enter the club name:");
        String clubName = userInput.next();
        System.out.println("Please enter the club location:");
        String clubLocation = userInput.next();


        if (clubCategory == 1) {

            System.out.println("Please enter the club type. 1. University Football Club/ 2. School Football Club ");
            System.out.println("Please enter the relevant number only. ");
            String clubType = userInput.next();
            //System.out.println("Please enter the club ID");
            //int clubID = userInput.nextLine();
            System.out.println("Please enter the number of wins");
            int noOfWins = userInput.nextInt();
            System.out.println("Please enter the number of draws");
            int noOfDraws = userInput.nextInt();
            System.out.println("Please enter the number of defeats");
            int defeats = userInput.nextInt();
            System.out.println("Please enter the goals received");
            int goalsReceived = userInput.nextInt();
            System.out.println("Please enter the goals scored");
            int goalsScored = userInput.nextInt();
            System.out.println("Please enter the points");
            Double points = userInput.nextDouble();
            System.out.println("Please enter the number of matches played");
            int noOfMatchesPlayed = userInput.nextInt();

            if (clubType.equals("1")) {

                footballClub = new UniversityFootballClub(clubCategory, clubName, clubLocation, clubType, noOfWins, noOfDraws, defeats, goalsReceived, goalsScored, points, noOfMatchesPlayed);

            } else {

                footballClub = new SchoolFootballClub(clubCategory, clubName, clubLocation, clubType, noOfWins, noOfDraws, defeats, goalsReceived, goalsScored, points, noOfMatchesPlayed);

            }

        } else {
            System.out.println("Contact manager office");
        }

        manager.addClub(footballClub);
        System.out.println();

    }

    private static void deleteClub() {
        System.out.println("Please enter the club name:");
        String clubName=userInput.next();

        manager.deleteClub(clubName);

    }

    private static void statistics() {
        System.out.println("Please enter the club name:");
        String clubName=userInput.next();

        manager.statistics(clubName);

    }

    private static void premierLeagueTable() {
        manager.premierLeagueTable();

    }

    private static void addPlayedMatch() {

        PlayedMatch playedMatch = null;

        System.out.println("Please Enter the Date of the match: ");
        int day = userInput.nextInt();

        System.out.println("Please Enter the Month of the match: ");
        int month = userInput.nextInt();

        System.out.println("Please Enter the Year of the match: ");
        int year = userInput.nextInt();

        System.out.println("Please enter the 1st club name:");
        String clubName1 = userInput.next();

        System.out.println("Win?      1.Yes / 2.No");
        System.out.println("Enter the relevant number only.");
        int isWins1 = userInput.nextInt();
        System.out.println("Draw? 1.Yes / 2.No");
        int isDraws1 = userInput.nextInt();
        System.out.println("Defeats 1.Yes / 2.No");
        int isDefeats1 = userInput.nextInt();
        System.out.println("Please enter the goals received");
        int goalsReceived1 = userInput.nextInt();
        System.out.println("Please enter the goals scored");
        int goalsScored1 = userInput.nextInt();
        System.out.println("Please enter the points");
        Double points1 = userInput.nextDouble();

        System.out.println("Please enter the 2nd club name:");
        String clubName2 = userInput.next();

        System.out.println("Win?      1.Yes / 2.No");
        System.out.println("Enter the relevant number only.");
        int isWins2 = userInput.nextInt();
        System.out.println("Draw? 1.Yes / 2.No");
        int isDraws2 = userInput.nextInt();
        System.out.println("Defeats 1.Yes / 2.No");
        int isDefeats2 = userInput.nextInt();
        System.out.println("Please enter the goals received");
        int goalsReceived2 = userInput.nextInt();
        System.out.println("Please enter the goals scored");
        int goalsScored2 = userInput.nextInt();
        System.out.println("Please enter the points");
        Double points2 = userInput.nextDouble();

        playedMatch = new PlayedMatch(day,month,year,clubName1,isWins1,isDraws1,isDefeats1,goalsReceived1,goalsScored1,points1,clubName2,isWins2,isDraws2,isDefeats2,goalsReceived2,goalsScored2,points2);

        manager.addPlayedMatch(playedMatch);
        System.out.println();
    }

}
