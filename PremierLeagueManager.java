package w1761916;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PremierLeagueManager implements LeagueManager,Serializable {

    Stage primaryStage=new Stage();
    Scene scene1,scene2,scene3,scene4,scene5;

    private List <FootballClub> footballClubList=new ArrayList<>();
    private List <PlayedMatch> playedMatchList=new ArrayList<>();
    ArrayList<FootballClub> pointsSortedClubs = new ArrayList<>();
    ArrayList<FootballClub> goalScoredSortedClubs = new ArrayList<>();
    ArrayList<FootballClub> noOfWinsSortedClubs=new ArrayList<>();

    @Override
    public void addClub(FootballClub footballClub) {
        if(footballClubList.contains(footballClub)){
            System.out.println("Already registered.");
        }else {
            footballClubList.add(footballClub);
        }
        System.out.println(footballClubList);

    }

    @Override
    public void deleteClub(String clubName) {
        boolean isThere=false;

        for(FootballClub footballClub:footballClubList ){
            if(footballClub.getClubName().equals(clubName)){
                footballClubList.remove(footballClub);
                System.out.printf("%s has been removed from the system.",footballClub instanceof UniversityFootballClub? "UniversityFootballClub":"SchoolFootballClub");
                break;
            }
        }
        if (!isThere) {
            System.out.println("Invalid!");

        }
        System.out.println(footballClubList);

    }

    @Override
    public void statistics(String clubName) {

        List <FootballClub> exactFootballClubList=new ArrayList<>();

        for(FootballClub footballClub:footballClubList ){
            if(footballClub.getClubName().equals(clubName)){
                exactFootballClubList.add(footballClub);
                System.out.println(exactFootballClubList);
                //System.out.println(exactFootballClubList.size());

                break;
            }else{
                System.out.println("Invalid club name.");
            }
        }


    }

    @Override
    public void premierLeagueTable() {

        Collections.sort(footballClubList);
        for(FootballClub footballClub:footballClubList){
            System.out.println(footballClub);
        }

    }

    @Override
    public void addPlayedMatch(PlayedMatch playedMatch) {
        playedMatchList.add(playedMatch);
        System.out.println(playedMatchList);

    }


    public void saveInFile(String fileName) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

        for(FootballClub club:footballClubList){
            objectOutputStream.writeObject(club);

        }

        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();

        System.out.println("All the data has been saved in a file.");
    }


    public void loadFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(fileName);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        for(;;){
            try{
                FootballClub club=(FootballClub)objectInputStream.readObject();
                footballClubList.add(club);
            }catch (EOFException e){
                break;
            }
        }

        fileInputStream.close();
        objectInputStream.close();

        System.out.println("All the data has been loaded.");

    }

    public void gui(){

        GridPane gridPane=new GridPane();
        gridPane.setMinSize(800, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);


        Button button1=new Button("Descending order-points");
        Button button2=new Button("Descending order-goals scored");
        Button button3=new Button("Descending order-number of wins");
        Button button4=new Button("Random Match");

        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);
        gridPane.add(button3, 2, 2);
        gridPane.add(button4, 3, 2);

        button1.setOnAction(e ->primaryStage.setScene(SceneTwo()) );
        button2.setOnAction(event ->primaryStage.setScene(SceneThree()));
        button3.setOnAction(event ->primaryStage.setScene(SceneFour()));
        button4.setOnAction(event ->primaryStage.setScene(SceneFive()));


        scene1 = new Scene(gridPane, 700, 500);
        primaryStage.setScene(scene1);
        primaryStage.showAndWait();
    }

    public Scene SceneTwo() {
        for (int index=0;index<footballClubList.size();index++) {
            pointsSortedClubs.add(index,footballClubList.get(index));
        }

        Collections.sort(pointsSortedClubs, (o1, o2) -> {
            Double rollno1 = o1.getPoints();
            Double rollno2 = o2.getPoints();
            return Double.compare(rollno2,rollno1);
        });

        ScrollPane scrollPane = new ScrollPane();


        TableColumn<FootballClub,String > clubName = new TableColumn<>("Club Name");
        clubName.setMinWidth(200);
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub,String >clubLocation = new TableColumn<>("Club Location");
        clubLocation.setMinWidth(200);
        clubLocation.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));

        TableColumn<FootballClub,String >clubType = new TableColumn<>("Club Type");
        clubType.setMinWidth(200);
        clubType.setCellValueFactory(new PropertyValueFactory<>("clubType"));

        TableColumn<FootballClub,Integer > numberOfGoals = new TableColumn<>("Number of Goals");
        numberOfGoals.setMinWidth(200);
        numberOfGoals.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

        TableColumn<FootballClub,Integer > goalsReceived= new TableColumn<>("Total Points");
        goalsReceived.setMinWidth(200);
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        TableColumn<FootballClub,Integer >  goalDifference = new TableColumn<>("Goal Difference");
        goalDifference.setMinWidth(200);
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));

        TableColumn<FootballClub,Integer >  totPoints = new TableColumn<>("Goals Received");
        totPoints.setMinWidth(200);
        totPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<FootballClub,Integer >  matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setMinWidth(200);
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FootballClub,Integer >  numberOfWins = new TableColumn<>("Number of Wins");
        numberOfWins.setMinWidth(200);
        numberOfWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));

        TableColumn<FootballClub,Integer >  numberOfDraws = new TableColumn<>("Number Of Draws");
        numberOfDraws.setMinWidth(200);
        numberOfDraws.setCellValueFactory(new PropertyValueFactory<>("numberOfDraws"));

        TableColumn<FootballClub,Integer >  numberOfDefeats = new TableColumn<>("Number Of Defeats");
        numberOfDefeats.setMinWidth(200);
        numberOfDefeats.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeats"));


        TableView<FootballClub> tableView=new TableView<>();
        tableView.setItems(getPointsData());
        tableView.getColumns().addAll(clubName,clubLocation,clubType,numberOfGoals,goalsReceived,goalDifference,totPoints,matchesPlayed,numberOfWins,numberOfDraws,numberOfDefeats);



        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(tableView);
        scene2 = new Scene(scrollPane, 3000, 1000);
        pointsSortedClubs.clear();
        return scene2;
    }
    public Scene SceneThree() {
        for (int index=0;index<footballClubList.size();index++) {
            goalScoredSortedClubs.add(index,footballClubList.get(index));
        }

        Collections.sort(goalScoredSortedClubs, (o1, o2) -> {
            int roll1 = o1.getGoalsScored();
            int roll2 = o2.getGoalsScored();
            return Integer.compare(roll2,roll1);
        });

        ScrollPane scrollPane1 = new ScrollPane();


        TableColumn<FootballClub,String > clubName = new TableColumn<>("Club Name");
        clubName.setMinWidth(200);
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub,String >clubLocation = new TableColumn<>("Club Location");
        clubLocation.setMinWidth(200);
        clubLocation.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));

        TableColumn<FootballClub,String >clubType = new TableColumn<>("Club Type");
        clubType.setMinWidth(200);
        clubType.setCellValueFactory(new PropertyValueFactory<>("clubType"));

        TableColumn<FootballClub,Integer > numberOfGoals = new TableColumn<>("Goals Received");
        numberOfGoals.setMinWidth(200);
        numberOfGoals.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

        TableColumn<FootballClub,Integer > goalsReceived= new TableColumn<>("Number of Goals");
        goalsReceived.setMinWidth(200);
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        TableColumn<FootballClub,Integer >  goalDifference = new TableColumn<>("Goal Difference");
        goalDifference.setMinWidth(200);
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));

        TableColumn<FootballClub,Integer >  totPoints = new TableColumn<>("Total Points");
        totPoints.setMinWidth(200);
        totPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<FootballClub,Integer >  matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setMinWidth(200);
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FootballClub,Integer >  numberOfWins = new TableColumn<>("Number of Wins");
        numberOfWins.setMinWidth(200);
        numberOfWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));

        TableColumn<FootballClub,Integer >  numberOfDraws = new TableColumn<>("Number Of Draws");
        numberOfDraws.setMinWidth(200);
        numberOfDraws.setCellValueFactory(new PropertyValueFactory<>("numberOfDraws"));

        TableColumn<FootballClub,Integer >  numberOfDefeats = new TableColumn<>("Number Of Defeats");
        numberOfDefeats.setMinWidth(200);
        numberOfDefeats.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeats"));


        TableView<FootballClub> tableView1=new TableView<>();
        tableView1.setItems(getGoalsScoreData());
        tableView1.getColumns().addAll(clubName,clubLocation,clubType,numberOfGoals,goalsReceived,goalDifference,totPoints,matchesPlayed,numberOfWins,numberOfDraws,numberOfDefeats);



        scrollPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane1.setContent(tableView1);
        scene3 = new Scene(scrollPane1, 3000, 1000);
        goalScoredSortedClubs.clear();
        return scene3;

    }
    public Scene SceneFour() {
        for (int index=0;index<footballClubList.size();index++) {
            noOfWinsSortedClubs.add(index,footballClubList.get(index));
        }

        Collections.sort(noOfWinsSortedClubs, (o1, o2) -> {
            int roll1 = o1.getNoOfDraws();
            int roll2 = o2.getNoOfWins();
            return Integer.compare(roll2,roll1);
        });

        ScrollPane scrollPane1 = new ScrollPane();

        TableColumn<FootballClub,String > clubName = new TableColumn<>("Club Name");
        clubName.setMinWidth(200);
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub,String >clubLocation = new TableColumn<>("Club Location");
        clubLocation.setMinWidth(200);
        clubLocation.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));

        TableColumn<FootballClub,String >clubType = new TableColumn<>("Club Type");
        clubType.setMinWidth(200);
        clubType.setCellValueFactory(new PropertyValueFactory<>("clubType"));

        TableColumn<FootballClub,Integer > numberOfGoals = new TableColumn<>("Number of Goals");
        numberOfGoals.setMinWidth(200);
        numberOfGoals.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

        TableColumn<FootballClub,Integer > goalsReceived= new TableColumn<>("Number of Wins");
        goalsReceived.setMinWidth(200);
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        TableColumn<FootballClub,Integer >  goalDifference = new TableColumn<>("Goal Difference");
        goalDifference.setMinWidth(200);
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));

        TableColumn<FootballClub,Integer >  totPoints = new TableColumn<>("Total Points");
        totPoints.setMinWidth(200);
        totPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<FootballClub,Integer >  matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setMinWidth(200);
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FootballClub,Integer >  numberOfWins = new TableColumn<>("Goals Received");
        numberOfWins.setMinWidth(200);
        numberOfWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));

        TableColumn<FootballClub,Integer >  numberOfDraws = new TableColumn<>("Number Of Draws");
        numberOfDraws.setMinWidth(200);
        numberOfDraws.setCellValueFactory(new PropertyValueFactory<>("numberOfDraws"));

        TableColumn<FootballClub,Integer >  numberOfDefeats = new TableColumn<>("Number Of Defeats");
        numberOfDefeats.setMinWidth(200);
        numberOfDefeats.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeats"));

        TableView<FootballClub> tableView1=new TableView<>();
        tableView1.setItems(getNoOfWinsData());
        tableView1.getColumns().addAll(clubName,clubLocation,clubType,numberOfGoals,goalsReceived,goalDifference,totPoints,matchesPlayed,numberOfWins,numberOfDraws,numberOfDefeats);



        scrollPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane1.setContent(tableView1);
        scene4 = new Scene(scrollPane1, 3000, 1000);
        noOfWinsSortedClubs.clear();

        return scene4;
    }
    public Scene SceneFive() {
        if(footballClubList.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Please Enter some football clubs before Playing a match");
            alert.showAndWait();

        }
        else{

            Random rand = new Random();
            int randomDay=rand.nextInt(32);
            int randomMonth=rand.nextInt(13);
            int randomYear=rand.nextInt(20)+2020;
            String matchDate= String.format("%02d",randomDay) +"/"+String.format("%02d",randomMonth) +"/"+ randomYear;;
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate=LocalDate.parse(matchDate,dateTimeFormatter);


            int randIndex1 = rand.nextInt(footballClubList.size());
            String firstClub =(footballClubList.get(randIndex1).getClubName());

            String result;
            String secondClub;
            int goalDiff;


            int randIndex2;
            while(true){
                randIndex2 = rand.nextInt(footballClubList.size());
                if(randIndex1==randIndex2){
                    continue;
                }
                else{
                    secondClub =(footballClubList.get(randIndex2).getClubName());
                    break;
                }
            }
            System.out.println();
            System.out.println("////// A Match has been Played between "+firstClub+" and "+secondClub+"//////");
            int firstClubGoals = rand.nextInt(20);
            System.out.println("The First club "+firstClub+" has scored "+firstClubGoals+" goals ");
            int secondClubGoals = rand.nextInt(20);
            System.out.println("The Second club "+secondClub+" has scored "+secondClubGoals+" goals ");

            footballClubList.get(randIndex1).setGoalsScored(footballClubList.get(randIndex1).getGoalsScored()+firstClubGoals);

            footballClubList.get(randIndex2).setGoalsScored(footballClubList.get(randIndex2).getGoalsScored()+secondClubGoals);

            footballClubList.get(randIndex1).setNoOfMatchesPlayed(footballClubList.get(randIndex1).getNoOfMatchesPlayed()+1);

           footballClubList.get(randIndex2).setNoOfMatchesPlayed(footballClubList.get(randIndex2).getNoOfMatchesPlayed()+1);



            if(firstClubGoals==secondClubGoals) {
                footballClubList.get(randIndex1).setNoOfDraws(footballClubList.get(randIndex1).getNoOfDraws()+1);
                footballClubList.get(randIndex2).setNoOfDraws(footballClubList.get(randIndex2).getNoOfDraws()+1);
                System.out.println("The Match Played between "+firstClub+" and "+secondClub+" is a draw.");
                result="The match is a Draw";

            }
            else if (firstClubGoals>secondClubGoals){
                footballClubList.get(randIndex1).setNoOfWins(footballClubList.get(randIndex1).getNoOfWins()+1);

                footballClubList.get(randIndex2).setDefeats(footballClubList.get(randIndex2).getDefeats()+1);

                footballClubList.get(randIndex1).setGoalsReceived(footballClubList.get(randIndex1).getGoalsReceived()+secondClubGoals);

              /*  footballClubList.get(randIndex1).setGoalDifference(footballClubs.get(randIndex1).getGoalDifference()+goalDiff);

                footballClubList.get(randIndex2).setGoalDifference((footballClubs.get(randIndex2).getGoalDifference()+goalDiff));
                System.out.println("The Club "+firstClub+" has won the match with a lead of "+goalDiff+" Goals.");
                result=firstClub+"  Won the match";
              */
            }
            else{
                footballClubList.get(randIndex2).setNoOfWins(footballClubList.get(randIndex2).getNoOfWins()+1);
                footballClubList.get(randIndex1).setDefeats(footballClubList.get(randIndex1).getDefeats()+1);
                footballClubList.get(randIndex2).setGoalsReceived(footballClubList.get(randIndex2).getGoalsReceived()+firstClubGoals);
                goalDiff=secondClubGoals-firstClubGoals;
                /*footballClubList.get(randIndex2).setGoalDifference(footballClubs.get(randIndex2).getGoalDifference()+goalDiff);
                System.out.println("The Club "+secondClub+" has won the match with a lead of "+goalDiff+" Goals.");
                result=secondClub+"  Won the match";*/
                System.out.println();
            }

        }
        ScrollPane scrollPane2 = new ScrollPane();

        TableColumn<FootballClub,String > clubName = new TableColumn<>("Club Name");
        clubName.setMinWidth(200);
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub,String >clubLocation = new TableColumn<>("Club Location");
        clubLocation.setMinWidth(200);
        clubLocation.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));

        TableColumn<FootballClub,String >clubType = new TableColumn<>("Club Type");
        clubType.setMinWidth(200);
        clubType.setCellValueFactory(new PropertyValueFactory<>("clubType"));

        TableColumn<FootballClub,Integer > numberOfGoals = new TableColumn<>("Number of Goals");
        numberOfGoals.setMinWidth(200);
        numberOfGoals.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

        TableColumn<FootballClub,Integer > goalsReceived= new TableColumn<>("Goals Received");
        goalsReceived.setMinWidth(200);
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        TableColumn<FootballClub,Integer >  goalDifference = new TableColumn<>("Goal Difference");
        goalDifference.setMinWidth(200);
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));

        TableColumn<FootballClub,Integer >  totPoints = new TableColumn<>("Total Points");
        totPoints.setMinWidth(200);
        totPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<FootballClub,Integer >  matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setMinWidth(200);
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FootballClub,Integer >  numberOfWins = new TableColumn<>("Number of Wins");
        numberOfWins.setMinWidth(200);
        numberOfWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));

        TableColumn<FootballClub,Integer >  numberOfDraws = new TableColumn<>("Number Of Draws");
        numberOfDraws.setMinWidth(200);
        numberOfDraws.setCellValueFactory(new PropertyValueFactory<>("numberOfDraws"));

        TableColumn<FootballClub,Integer >  numberOfDefeats = new TableColumn<>("Number Of Defeats");
        numberOfDefeats.setMinWidth(200);
        numberOfDefeats.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeats"));

        TableView<FootballClub> tableView2=new TableView<>();
        tableView2.setItems(getPremierLeagueData());
        tableView2.getColumns().addAll(clubName,clubLocation,clubType,numberOfGoals,goalsReceived,goalDifference,totPoints,matchesPlayed,numberOfWins,numberOfDraws,numberOfDefeats);


        scrollPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane2.setContent(tableView2);
        scene5 = new Scene(scrollPane2, 3000, 1000);
        return scene5;
    }


    public ObservableList<FootballClub> getPointsData(){
        ObservableList<FootballClub>pointsData= FXCollections.observableArrayList();
        pointsData.addAll(pointsSortedClubs);
        return pointsData;
    }

    public ObservableList<FootballClub> getGoalsScoreData(){
        ObservableList<FootballClub>gsData=FXCollections.observableArrayList();
        gsData.addAll(goalScoredSortedClubs);
        return gsData;
    }

    public ObservableList<FootballClub> getNoOfWinsData(){
        ObservableList<FootballClub>nwData=FXCollections.observableArrayList();
        nwData.addAll(noOfWinsSortedClubs);
        return nwData;
    }

    public ObservableList<FootballClub> getPremierLeagueData(){
        ObservableList<FootballClub>pLData=FXCollections.observableArrayList();
        pLData.addAll(footballClubList);
        return pLData;
    }

    public ObservableList<PlayedMatch> getPlayedMatchData(){
        ObservableList<PlayedMatch>pLmData=FXCollections.observableArrayList();
        pLmData.addAll(playedMatchList);
        return pLmData;
    }





}