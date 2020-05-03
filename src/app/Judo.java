package app;

public class Judo {
    // counter points per attack
    private int _yuko; // more points wins
    private int _wazari; // more points wins, independent of Yuko points
    private int _ippon; // wins!

    private String _athleteNumber;

    public void set_athleteNumber(String athleteNumber) { this._athleteNumber = athleteNumber; }
    public String get_athleteNUmber() { return _athleteNumber; }

    public void set_ippon() { this._ippon++; }        

    public void set_wazari() { this._wazari++; }

    public void set_yuko() { this._yuko++; }

    public String Attacks() {
        return get_athleteNUmber() + " Yukô: " + this._yuko + " Warazi: " + this._wazari + " Ippons: " + this._ippon;
    }
}