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

    public void AddShotPut (double pitch) { this._pitches.add(pitch); }

    public Double GetBiggestPitch () {
        double biggestPitch = Collections.max(this._pitches);
        return biggestPitch;
        //return String.format("Maximum range of pitches: ", Collections.max(this._pitches));
    }
}