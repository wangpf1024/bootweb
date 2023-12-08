package com.controller.bootweb.demo.dsa;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.io.*;
import java.util.*;

public class ExternalSort {

    public static void externalSort(List<File> files, File output) throws IOException {
        PriorityQueue<LogEntry> priorityQueue = new PriorityQueue<>(Comparator.comparing(LogEntry::getTimestamp));

        // Open readers for each file
        List<BufferedReader> readers = new ArrayList<>();
        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            readers.add(reader);
            // Read the first line from each file and add it to the priority queue
            String line = reader.readLine();
            if (line != null) {
                LogEntry logEntry = new LogEntry(file.getAbsoluteFile().getAbsolutePath(), line);
                priorityQueue.add(logEntry);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            // Process the priority queue until it's empty
            while (!priorityQueue.isEmpty()) {
                LogEntry currentEntry = priorityQueue.poll();
                writer.write(currentEntry.getLine());
                writer.newLine();
                // Read the next line from the file and add it to the priority queue
                BufferedReader currentReader = readers.get(files.indexOf(new File(currentEntry.getFileName())));
                String nextLine = currentReader.readLine();
                if (nextLine != null) {
                    LogEntry nextLogEntry = new LogEntry(currentEntry.getFileName(), nextLine);
                    priorityQueue.add(nextLogEntry);
                }
            }
        } finally {
            // Close all readers after processing
            for (BufferedReader reader : readers) {
                reader.close();
            }
        }
    }

    // LogEntry class to represent each log entry with timestamp and file name



    private static long getTimestamp(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if(StrUtil.isEmpty(line)){
            return 0;
        }
        String date = line.split(" \\[")[0];
        return DateUtil.parse(date).getTime();// Assuming timestamp is at the beginning of each log entry
    }

    public static void main(String[] args) {
        try {
            List<File> inputFiles = Arrays.asList(
                    new File("/Users/arvin/workspace/logs/log1.txt"),
                    new File("/Users/arvin/workspace/logs/log2.txt")
                    // Add other log files here
            );
            File outputFile = new File("/Users/arvin/workspace/logs/mergedLog.txt");

            externalSort(inputFiles, outputFile);

            System.out.println("Log files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LogEntry {
    private final String fileName;
    private final String line;

    public LogEntry(String fileName, String line) {
        this.fileName = fileName;
        this.line = line;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLine() {
        return line;
    }

    public long getTimestamp() {
        // Implement the logic to extract and return the timestamp from the log entry
        return 0;
    }
}