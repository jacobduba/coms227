package lab1;

import javax.swing.SwingUtilities;

import speccheck.SpecCheck;

public class Runner
{
    public static void main(String args[])
    {
        {
// GUI dialogs are used, so we need to run on the event thread.
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    SpecCheck.testAndZip(
                            example.SpecChecker.class,
                            "SUBMIT_THIS_lab1",
                            "lab1",
                            new String[]{"src/lab1/Greeter.java"});
                }
            });
        }
    }
}