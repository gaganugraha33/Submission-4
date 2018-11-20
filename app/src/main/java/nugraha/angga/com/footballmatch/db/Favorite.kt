package nugraha.angga.com.footballmatch.db

data class Favorite(val id: Long?, val idEvent: String?, val strHomeTeam: String?, val strAwayTeam: String?,
                    val intHomeScore: String?, val intAwayScore: String?,
                    val strHomeGoalDetails: String?, val strAwayGoalDetails: String?,
                    val intHomeShots: String?, val intAwayShots: String?,
                    val strHomeLineupGoalkeeper: String?, val strAwayLineupGoalkeeper: String?,
                    val strHomeLineupDefense: String?, val strAwayLineupDefense: String?,
                    val strHomeLineupMidfield: String?, val strAwayLineupMidfield: String?,
                    val strHomeLineupForward: String?, val strAwayLineupForward: String?,
                    val strHomeLineupSubstitutes: String?, val strAwayLineupSubstitutes: String?,
                    val strDate: String?) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val HOME_TEAM_NAME: String = "HOME_TEAM_NAME"
        const val AWAY_TEAM_NAME: String = "AWAY_TEAM_NAME"
        const val HOME_TEAM_SCORE: String = "HOME_TEAM_SCORE"
        const val AWAY_TEAM_SCORE: String = "AWAY_TEAM_SCORE"
        const val HOME_GOAL_DETAIL: String = "HOME_GOAL_DETAIL"
        const val AWAY_GOAL_DETAIL: String = "AWAY_GOAL_DETAIL"
        const val HOME_SHOTS: String = "HOME_SHOTS"
        const val AWAY_SHOTS: String = "AWAY_SHOTS"
        const val HOME_LINEUP_GOALKEEPER: String = "HOME_LINEUP_GOALKEEPER"
        const val AWAY_LINEUP_GOALKEEPER: String = "AWAY_LINEUP_GOALKEEPER"
        const val HOME_LINEUP_DEFENSE: String = "HOME_LINEUP_DEFENSE"
        const val AWAY_LINEUP_DEFENSE: String = "AWAY_LINEUP_DEFENSE"
        const val HOME_LINEUP_MIDFIELD: String = "HOME_LINEUP_MIDFIELD"
        const val AWAY_LINEUP_MIDFIELD: String = "AWAY_LINEUP_MIDFIELD"
        const val HOME_LINEUP_FORWARD: String = "HOME_LINEUP_FORWARD"
        const val AWAY_LINEUP_FORWARD: String = "AWAY_LINEUP_FORWARD"
        const val HOME_LINEUP_SUBTITUTES: String = "HOME_LINEUP_SUBTITUTES"
        const val AWAY_LINEUP_SUBTITUTES: String = "AWAY_LINEUP_SUBTITUTES"
        const val STR_DATE: String = "STR_DATE"
    }
}