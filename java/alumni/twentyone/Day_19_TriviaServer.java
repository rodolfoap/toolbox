package org.rap.prgtests.twentyone;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Day_19_TriviaServer extends Thread {
    private static final int WAIT_FOR_CLIENT = 0;
    private static final int WAIT_FOR_ANSWER = 1;
    private static final int WAIT_FOR_CONFIRM = 2;
    private String[] questions;
    private String[] answers;
    private ServerSocket sock;
    private int numQuestions;
    private int num = 0;
    private int state = WAIT_FOR_CLIENT;
    private Random rand = new Random();

    public Day_19_TriviaServer() {
        super("TriviaServer");
        try {
            sock = new ServerSocket(4413);
            System.out.println("TriviaServer up and running ...");
        } catch (IOException e) {
            System.err.println("Error: couldn't create socket.");
            System.exit(1);
        }
    }

    public static void main(String[] arguments) {
    	Day_19_TriviaServer server = new Day_19_TriviaServer();
        server.start();
    }

    public void run() {
        Socket client = null;

        // Initialize the question and answer data
        if (!loadData()) {
            System.err.println("Error: couldn't initialize Q&A data.");
            return;
        }

        // Look for clients and ask trivia questions
        while (true) {
            // Wait for a client
            if (sock == null)
                return;
            try {
                client = sock.accept();
            } catch (IOException e) {
                System.err.println("Error: couldn't connect to client.");
                System.exit(1);
            }

            // Process questions and answers
            try {
                InputStreamReader isr = new InputStreamReader(
                    client.getInputStream());
                BufferedReader is = new BufferedReader(isr);
                PrintWriter os = new PrintWriter(new
                   BufferedOutputStream(client.getOutputStream()), false);
                String outLine;

                // Output server request
                outLine = processInput(null);
                os.println(outLine);
                os.flush();

                // Process and output user input
                while (true) {
                    String inLine = is.readLine();
                    if (inLine.length() > 0)
                        outLine = processInput(inLine);
                    else
                        outLine = processInput("");
                    os.println(outLine);
                    os.flush();
                    if (outLine.equals("Bye."))
                        break;
                }

                // Clean up
                os.close();
                is.close();
                client.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
                e.printStackTrace();
            }
        }
    }

    private boolean loadData() {
        try {
            File inFile = new File("qna.txt");
            FileInputStream inStream = new FileInputStream(inFile);
            byte[] data = new byte[(int)inFile.length()];

            // Read questions and answers into a byte array
            if (inStream.read(data) <= 0) {
                System.err.println("Error: couldn't read q&a.");
                return false;
            }

            // See how many question/answer pairs there are
            for (int i = 0; i < data.length; i++)
                if (data[i] == (byte)'#')
                    numQuestions++;
            numQuestions /= 2;
            questions = new String[numQuestions];
            answers = new String[numQuestions];

            // Parse questions and answers into String arrays
            int start = 0, index = 0;
            boolean isQuestion = true;
            for (int i = 0; i < data.length; i++)
                if (data[i] == (byte)'#') {
                    if (isQuestion) {
                        questions[index] = new String(data, start,
                            i - start);
                        isQuestion = false;
                    } else {
                        answers[index] = new String(data, start,
                            i - start);
                        isQuestion = true;
                        index++;
                    }
                start = i + 3;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Exception: couldn't find the Q&A file.");
            return false;
        } catch (IOException e) {
            System.err.println("Exception: couldn't read the Q&A file.");
            return false;
        }
        return true;
    }

    String processInput(String inStr) {
        String outStr = null;

        switch (state) {
            case WAIT_FOR_CLIENT:
                // Ask a question
                outStr = questions[num];
                state = WAIT_FOR_ANSWER;
                break;

            case WAIT_FOR_ANSWER:
                // Check the answer
                if (inStr.equalsIgnoreCase(answers[num]))
                    outStr="\015\012That's correct! Want another (y/n)?";
                else
                    outStr="\015\012Wrong, the correct answer is "
                        + answers[num] +". Want another (y/n)?";
                state = WAIT_FOR_CONFIRM;
                break;

            case WAIT_FOR_CONFIRM:
                // See if they want another question
                if (!inStr.equalsIgnoreCase("N")) {
                    num = Math.abs(rand.nextInt()) % questions.length;
                    outStr = questions[num];
                    state = WAIT_FOR_ANSWER;
                } else {
                    outStr = "Bye.";
                    state = WAIT_FOR_CLIENT;
                }
                break;
        }
        return outStr;
    }
}
