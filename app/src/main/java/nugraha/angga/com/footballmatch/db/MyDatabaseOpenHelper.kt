package nugraha.angga.com.footballmatch.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(Favorite.TABLE_FAVORITE, true,
                Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Favorite.ID_EVENT to TEXT + UNIQUE,
                Favorite.HOME_TEAM_NAME to TEXT,
                Favorite.AWAY_TEAM_NAME to TEXT,
                Favorite.HOME_TEAM_SCORE to TEXT,
                Favorite.AWAY_TEAM_SCORE to TEXT,
                Favorite.HOME_GOAL_DETAIL to TEXT,
                Favorite.AWAY_GOAL_DETAIL to TEXT,
                Favorite.HOME_SHOTS to TEXT,
                Favorite.AWAY_SHOTS to TEXT,
                Favorite.HOME_LINEUP_GOALKEEPER to TEXT,
                Favorite.AWAY_LINEUP_GOALKEEPER to TEXT,
                Favorite.HOME_LINEUP_DEFENSE to TEXT,
                Favorite.AWAY_LINEUP_DEFENSE to TEXT,
                Favorite.HOME_LINEUP_MIDFIELD to TEXT,
                Favorite.AWAY_LINEUP_MIDFIELD to TEXT,
                Favorite.HOME_LINEUP_FORWARD to TEXT,
                Favorite.AWAY_LINEUP_FORWARD to TEXT,
                Favorite.HOME_LINEUP_SUBTITUTES to TEXT,
                Favorite.AWAY_LINEUP_SUBTITUTES to TEXT,
                Favorite.STR_DATE to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Favorite.TABLE_FAVORITE, true)
    }
}

val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)