package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtisticGymnastics {
    private List<Double> _grades = new ArrayList<Double>(5);
    
    private double _finalSumGrades;

    public void AddGrade(Double grade) { this._grades.add(grade); }

    public double Get_finalSumGrades () { return _finalSumGrades; }

    public String FinalSumGrades() {
        double sumGrades = 0;
        for (int counter = 0; counter < this._grades.size(); counter++)
            sumGrades += this._grades.get(counter);
        
        double minimunValue = Collections.min(this._grades);
        _finalSumGrades = sumGrades - minimunValue;
        return String.format("Final sum: %f", _finalSumGrades);
    }
}