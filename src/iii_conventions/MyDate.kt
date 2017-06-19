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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterator<MyDate> {
    var current = start
    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
}

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this,number)
operator fun MyDate.plus(timeInterval: RepeatedTimeInterval) = addTimeIntervals(timeInterval.timeInterval,timeInterval.number)
