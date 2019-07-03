package avajLauncher.utils;

import java.io.*;
import java.util.*;
import avajLauncher.weather.Flyable;
import avajLauncher.aircraft.AircraftFactory;
import static avajLauncher.utils.CustomeErrors.*;

public class FileReading {

    public List<Flyable> f = new ArrayList<Flyable>();
    public int numOfCycles;

    /**
     * this class reads from an input file (scenario.txt), creates flyable objects and and save on an arrayList
     * @param array
     */
    public void readFromFile(String[] array) {

        try {

            int i = 1;
            noArguments(array);

            File file = new File(array[0]);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            if (file.length() == 0) {
                throw new Exception("Error : \"" + file + "\" is Empty. There is nothing to read");
            }

            String s = br.readLine();

            invalidFirstLine(s, i);

            numOfCycles = Integer.parseInt(s.split(" ")[0]);
            invalidValue(i);
            while ((s = br.readLine()) != null) {

                i = i + 1;
                emptyLine(s, i);
                String[] str = s.split(" ");
                if (str.length != 5)
                    throw new InvalidnumException("Error on Line " + i + ": Number of parameters must be equal to 5");
                doAllChecks(s.split(" ")[0], s.split(" ")[1], s.split(" ")[2], s.split(" ")[3], s.split(" ")[4], i);
                f.add(AircraftFactory.newAircraft(s.split(" ")[0],
                        s.split(" ")[1],
                        Integer.parseInt(s.split(" ")[2]),
                        Integer.parseInt(s.split(" ")[3]),
                        Integer.parseInt(s.split(" ")[4])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(RED + "Error: No such file or directory " + "\"" + array[0] + "\"" + RESET);
            System.exit(1);
        } catch (Exception e) {
            System.out.println(RED + e.getMessage() + RESET);
            System.exit(1);
        }
    }

    private void doAllChecks(String b, String c, String d, String e, String f, int i) throws  InvalidStringException, InvalidIntStringsException, InvalidIntegerException {
        invalidAircraft(b, i);
        invalidStrings(b, i);
        invalidIntStr(c, i);
        invalidIntegers(d, e, f, i);
    }

    private void noArguments(String[] array) throws NoArgsException {
        if(array.length == 0) throw new NoArgsException("Error: \"scenario.txt\" wasn't passed as an argument!!");
    }

    private void invalidFirstLine(String s, int i) throws InvalidnumException {
        if (s.equals("") || !s.matches("^[0-9]*$") || s.length() == 0)
            throw new InvalidnumException("Error on Line " + i + ": Input must be an integer!!");
    }

    private void invalidValue(int i) throws InvalidnumException {
        if (numOfCycles <= 0) throw new InvalidnumException("Error on Line " + i + ": Number must be greater than zero!!");
    }

    private void emptyLine(String s, int i) throws InvalidLineException {
        if (s.equals("")) throw new InvalidLineException("Error on Line " + i + ": Empty Line");
    }

    private void invalidStrings(String s, int i) throws InvalidStringException {
        if (!s.matches("^[a-zA-Z]*$"))
            throw new InvalidStringException("Error on Line " + i + ": Aircraft name must be a String");
    }

    private void invalidIntegers(String a, String b, String c,  int i) throws InvalidIntegerException {
        if (!a.matches("^[0-9]*$") || !b.matches("^[0-9]*$") || !c.matches("^[0-9]*$")) {
            throw new InvalidIntegerException("Error on Line " + i + ": Coordinate must be an integer");
        }
    }

    private void invalidIntStr(String s, int i) throws InvalidIntStringsException {
        if (!s.matches("^[a-zA-Z0-9]*$")) {
            throw new InvalidIntStringsException("Error on Line " + i + ": Aircraft name must contain a-z / A-Z and 0-9 only");
        }
    }

    private void invalidAircraft(String s, int i) throws InvalidStringException {
        if (!(s.equals("Baloon") || s.equals("JetPlane") || s.equals("Helicopter")))
            throw new InvalidStringException("Error on Line " + i + ": Aircraft type must be \"Baloon\" , \"JetPlane\" or \"Helicopter\" ");
    }
}

