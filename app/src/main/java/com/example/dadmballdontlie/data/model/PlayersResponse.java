package com.example.dadmballdontlie.data.model;

import java.util.ArrayList;
import java.util.List;

public class PlayersResponse {
    private List<Player> data;
    private Meta meta;

    public PlayersResponse(List<Player> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> players) {
        this.data = players;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
