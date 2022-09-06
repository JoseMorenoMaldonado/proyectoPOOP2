/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Usurario
 */
public class Jugador implements Serializable{
    String roundID;
    String matchID;
    String teamInitials;
    String coachName;
    String lineup;
    String shirtNumber;
    String playerName;

    public Jugador(String roundID, String matchID, String teamInitials, String coachName, String lineup, String shirtNumber, String playerName) {
        this.roundID = roundID;
        this.matchID = matchID;
        this.teamInitials = teamInitials;
        this.coachName = coachName;
        this.lineup = lineup;
        this.shirtNumber = shirtNumber;
        this.playerName = playerName;
    }

    public String getRoundID() {
        return roundID;
    }

    public void setRoundID(String roundID) {
        this.roundID = roundID;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getTeamInitials() {
        return teamInitials;
    }

    public void setTeamInitials(String teamInitials) {
        this.teamInitials = teamInitials;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getLineup() {
        return lineup;
    }

    public void setLineup(String lineup) {
        this.lineup = lineup;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    

}