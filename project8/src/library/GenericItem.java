package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class GenericItem implements Item
{
    /**
     * Title of this item.
     */
    private String title;

    /**
     * Due date for this item.  This value is null when not checked out.
     */
    private Date dueDate;

    /**
     * Patron to whom this item is checked out.  This value is null when not checked out.
     */
    private Patron checkedOutTo;

    private int checkOutDays;

    /**
     * Constructs a ReferenceItem with the given title.
     * @param givenTitle
     */
    public GenericItem(String givenTitle, int givenCheckOutDays)
    {
        title = givenTitle;
        checkOutDays = givenCheckOutDays;
        dueDate = null;
        checkedOutTo = null;
    }

    @Override
    public void checkOut(Patron p, Date now)
    {
        if (!isCheckedOut())
        {
            // use a GregorianCalendar to figure out the Date corresponding to
            // midnight, 7 days from now
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(now);
            cal.add(Calendar.DAY_OF_YEAR, checkOutDays);

            // always set to 11:59:59 pm on the day it's due
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);

            // convert back to Date object
            dueDate = cal.getTime();

            checkedOutTo = p;
        }
    }

    @Override
    public void checkIn()
    {
        if (isCheckedOut())
        {
            checkedOutTo = null;
            dueDate = null;
        }
    }

    @Override
    public void renew(Date now)
    {
        // can't be checked out
    }

    @Override
    public double getFine(Date now)
    {
        return 0;
    }

    @Override
    public boolean isOverdue(Date now)
    {
        if (!isCheckedOut())
        {
            return false;
        }
        return now.after(dueDate);
    }

    @Override
    public int compareTo(Item other)
    {
        return title.compareTo(other.getTitle());
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public boolean isCheckedOut()
    {
        return dueDate != null;
    }

    @Override
    public Date getDueDate()
    {
        return dueDate;
    }

    @Override
    public Patron getPatron()
    {
        return checkedOutTo;
    }

}


