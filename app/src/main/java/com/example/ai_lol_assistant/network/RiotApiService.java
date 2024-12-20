package com.example.ai_lol_assistant.network;

import com.example.ai_lol_assistant.model.AccountDto;
import com.example.ai_lol_assistant.model.MatchDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RiotApiService {

    @GET("riot/account/v1/accounts/by-riot-id/{userName}/{tagLine}")
    Call<AccountDto> getAccountByRiotId(
            @Path("userName") String userName,
            @Path("tagLine") String tagLine
    );

    @GET("lol/match/v5/matches/by-puuid/{puuid}/ids")
    Call<List<String>> getMatchIds(
            @Path("puuid") String puuid,
            @Query("start") int start,
            @Query("count") int count
    );

    @GET("lol/match/v5/matches/{matchId}")
    Call<MatchDto> getMatchById(
            @Path("matchId") String matchId
    );
}
