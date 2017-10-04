package work.example.chris.jsondealer.common;

import work.example.chris.jsondealer.R;

public class BillContract {

    /**
     * Resources
     */
    public final static int BillResource = R.raw.bill;

    public final static String AssetsName = "billassets.json";

    /**
     * DB commons
     */
    public final static String DBName = "bill.db";

    public final static String TableName = "bill";

    /**
     * DB fields
     */
    public final static String ID = "_id";
    public final static String DATE = "cdate";
    public final static String NAME = "name";
    public final static String PRICE = "price";

    /**
     * SQL sentence
     */
    public final static String crateTable = "create table bill (_id integer primary key, "
                                            + "cdate datetime, name varchar, price integer)";

}
