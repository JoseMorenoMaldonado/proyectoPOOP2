/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usurario
 */
public class Partido {
    int Year;
    String Datetime;
    String Stage;
    String Stadium;
    String City;
    String HomeTeamName;
    int HomeTeamGoals;
    int AwayTeamGoals;
    String AwayTeamName;
    boolean WinConditions;
    int Attendance;
    int HalfTimeHomeGoals;
    int HalfTimeAwayGoals;
    String Referee;
    String Assistant1;
    String Assistant2;
    String RoundID;
    String MatchID;
    String HomeTeamInitials;
    String AwayTeamInitials;

    public Partido(int Year, String Datetime, String Stage, String Stadium, String City, String HomeTeamName, int HomeTeamGoals, int AwayTeamGoals, String AwayTeamName, boolean WinConditions, int Attendance, int HalfTimeHomeGoals, int HalfTimeAwayGoals, String Referee, String Assistant1, String Assistant2, String RoundID, String MatchID, String HomeTeamInitials, String AwayTeamInitials) {
        this.Year = Year;
        this.Datetime = Datetime;
        this.Stage = Stage;
        this.Stadium = Stadium;
        this.City = City;
        this.HomeTeamName = HomeTeamName;
        this.HomeTeamGoals = HomeTeamGoals;
        this.AwayTeamGoals = AwayTeamGoals;
        this.AwayTeamName = AwayTeamName;
        this.WinConditions = WinConditions;
        this.Attendance = Attendance;
        this.HalfTimeHomeGoals = HalfTimeHomeGoals;
        this.HalfTimeAwayGoals = HalfTimeAwayGoals;
        this.Referee = Referee;
        this.Assistant1 = Assistant1;
        this.Assistant2 = Assistant2;
        this.RoundID = RoundID;
        this.MatchID = MatchID;
        this.HomeTeamInitials = HomeTeamInitials;
        this.AwayTeamInitials = AwayTeamInitials;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String Datetime) {
        this.Datetime = Datetime;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String Stage) {
        this.Stage = Stage;
    }

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String Stadium) {
        this.Stadium = Stadium;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String HomeTeamName) {
        this.HomeTeamName = HomeTeamName;
    }

    public int getHomeTeamGoals() {
        return HomeTeamGoals;
    }

    public void setHomeTeamGoals(int HomeTeamGoals) {
        this.HomeTeamGoals = HomeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return AwayTeamGoals;
    }

    public void setAwayTeamGoals(int AwayTeamGoals) {
        this.AwayTeamGoals = AwayTeamGoals;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String AwayTeamName) {
        this.AwayTeamName = AwayTeamName;
    }

    public boolean isWinConditions() {
        return WinConditions;
    }

    public void setWinConditions(boolean WinConditions) {
        this.WinConditions = WinConditions;
    }

    public int getAttendance() {
        return Attendance;
    }

    public void setAttendance(int Attendance) {
        this.Attendance = Attendance;
    }

    public int getHalfTimeHomeGoals() {
        return HalfTimeHomeGoals;
    }

    public void setHalfTimeHomeGoals(int HalfTimeHomeGoals) {
        this.HalfTimeHomeGoals = HalfTimeHomeGoals;
    }

    public int getHalfTimeAwayGoals() {
        return HalfTimeAwayGoals;
    }

    public void setHalfTimeAwayGoals(int HalfTimeAwayGoals) {
        this.HalfTimeAwayGoals = HalfTimeAwayGoals;
    }

    public String getReferee() {
        return Referee;
    }

    public void setReferee(String Referee) {
        this.Referee = Referee;
    }

    public String getAssistant1() {
        return Assistant1;
    }

    public void setAssistant1(String Assistant1) {
        this.Assistant1 = Assistant1;
    }

    public String getAssistant2() {
        return Assistant2;
    }

    public void setAssistant2(String Assistant2) {
        this.Assistant2 = Assistant2;
    }

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String RoundID) {
        this.RoundID = RoundID;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String MatchID) {
        this.MatchID = MatchID;
    }

    public String getHomeTeamInitials() {
        return HomeTeamInitials;
    }

    public void setHomeTeamInitials(String HomeTeamInitials) {
        this.HomeTeamInitials = HomeTeamInitials;
    }

    public String getAwayTeamInitials() {
        return AwayTeamInitials;
    }

    public void setAwayTeamInitials(String AwayTeamInitials) {
        this.AwayTeamInitials = AwayTeamInitials;
    }
    
}
