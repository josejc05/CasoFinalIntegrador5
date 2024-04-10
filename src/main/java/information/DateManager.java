package information;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateManager {
    private List<LocalDate> dates;

    public DateManager() {
        this.dates = new ArrayList<>();
    }

    public void addDate(LocalDate date) {
        this.dates.add(date);
        Collections.sort(this.dates);
    }

    public List<LocalDate> getDates() {
        return this.dates;
    }
}