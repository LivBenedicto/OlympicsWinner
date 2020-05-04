package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShotPut {
    /*
    * atleta possui três arremessos A posição na classificação é determinada pela
    * distância obtida no maior arremesso válido caso de empate, vale a segunda
    * maior marca do atleta
    */

    private List<Double> _pitches = new ArrayList<Double>(3);
    private String _athleteNumber;

    public void set_athleteNumber(String athleteNumber) { this._athleteNumber = athleteNumber; }
    public String get_athleteNUmber() { return _athleteNumber; }
    
    public void AddShotPut (double pitch) { this._pitches.add(pitch); }

    public List<Double> GetPitches () {
        Collections.sort(this._pitches);
        return this._pitches;
    }
}