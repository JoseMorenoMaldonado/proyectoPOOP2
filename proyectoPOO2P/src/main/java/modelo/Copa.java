/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usurario
 */
public class Copa {
    int year;
    String country;
    String winner;
    String runnersUp;
    String third;
    String fourth;
    int goalsScored;
    int qualifiedTeams;
    int matchesPlayed;
    String attendance;

    public Copa(int year, String country, String winner, String runnersUp, String third, String fourth, int goalsScored, int qualifiedTeams, int matchesPlayed, String attendance) {
        this.year = year;
        this.country = country;
        this.winner = winner;
        this.runnersUp = runnersUp;
        this.third = third;
        this.fourth = fourth;
        this.goalsScored = goalsScored;
        this.qualifiedTeams = qualifiedTeams;
        this.matchesPlayed = matchesPlayed;
        this.attendance = attendance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnersUp() {
        return runnersUp;
    }

    public void setRunnersUp(String runnersUp) {
        this.runnersUp = runnersUp;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getQualifiedTeams() {
        return qualifiedTeams;
    }

    public void setQualifiedTeams(int qualifiedTeams) {
        this.qualifiedTeams = qualifiedTeams;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    
}
