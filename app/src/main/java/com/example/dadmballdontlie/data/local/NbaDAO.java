package com.example.dadmballdontlie.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dadmballdontlie.data.model.Player;
import com.example.dadmballdontlie.data.model.Team;

import java.util.List;

@Dao
public abstract class NbaDAO {

    @Insert
    public abstract void insertPlayer(Player player);

    @Update
    public abstract void updatePlayer(Player player);

    @Insert
    public abstract void insertTeam(Team team);

    @Update
    public abstract void updateTeam(Team team);

    @Delete
    public abstract void deletePlayer(Player player);

    @Delete
    public abstract void deleteTeam(Team team);


    @Query("select * from player")
    public abstract LiveData<List<Player>> getPlayers();

    @Query("select * from team")
    public abstract LiveData<List<Team>> getTeams();

    @Query("select * from player where favourite = 1")
    public abstract LiveData<List<Player>> getAllFavsPlayers();

    @Query("select * from team where favourite = 1")
    public abstract LiveData<List<Team>> getAllFavsTeams();

    @Query("delete from player")
    public abstract void deletePlayers();

    @Query("delete from team")
    public abstract void deleteTeams();

    @Query("select * from player where id = :idPlayer")
    public abstract LiveData<Player> getPlayer(Integer idPlayer);

    @Query("select * from team where id = :idTeam")
    public abstract LiveData<Team> getTeam(Integer idTeam);

}
