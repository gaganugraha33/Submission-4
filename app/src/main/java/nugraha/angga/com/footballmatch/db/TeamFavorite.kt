package nugraha.angga.com.footballmatch.db

data class TeamFavorite(val id: Long?, val idTeam: String?, val strTeam: String?,
                        val strTeamBadge: String?, val intFormedYear: String?,
                        val strStadium: String?, val strDescriptionEN: String?) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val ID_TEAM: String = "ID_TEAM"
        const val STR_TEAM: String = "STR_TEAM"
        const val STR_TEAM_BADGE: String = "STR_TEAM_BADGE"
        const val INT_FORMED_YEAR: String = "INT_FORMED_YEAR"
        const val STR_STADIUM: String = "STR_STADIUM"
        const val STR_DESCRIPTION_EN: String = "STR_DESCRIPTION_EN"

    }
}