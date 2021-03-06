package eduardo6903.ezbud.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import eduardo6903.ezbud.entities.Transactions;

/**
 * Helper class where we will write all operations related to the database
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //create database constants
    private static final String DATABASE_NAME = "ezbud.db";
    private static final Integer DATABASE_VERSION = 1;

    // create table constants
    private static final String TABLE1_NAME = "user";
    private static final String TABLE2_NAME = "transactions";

    //create constants for the USER table's column name
    private static final String T1_COL_ID = "ID";
    private static final String T1_COL_NAME = "NAME";
    private static final String T1_COL_BALANCE = "BALANCE";
    private static final String T1_COL_INCOME = "INCOME";
    private static final String T1_COL_DATE_INCOME = "DATE_INCOME";


    //create constants for the TRANSACTIONS table's column name
    private static final String T2_COL_ID = "ID";
    private static final String T2_COL_TYPE = "TYPE";
    private static final String T2_COL_DESCRIPTION = "DESCRIPTION";
    private static final String T2_COL_AMOUNT = "AMOUNT";
    private static final String T2_COL_DATE = "DATE";
    private static final String T2_COL_USER = "USER";


    //create sql statements
    private static final String CREATE_TABLE_TB1 = "CREATE TABLE " + TABLE1_NAME + "(" + T1_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            T1_COL_NAME + " TEXT, " +
            T1_COL_BALANCE + " REAL, " +
            T1_COL_INCOME + " REAL, " +
            T1_COL_DATE_INCOME + " TEXT )";

    private static final String CREATE_TABLE_TB2 = "CREATE TABLE " + TABLE2_NAME + "(" + T2_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            T2_COL_TYPE + " TEXT, " +
            T2_COL_DESCRIPTION + " TEXT, " +
            T2_COL_AMOUNT + " REAL, " +
            T2_COL_DATE + " TEXT, " +
            T2_COL_USER + " INTEGER )";

    private static final String DROP_TABLE_TB1 = "DROP TABLE IF EXISTS " + TABLE1_NAME;
    private static final String DROP_TABLE_TB2 = "DROP TABLE IF EXISTS " + TABLE2_NAME;

    private static final String GET_ALL_TB1 = "SELECT * FROM " + TABLE1_NAME;
    private static final String GET_ALL_TB2 = "SELECT * FROM " + TABLE2_NAME;

    /**
     * create the database every time this constructor gets called.
     *
     * @param context provides access to the Activity resources
     */
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //this method gets executed every time getWritableDatabase or getReadableDatabase is called.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TB1);
        sqLiteDatabase.execSQL(CREATE_TABLE_TB2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DROP_TABLE_TB1);
        sqLiteDatabase.execSQL(DROP_TABLE_TB2);
        onCreate(sqLiteDatabase);
    }

    // ___________________ USER TABLE _______________________________________________________________________________________________________________________________


    /**
     * Add a user to the database
     * @param name          Users's name
     * @param balance       User's balance
     * @param income        Users's income
     * @param dateIncome    User's date of income
     * @return      if it succeeded, the autogenerated id (primary key) of the recently added user
     *              otherwise -1
     */
    public Long insertUser(String name, Double balance, Double income, String dateIncome) {
        //create an instance of SQLITE database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_NAME, name);
        contentValues.put(T1_COL_BALANCE, balance);
        contentValues.put(T1_COL_INCOME, income);
        contentValues.put(T1_COL_DATE_INCOME, dateIncome);
        long result = db.insert(TABLE1_NAME, null, contentValues);

        return result;
    }

    /**
     * @return  A cursor of all monsters in the table called monster.
     */
    public Cursor getUser() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery(GET_ALL_TB1, null);
    }

    /**
     * Update user record in the database
     * @param id            Primary key of the user
     * @param name          Users's name
     * @param balance       User's balance
     * @param income        Users's income
     * @param dateIncome    User's date of income
     * @return      true is the user record in the database was updated, otherwise false.
     */
    public boolean updateUser(Integer id, String name, Double balance, Double income, String dateIncome) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_ID, id);
        contentValues.put(T1_COL_NAME, name);
        contentValues.put(T1_COL_BALANCE, balance);
        contentValues.put(T1_COL_INCOME, income);
        contentValues.put(T1_COL_DATE_INCOME, dateIncome);

        int numRowsUpdated = db.update(TABLE1_NAME, contentValues, "ID = ?", new String[]{id.toString()});

        return numRowsUpdated != 1;
    }

    /**
     * Delete user from the database
     * @param id    Monster's primary key
     * @return      true if the monster was deleted, otherwise false
     */
    public boolean deleteUser(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int numOfAffectedRows = db.delete(TABLE1_NAME, "ID = ?", new String[]{id.toString()});
        return numOfAffectedRows != -1;
    }


    // ______________________  TRANSACTIONS TABLE ______________________________________________________________________________________________________________________________
    /**
     * Add a transaction to the database
     * @param type          Transaction's name
     * @param description   Transaction's description
     * @param amount        Transaction's amount
     * @param date          Transaction's date
     * @param user          Transaction's user
     * @return      if it succeeded, the autogenerated id (primary key) of the recently added transaction
     *              otherwise -1
     */
    public Long insertTa(String type, String description, Double amount, String date, Integer user) {
        //create an instance of SQLITE database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL_TYPE, type);
        contentValues.put(T2_COL_DESCRIPTION, description);
        contentValues.put(T2_COL_AMOUNT, amount);
        contentValues.put(T2_COL_DATE, date);
        contentValues.put(T2_COL_USER, user);

        long result = db.insert(TABLE2_NAME, null, contentValues);

        return result;
    }

    /**
     * @return  A cursor of all transactions in the table called transactions.
     */
    public Cursor getAllTa() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery(GET_ALL_TB2, null);
    }

    /**
     * @return  A cursor of all transactions in the table called transactions with specific date.
     */
    public Cursor getAllTaByDate(String dateDef) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT * FROM " + TABLE2_NAME + " WHERE " + T2_COL_DATE + " = " + dateDef, null);
    }

    /**
     * Update a transaction to the database
     * @param type          Transaction's name
     * @param description   Transaction's description
     * @param amount        Transaction's amount
     * @param date          Transaction's date
     * @param user          Transaction's user
     * @return      true is the monster record in the database was updated, otherwise false.
     */
    public boolean updateTa(Integer id, String type, String description, Double amount, String date, Integer user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL_TYPE, type);
        contentValues.put(T2_COL_DESCRIPTION, description);
        contentValues.put(T2_COL_AMOUNT, amount);
        contentValues.put(T2_COL_DATE, date);
        contentValues.put(T2_COL_USER, user);

        int numRowsUpdated = db.update(TABLE2_NAME, contentValues, "ID = ?", new String[]{id.toString()});

        return numRowsUpdated != 1;
    }

    /**
     * Delete a transaction from the database
     * @param id    Transaction's primary key
     * @return      true if the transaction was deleted, otherwise false
     */
    public boolean deleteTa(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int numOfAffectedRows = db.delete(TABLE2_NAME, "ID = ?", new String[]{id.toString()});
        return numOfAffectedRows != -1;
    }


    /**
     * @return a list of all transactions from the database table called transactions
     */
    public List<Transactions> getTa(){
        List<Transactions> transactions = new ArrayList<>();
        Cursor cursor = getAllTa();

        if(cursor.getCount() > 0){

            Transactions ta;

            while (cursor.moveToNext()) {
                Integer id = cursor.getInt(0);
                String type = cursor.getString(1);
                String description = cursor.getString(2);
                Double amount = cursor.getDouble(3);
                String date = cursor.getString(4);
                Integer user = cursor.getInt(5);

                ta = new Transactions(id, type, description, amount,date, user);
                transactions.add(ta);
            }
        }
        cursor.close();
        return transactions;

    }


    /**
     * @return a list of all transactions from the database table called transactions
     */
    public List<Transactions> getTaByDate(String dateDef){
        List<Transactions> transactions = new ArrayList<>();
        Cursor cursor = getAllTaByDate(dateDef);

        if(cursor.getCount() > 0){

            Transactions ta;

            while (cursor.moveToNext()) {
                Integer id = cursor.getInt(0);
                String type = cursor.getString(1);
                String description = cursor.getString(2);
                Double amount = cursor.getDouble(3);
                String date = cursor.getString(4);
                Integer user = cursor.getInt(5);

                ta = new Transactions(id, type, description, amount,date, user);
                transactions.add(ta);
            }
        }
        cursor.close();
        return transactions;

    }

}

