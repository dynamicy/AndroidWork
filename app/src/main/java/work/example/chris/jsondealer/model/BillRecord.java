package work.example.chris.jsondealer.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import work.example.chris.jsondealer.common.BillContract;

public class BillRecord extends BillModel implements Parcelable {

    private int id;

    public BillRecord(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(BillContract.ID));
        this.setCdate(cursor.getString(cursor.getColumnIndex(BillContract.DATE)));
        this.setName(cursor.getString(cursor.getColumnIndex(BillContract.NAME)));
        this.setPrice(cursor.getInt(cursor.getColumnIndex(BillContract.PRICE)));
    }

    protected BillRecord(Parcel in) {
        id = in.readInt();
        setCdate(in.readString());
        setName(in.readString());
        setPrice(in.readInt());
    }

    public static final Creator<BillRecord> CREATOR = new Creator<BillRecord>() {
        @Override
        public BillRecord createFromParcel(Parcel in) {
            return new BillRecord(in);
        }

        @Override
        public BillRecord[] newArray(int size) {
            return new BillRecord[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(getCdate());
        parcel.writeString(getName());
        parcel.writeInt(getPrice());
    }
}
