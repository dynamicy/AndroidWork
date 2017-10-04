package work.example.chris.jsondealer.model;

import android.database.Cursor;

import work.example.chris.jsondealer.common.BillContract;

public class BillRecord extends BillModel {

    private int id;

    public BillRecord(int id, String cdate, String name, int price) {
        this.id = id;
        this.setCdate(cdate);
        this.setName(name);
        this.setPrice(price);
    }

    public BillRecord(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(BillContract.ID));
        this.setCdate(cursor.getString(cursor.getColumnIndex(BillContract.DATE)));
        this.setName(cursor.getString(cursor.getColumnIndex(BillContract.NAME)));
        this.setPrice(cursor.getInt(cursor.getColumnIndex(BillContract.PRICE)));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
