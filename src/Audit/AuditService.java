package Audit;

import java.io.*;
import java.util.Date;


public class AuditService {
    private File auditFile;
    private FileWriter auditWriter;

    private static AuditService instance = null;

    public static AuditService getInstance() {
        if (instance == null)
            instance = new AuditService();

        return instance;
    }

    private AuditService() {
        auditFile = new File("src/CSV/audit.csv");
    }

    public void writeAudit(String msg) {
        try {
            auditWriter = new FileWriter("src/CSV/audit.csv", true);
            PrintWriter pw = new PrintWriter(auditWriter);

            pw.println(msg + ", " + new Date());

            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Could not audit");
        }
    }
}