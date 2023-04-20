package Salery;

public class SalariesStatistics {

    public static final int NOT_FOUND = -1;
    public static final int MONTH_IN_Y = 12;

    int[][] _salaries;
    String[] _names;
    int _nOfWorkers;

    public SalariesStatistics(int[][] salaries, String[] names) {
        _nOfWorkers = salaries.length;
        _salaries = new int[_nOfWorkers][MONTH_IN_Y];

        for (int i = 0; i < _nOfWorkers; i++) {
            for (int j = 0; j < MONTH_IN_Y; j++) {
                _salaries[i][j] = salaries[i][j];
            }
        }

        _names = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            _names[i] = names[i];
        }

    }

    public int bestSalary(String name) {
        int worker = FindWorker(name);

        if (worker == NOT_FOUND)
            return NOT_FOUND;

        int bestSalary = _salaries[worker][0];
        for (int i = 1; i < MONTH_IN_Y; i++) {
            if (bestSalary < _salaries[worker][i]) {
                bestSalary = _salaries[worker][i];
            }
        }

        return bestSalary;
    }

    public String maxInMonth(int month) {
        month -= 1;
        if (month > MONTH_IN_Y || month < 0)
            return "not valid";

        int idxMaxS = 0;

        for (int i = 1; i < _nOfWorkers; i++) {
            if ( _salaries[idxMaxS][month] < _salaries[i][month]) {
                idxMaxS = i;
            }
        }
        return _names[idxMaxS];
    }

    public double avrByMonth(int month) {
        month -= 1;
        int sum = 0;
        for (int i = 0; i < _nOfWorkers; i++) {
            sum += _salaries[i][month];
        }

        return (double) sum / _nOfWorkers;
    }

    public int bestMonth() {
        double maxAve = avrByMonth(1);
        double currAve;
        int idxBestMonth = 0;

        for (int i = 2; i <= MONTH_IN_Y; i++) {
            currAve = avrByMonth(i);
            if (maxAve < currAve) {
                maxAve = currAve;
                idxBestMonth = i - 1;
            }
        }

        return idxBestMonth;
    }

    public String bestWorker() {
        int bestSalary = bestSalary(_names[0]);
        String bestWorker = _names[0];

        for (int i = 1; i < _nOfWorkers; i++) {
            if (bestSalary < bestSalary(_names[i])) {
                bestSalary = bestSalary(_names[i]);
                bestWorker = _names[i];
            }
        }

        return bestWorker;
    }

    private int FindWorker(String name) {
        for (int i = 0; i < _names.length; i++) {
            if (_names[i].equals(name)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

}
