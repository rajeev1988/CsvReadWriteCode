import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

public class CsvWriterAppendExample
{
	public static String[] ss = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	public static void main(String[] args)
	{

		// Declare Csv file directory path
		String outputFile = "/home/rajeev/users.csv";

		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();

		try
		{
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("Year");
				csvOutput.write("Month");
				csvOutput.write("Company A");
				csvOutput.write("Company B");
				csvOutput.write("Company C");
				csvOutput.write("Company D");
				csvOutput.write("Company E");
				csvOutput.write("Company F");
				csvOutput.write("Company G");
				csvOutput.write("Company H");

				csvOutput.endRecord();
			}

			// write out a few records
			for (int i = 1; i <= 10; i++)
			{
				setDataInCSVFile(csvOutput, i);
			}

			csvOutput.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void setDataInCSVFile(CsvWriter csvOutput, int i)
	{
		try
		{
			csvOutput.write("" + (1998 + i));
			csvOutput.write(ss[i - 1]);
			csvOutput.write("" + (2 * i));
			csvOutput.write("" + (3 * i));
			csvOutput.write("" + (4 * i));
			csvOutput.write("" + (5 * i));
			csvOutput.write("" + (6 * i));
			csvOutput.write("" + (7 * i));
			csvOutput.write("" + (8 * i));
			csvOutput.write("" + (9 * i));
			csvOutput.endRecord();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}