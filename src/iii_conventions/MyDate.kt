package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        when {
            year - other.year != 0 -> return year - other.year
            month - other.month != 0 -> return month - other.month
            else -> return dayOfMonth - other.dayOfMonth;
        }
    }
}
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterator<MyDate> {
    val current = start
    override fun hasNext(): Boolean {
        return current.nextDay() <= endInclusive
    }

    override fun next(): MyDate {
        return current.nextDay()
    }
}
