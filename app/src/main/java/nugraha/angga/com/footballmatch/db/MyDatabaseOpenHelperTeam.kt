package nugraha.angga.com.footballmatch.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelperTeam(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteMyTeam.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelperTeam? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelperTeam {
            if (instance == null) {
                instance = MyDatabaseOpenHelperTeam(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelperTeam
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(TeamFavorite.TABLE_FAVORITE, true,
                TeamFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                TeamFavorite.ID_TEAM to TEXT + UNIQUE,
                TeamFavorite.STR_TEAM to TEXT,
                TeamFavorite.STR_TEAM_BADGE to TEXT,
                TeamFavorite.INT_FORMED_YEAR to TEXT,
                TeamFavorite.STR_STADIUM to TEXT,
                TeamFavorite.STR_DESCRIPTION_EN to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(TeamFavorite.TABLE_FAVORITE, true)
    }
}

val Context.databaseTeam: MyDatabaseOpenHelperTeam
    get() = MyDatabaseOpenHelperTeam.getInstance(applicationContext)